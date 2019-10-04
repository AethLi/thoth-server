package cn.aethli.thoth.service;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
  @Async
  public void getCom500Data(String type, int term) {
    StringBuilder url = new StringBuilder(com500);
    url.append(type);
    url.append("/");
    url.append(term);
    url.append(".shtml");
    Request request = new Request.Builder().url(url.toString()).build();
    log.info("connect to url:" + url.toString());
    Response response;
    int readSize = 0;
    try {
      response = okHttpClient.newCall(request).execute();
      InputStream inputStream = response.body().byteStream();
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      byte[] bytes = new byte[2000];
      while ((readSize = inputStream.read(bytes)) >= 0) {
        byteArrayOutputStream.write(bytes, 0, readSize);
      }
      System.out.println(byteArrayOutputStream.toString("GBK"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
