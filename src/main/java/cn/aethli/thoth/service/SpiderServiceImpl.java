package cn.aethli.thoth.service;

import cn.aethli.thoth.common.utils.StringUtils;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @device: Apollo
 * @author: SpiderServiceImpl
 * @date: 2019/9/17
 */
@Service
public class SpiderServiceImpl implements SpiderService {

  private static final String com500 = "https://kaijiang.500.com/shtml/";
  @Autowired
  private OkHttpClient okHttpClient;

  @Override
  @Async
  public void getCom500Data(String type, int term) {
    StringBuilder url = new StringBuilder(com500);
    url.append(type);
    url.append("/");
    url.append(term);
    url.append(".shtml");
    Request request = new Request.Builder().url(url.toString()).build();
    Response response;
    String result = null;
    String s = null;
    try {
      response = okHttpClient.newCall(request).execute();
      result = response.body().string();
      s = StringUtils.gb2312ToUtf8(result);
    } catch (IOException e) {
      e.printStackTrace();
    }
//    System.out.println(result);
    System.out.println(s);
  }
}
