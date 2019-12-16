package cn.aethli.thoth.common.utils;

import cn.aethli.lunar.LunarDate;
import cn.aethli.lunar.LunarDate.LeapType;
import cn.aethli.lunar.exception.LunarException;
import java.time.LocalDate;

/**
 * @author Termite
 */
public class DateUtils {

  public static LocalDate getChineseNewYear(int year) throws LunarException {
    return LunarDate.ofDay(year, 1, 1, LeapType.NOT_LEAP).getGregorianDate();
  }
}
