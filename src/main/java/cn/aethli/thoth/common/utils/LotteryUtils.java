package cn.aethli.thoth.common.utils;

import cn.aethli.thoth.common.enums.LotteryExceptionType;
import cn.aethli.thoth.common.enums.LotteryType;
import cn.aethli.thoth.common.exception.LotteryException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Termite
 * @device Hades
 * @date 2019-12-02 17:47
 */
public class LotteryUtils {
  public static final List<String> qxcOptional;

  static {
    qxcOptional = new ArrayList<>();
    qxcOptional.add("0");
    qxcOptional.add("1");
    qxcOptional.add("2");
    qxcOptional.add("3");
    qxcOptional.add("4");
    qxcOptional.add("5");
    qxcOptional.add("6");
    qxcOptional.add("7");
    qxcOptional.add("8");
    qxcOptional.add("9");
  }
  /**
   * 根据类型判断格式是否正确
   *
   * @param type
   * @param lotteryValue
   * @return
   */
  public static List<String> lotteryResolve(LotteryType type, String lotteryValue)
      throws LotteryException {
    List<String> numbers = null;
    switch (type) {
      case QXC:
        numbers = Arrays.asList(lotteryValue.split(","));
        if (numbers.size() > 7) {
          throw new LotteryException(LotteryExceptionType.LENGTH);
        }
        for (String number : numbers) {
          if (!qxcOptional.contains(number)) {
            throw new LotteryException(LotteryExceptionType.TYPE);
          }
        }
        return numbers;
      case TD:
      case SSQ:
      case QLC:
        break;
      default:
        throw new LotteryException(LotteryExceptionType.TYPE);
    }
    return numbers;
  }
}
