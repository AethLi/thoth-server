package cn.aethli.thoth.service;

import cn.aethli.thoth.common.enums.LotteryType;
import cn.aethli.thoth.common.exception.RetryException;
import cn.aethli.thoth.dto.Lottery;
import java.io.IOException;

/**
 * @author Termite
 */
public interface DataGetTaskService {
  /**
   * 从体彩官网获取数据
   *
   * @param type 种类
   * @param startTerm
   * @param num
   * @param endTerm
   * @throws IOException
   */
  void getPELotteries(String type, String startTerm, String num, String endTerm) throws IOException;

  /**
   * 从福彩官网获取数据
   *
   * @param name
   * @param issueStart
   * @param issueEnd
   * @param issueCount
   */
  void getCWLLotteries(String name, String issueStart, String issueEnd, String issueCount);

  /**
   * 从kaijiang.500.com上获取数据
   *
   * @param type
   * @param startTerm
   * @param endTerm
   * @throws RetryException
   */
  void getCom500Data(String type, String startTerm, String endTerm) throws RetryException;

  /**
   * 请求一次官网，获取最新的期数
   *
   * @param ssq
   * @return
   */
  Lottery getPELotteryThisTerm(LotteryType type);
}
