package cn.aethli.thoth.service;

import cn.aethli.thoth.common.exception.RetryException;
import cn.aethli.thoth.entity.CWLPrizeGrade;
import cn.aethli.thoth.entity.CWLResult;
import cn.aethli.thoth.entity.Lottery;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @device: Apollo
 * @author: SpiderServiceImpl
 * @date: 2019/9/17
 */
@Slf4j
@Service
public class SpiderServiceImpl implements SpiderService {

  private static final int retryTimes = 3;
  private static final String com500 = "https://kaijiang.500.com/shtml/";
  @Autowired private OkHttpClient okHttpClient;

  public Lottery getCom500Data(String type, int term, int retryCount) throws RetryException {
    StringBuilder url = new StringBuilder(com500);
    url.append(type);
    url.append("/");
    url.append(String.valueOf(term).length() == 4 ? "0" + term : term);
    url.append(".shtml");
    Request request = new Request.Builder().url(url.toString()).build();
    if (retryCount >= retryTimes) {
      throw new RetryException(url.toString());
    }
    log.info("connect to url:" + url.toString());
    Response response;
    int readSize = 0;
    Lottery lottery = null;
    try {
      try {
        response = okHttpClient.newCall(request).execute();
      } catch (SocketTimeoutException e) {
        // 重试
        log.warn("连接失败，重试第{}次", retryCount + 1);
        return getCom500Data(type, term, retryCount + 1);
      }
      InputStream inputStream = response.body().byteStream();
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      byte[] bytes = new byte[2000];
      while ((readSize = inputStream.read(bytes)) >= 0) {
        byteArrayOutputStream.write(bytes, 0, readSize);
      }
      Document document = Jsoup.parse(byteArrayOutputStream.toString("GBK"));
      if (document.text().contains("404 Not Found")){
        log.warn("404");
        return null;
      }
      if (type.equals("ssq")) {
        CWLResult cwlResult = new CWLResult();
        // 设置code
        cwlResult.setCode("20" + (String.valueOf(term).length() == 4 ? "0" + term : term));
        // 红球
        cwlResult.setRed(document.getElementsByClass("ball_red").text().replace(" ", ","));
        // 蓝球
        cwlResult.setBlue(document.getElementsByClass("ball_blue").text());
        cwlResult.setName("双色球");
        Elements cfont1s = document.getElementsByClass("cfont1");
        // 奖池
        cwlResult.setPoolMoney(cfont1s.get(0).text().replace(",", ""));
        // 销量
        cwlResult.setSales(cfont1s.get(1).text().replace(",", "").replace("元", ""));
        Elements span_rights = document.getElementsByClass("span_right");
        Pattern dataPattern = Pattern.compile("\\d{4}年\\d{1,2}月\\d{1,2}日");
        Matcher dataMatcher = dataPattern.matcher(span_rights.text());
        List<Date> dates = new ArrayList<>();
        while (dataMatcher.find()) {
          dates.add(new SimpleDateFormat("yyyy年MM月dd日").parse(dataMatcher.group(0)));
        }
        try {
          cwlResult.setOpenTime(dates.get(0));
        } catch (IndexOutOfBoundsException e) {
          //          e.printStackTrace();
          log.error("获取开奖时间失败");
        }
        // 第二个才是开奖的详细信息
        Element kj_tablelist02 = document.getElementsByClass("kj_tablelist02").get(1);
        Elements tds = kj_tablelist02.getElementsByTag("td");
        tds.removeIf(element -> element.className().equals("td_title01"));
        tds.removeIf(element -> element.className().equals("td_title02"));
        tds.removeIf(element -> element.text().contains("一期"));
        Iterator<Element> tdsIter = tds.iterator();
        List<CWLPrizeGrade> grades = new ArrayList<>();
        while (tdsIter.hasNext()) {
          CWLPrizeGrade cwlPrizeGrade = new CWLPrizeGrade();
          Element next0 = null;
          try {
            next0 = tdsIter.next();
          } catch (NoSuchElementException e) {
          }
          Element next1 = null;
          try {
            next1 = tdsIter.next();
          } catch (NoSuchElementException e) {
          }
          Element next2 = null;
          try {
            next2 = tdsIter.next();
          } catch (NoSuchElementException e) {
          }
          if (next0.text().contains("一")) {
            cwlPrizeGrade.setType(1);
          } else if (next0.text().contains("二")) {
            cwlPrizeGrade.setType(2);
          } else if (next0.text().contains("三")) {
            cwlPrizeGrade.setType(3);
          } else if (next0.text().contains("四")) {
            cwlPrizeGrade.setType(4);
          } else if (next0.text().contains("五")) {
            cwlPrizeGrade.setType(5);
          } else if (next0.text().contains("六")) {
            cwlPrizeGrade.setType(6);
          }
          cwlPrizeGrade.setTypeNum(next1.text().replace(" ", ""));
          cwlPrizeGrade.setTypeMoney(next2.text().replace(" ", ""));
          cwlPrizeGrade.setCwlResult(cwlResult);
          grades.add(cwlPrizeGrade);
        }
        cwlResult.setPrizeGrades(grades);
        log.info("get red balls:{},get blue balls:{}", cwlResult.getRed(), cwlResult.getBlue());
        lottery = cwlResult;
      }

    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
    return lottery;
  }

  @Override
  public Lottery getCom500Data(String type, int term) throws RetryException {
    return this.getCom500Data(type, term, 0);
  }
}
