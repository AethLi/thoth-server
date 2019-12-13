package cn.aethli.thoth.common.utils;

import cn.aethli.thoth.common.enums.LotteryExceptionType;
import cn.aethli.thoth.common.enums.LotteryType;
import cn.aethli.thoth.common.exception.LotteryException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
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
  public static List<String> resolve(LotteryType type, String lotteryValue)
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
      default:
        throw new LotteryException(LotteryExceptionType.TYPE);
    }
  }

  /**
   * 根据日期获取期号
   *
   * @param date
   * @param type
   * @return
   */
  public static String date2Term(Date date, LotteryType type) throws LotteryException {
    Calendar currentCal = Calendar.getInstance();
    currentCal.setTime(date);
    switch (type) {
      case QXC:
        Calendar firstDayOfYear = Calendar.getInstance();
        firstDayOfYear.set(Calendar.DAY_OF_YEAR, 0);
        int baseTerm = Integer.parseInt(String.valueOf(currentCal.get(Calendar.YEAR)).substring(2));
        int weekCount = currentCal.get(Calendar.WEEK_OF_YEAR);
        weekCount -= 1;
        int offsetDay = firstDayOfYear.get(Calendar.DAY_OF_WEEK);
        int offset = 1;
        if (offsetDay == Calendar.SUNDAY) {
          offset -= 2;
        } else if (offsetDay > Calendar.SUNDAY && offsetDay <= Calendar.TUESDAY) {

        } else if (offsetDay > Calendar.TUESDAY && offsetDay <= Calendar.FRIDAY) {
          offset -= 1;
        } else if (offsetDay > Calendar.FRIDAY) {
          offset -= 2;
        }
        offsetDay = currentCal.get(Calendar.DAY_OF_WEEK);
        if (offsetDay == Calendar.SUNDAY) {
          offset += 2;
        } else if (offsetDay > Calendar.SUNDAY && offsetDay <= Calendar.TUESDAY) {

        } else if (offsetDay > Calendar.TUESDAY && offsetDay <= Calendar.FRIDAY) {
          offset += 1;
        } else if (offsetDay > Calendar.FRIDAY) {
          offset += 2;
        }
        return String.valueOf(baseTerm * 1000 + weekCount * 3 + offset);
      case QLC:
      case SSQ:
      case TD:
      default:
        throw new LotteryException(LotteryExceptionType.TYPE);
    }
  }
}
