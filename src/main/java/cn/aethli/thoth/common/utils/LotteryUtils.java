package cn.aethli.thoth.common.utils;

import cn.aethli.thoth.common.enums.LotteryType;
import cn.aethli.thoth.common.exception.LotteryException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Termite
 * @device Hades
 * @date 2019-12-02 17:47
 */
public class LotteryUtils {
  public static final List<String> qxcPool;

  static {
    qxcPool = new ArrayList<>();
    qxcPool.add("0");
    qxcPool.add("1");
    qxcPool.add("2");
    qxcPool.add("3");
    qxcPool.add("4");
    qxcPool.add("5");
    qxcPool.add("6");
    qxcPool.add("7");
    qxcPool.add("8");
    qxcPool.add("9");
  }
  /**
   * 根据类型判断格式是否正确
   *
   * @param type
   * @param lotteryValue
   * @return
   */
  public static String[] lotteryResolve(LotteryType type, String lotteryValue)
      throws LotteryException {
    String[] numbers = new String[0];
    switch (type) {
      case QXC:
        numbers = lotteryValue.split(",");
        if (numbers.length > 7) {
          throw new LotteryException();
        }
        for (int i = 0; i < numbers.length; i++) {
          if (!qxcPool.contains(numbers[i])) {
            throw new LotteryException();
          }
        }
    }
    return numbers;
  }
}
