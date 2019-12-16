package cn.aethli.thoth.common.utils;

import cn.aethli.lunar.exception.LunarException;
import cn.aethli.thoth.common.enums.LotteryExceptionType;
import cn.aethli.thoth.common.enums.LotteryType;
import cn.aethli.thoth.common.exception.LotteryException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/** @author Termite */
@Slf4j
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
   * @param currentDay
   * @param type
   * @return
   */
  public static String date2Term(LocalDate currentDay, LotteryType type)
      throws LotteryException, LunarException {
    switch (type) {
      case QXC:
        LocalDate firstDayOfYear = LocalDate.of(currentDay.getYear(), 1, 1);
        int baseTerm = Integer.parseInt(String.valueOf(currentDay.getYear()).substring(2));
        int weekCount = currentDay.get(WeekFields.of(DayOfWeek.MONDAY, 1).weekOfYear());
        weekCount -= 1;
        DayOfWeek dayOfWeek = firstDayOfYear.getDayOfWeek();
        // 第一周的偏移量
        int offset = 1;
        switch (dayOfWeek) {
          case MONDAY:
          case TUESDAY:
            break;
          case WEDNESDAY:
          case THURSDAY:
          case FRIDAY:
            offset -= 1;
            break;
          case SATURDAY:
          case SUNDAY:
            offset -= 2;
            break;
        }
        // 当前周的偏移量
        dayOfWeek = currentDay.getDayOfWeek();
        switch (dayOfWeek) {
          case MONDAY:
          case TUESDAY:
            break;
          case WEDNESDAY:
          case THURSDAY:
          case FRIDAY:
            offset += 1;
            break;
          case SATURDAY:
          case SUNDAY:
            offset += 2;
            break;
        }
        // 春节的偏移量
        LocalDate 春节 = DateUtils.getChineseNewYear(currentDay.getYear());
        LocalDate 初七 = 春节.plusDays(6);
        if (初七.isBefore(currentDay)) {
          offset -= 3;
        } else if (春节.isAfter(currentDay)) {
        } else if (初七.isAfter(currentDay) && 春节.isBefore(currentDay)) {
          dayOfWeek = 春节.getDayOfWeek();
          offset -= 3; // todo 暂时留一个时间计算的bug
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
