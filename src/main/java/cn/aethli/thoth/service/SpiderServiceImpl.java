package cn.aethli.thoth.service;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @device: Apollo
 * @author: SpiderServiceImpl
 * @date: 2019/9/17
 */
@Service
public class SpiderServiceImpl implements SpiderService {

  @Autowired private OkHttpClient okHttpClient;

  private static final String com500 = "kaijiang.500.com/shtml";

  @Override
  @Async
  public void getCom500Data(String type, int term) {
    StringBuilder url = new StringBuilder(com500);
    url.append(type);
    url.append("/");
    url.append(term);
    url.append(".shtml");
    Request request = new Request.Builder().url(url.toString()).build();
    Response response = null;
    String result = null;
    try {
      response = okHttpClient.newCall(request).execute();
      result = response.body().string();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(result);
  }
}
