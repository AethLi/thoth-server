package cn.aethli.thoth.common.utils;

import java.io.UnsupportedEncodingException;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-26 13:58
 **/
public class StringUtils {

  /**
   * 将term转换为请求所需五位数
   *
   * @param term
   * @return
   */
  public static String termParamsConvert(String term) {
    if (term.length() < 5) {
      term = "0" + term;
    }
    return term;
  }

  /**
   * 体彩跳到下一个需要爬取的期数
   *
   * @param term
   * @param num
   * @return
   */
  public static String peTermJump(String type, String term, String num) {
    //七星彩处理
    if ("8".equals(type) && Integer.parseInt(term.substring(term.length() - 3)) >= 300) {
      return String
          .valueOf((Integer.parseInt(term.substring(0, term.length() - 3)) + 1) * 1000);
    } else {
      return String.valueOf(Integer.parseInt(term) + Integer.parseInt(num));
    }
  }

  /**
   * 福彩跳到下一期
   *
   * @param name
   * @param issueStart
   * @param issueCount
   * @return
   */
  public static String cwlIssueJump(String name, String issueStart, String issueCount) {
    if ("ssq".equals(name)
        && Integer.parseInt(issueStart.substring(issueStart.length() - 3)) >= 300) {
      return String
          .valueOf((Integer.parseInt(issueStart.substring(0, issueStart.length() - 3)) + 1) * 1000);
    } else {
      return String.valueOf(Integer.parseInt(issueStart) + Integer.parseInt(issueCount));
    }
  }

  public static String gb2312ToUtf8(String res) throws UnsupportedEncodingException {
    return new String(res.getBytes("gb2312"),"utf8");
  }

}
