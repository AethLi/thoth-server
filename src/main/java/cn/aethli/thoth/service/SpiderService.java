package cn.aethli.thoth.service;

import java.util.Map;

/**
 * @device: Apollo
 * @author: 93162
 * @date: 2019-09-17 00：00
 */
public interface SpiderService {

  Map<String,Object> getCom500Data(String type, int term);
}
