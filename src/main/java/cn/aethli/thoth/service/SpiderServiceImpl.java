package cn.aethli.thoth.service;

import cn.aethli.thoth.common.exception.RetryException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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

  public Map<String, Object> getCom500Data(String type, int term, int retryCount)
      throws RetryException {
    StringBuilder url = new StringBuilder(com500);
    url.append(type);
    url.append("/");
    url.append(term);
    url.append(".shtml");
    Request request = new Request.Builder().url(url.toString()).build();
    if (retryCount >= retryTimes) {
      throw new RetryException(url.toString());
    }
    log.info("connect to url:" + url.toString());
    Response response;
    int readSize = 0;
    Map<String, Object> result = null;
    try {
      try {
        response = okHttpClient.newCall(request).execute();
      } catch (SocketTimeoutException e) {
        // 重试
        log.warn("连接失败，重试第%s次", retryCount + 1);
        return getCom500Data(type, term, retryCount + 1);
      }
      InputStream inputStream = response.body().byteStream();
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      byte[] bytes = new byte[2000];
      while ((readSize = inputStream.read(bytes)) >= 0) {
        byteArrayOutputStream.write(bytes, 0, readSize);
      }
      Document document = Jsoup.parse(byteArrayOutputStream.toString("GBK"));
      result = new HashMap<>();
      if (type.equals("ssq")) {
        result.put("red", document.getElementsByClass("ball_red").text().replace(" ", ","));
        result.put("blue", document.getElementsByClass("ball_blue").text());
        log.info("get red balls:%s,get blue balls:%s", result.get("red"), result.get("blue"));
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public Map<String, Object> getCom500Data(String type, int term) throws RetryException {
    return this.getCom500Data(type, term, 0);
  }
}
