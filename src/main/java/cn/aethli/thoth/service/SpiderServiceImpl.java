package cn.aethli.thoth.service;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @device: Apollo
 * @author: SpiderServiceImpl
 * @date: 2019/9/17
 */
@Slf4j
@Service
public class SpiderServiceImpl implements SpiderService {

  private static final String com500 = "https://kaijiang.500.com/shtml/";
  @Autowired private OkHttpClient okHttpClient;

  @Override
  public Map<String, Object> getCom500Data(String type, int term) {
    StringBuilder url = new StringBuilder(com500);
    url.append(type);
    url.append("/");
    url.append(term);
    url.append(".shtml");
    Request request = new Request.Builder().url(url.toString()).build();
    log.info("connect to url:" + url.toString());
    Response response;
    int readSize = 0;
    Map<String, Object> result = null;
    try {
      response = okHttpClient.newCall(request).execute();
      InputStream inputStream = response.body().byteStream();
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      byte[] bytes = new byte[2000];
      while ((readSize = inputStream.read(bytes)) >= 0) {
        byteArrayOutputStream.write(bytes, 0, readSize);
      }
      Document document = Jsoup.parse(byteArrayOutputStream.toString("GBK"));
      result = new HashMap<>();
      Elements kj_main01_right = document.getElementsByClass("kj_main01_right");
      if (!kj_main01_right.isEmpty()){
        Elements ball_box01 = kj_main01_right.get(0).getElementsByClass("ball_box01");

      }
      if (type == "ssq") {}

    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }
}
