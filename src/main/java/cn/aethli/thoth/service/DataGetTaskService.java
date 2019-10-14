package cn.aethli.thoth.service;

import java.io.IOException;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-23 18:02
 */
public interface DataGetTaskService {
  /**
   * 从体彩官网获取数据
   * @param type 种类
   * @param startTerm
   * @param num
   * @param endTerm
   * @throws IOException
   */
  void getPELotteries(String type, String startTerm, String num, String endTerm) throws IOException;

  /**
   * 从福彩官网获取数据
   * @param name
   * @param issueStart
   * @param issueEnd
   * @param issueCount
   */
  void getCWLLotteries(String name, String issueStart, String issueEnd, String issueCount);

  /**
   * 从kaijiang.500.com上获取数据
   * @param type
   * @param startTerm
   * @param endTerm
   */
  void getCom500Data(String type, String startTerm, String endTerm);
}
