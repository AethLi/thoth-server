package cn.aethli.thoth.common.exception;

import cn.aethli.thoth.common.enums.LotteryExceptionType;
import cn.aethli.thoth.dto.Lottery;

/**
 * @author Termite
 * @device Hades
 * @date 2019-12-02 17:56
 */
public class LotteryException extends Exception {

  private LotteryExceptionType type = LotteryExceptionType.UNKNOWN;
  private String log;
  private Lottery lottery;

  public LotteryException(LotteryExceptionType type, String log, Lottery lottery) {
    this.type = type;
    this.log = log;
    this.lottery = lottery;
  }

  public LotteryException(String message, LotteryExceptionType type, String log,
      Lottery lottery) {
    super(message);
    this.type = type;
    this.log = log;
    this.lottery = lottery;
  }

  public LotteryException(String message, Throwable cause,
      LotteryExceptionType type, String log, Lottery lottery) {
    super(message, cause);
    this.type = type;
    this.log = log;
    this.lottery = lottery;
  }

  public LotteryException(Throwable cause, LotteryExceptionType type, String log,
      Lottery lottery) {
    super(cause);
    this.type = type;
    this.log = log;
    this.lottery = lottery;
  }

  public LotteryException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace, LotteryExceptionType type, String log,
      Lottery lottery) {
    super(message, cause, enableSuppression, writableStackTrace);
    this.type = type;
    this.log = log;
    this.lottery = lottery;
  }

  public LotteryException(LotteryExceptionType type, String log) {
    this.type = type;
    this.log = log;
  }

  public LotteryException(String message, LotteryExceptionType type, String log) {
    super(message);
    this.type = type;
    this.log = log;
  }

  public LotteryException(String message, Throwable cause, LotteryExceptionType type, String log) {
    super(message, cause);
    this.type = type;
    this.log = log;
  }

  public LotteryException(Throwable cause, LotteryExceptionType type, String log) {
    super(cause);
    this.type = type;
    this.log = log;
  }

  public LotteryException(
      String message,
      Throwable cause,
      boolean enableSuppression,
      boolean writableStackTrace,
      LotteryExceptionType type,
      String log) {
    super(message, cause, enableSuppression, writableStackTrace);
    this.type = type;
    this.log = log;
  }

  public LotteryException(LotteryExceptionType type) {
    this.type = type;
  }

  public LotteryException(String message, LotteryExceptionType type) {
    super(message);
    this.type = type;
  }

  public LotteryException(String message, Throwable cause, LotteryExceptionType type) {
    super(message, cause);
    this.type = type;
  }

  public LotteryException(Throwable cause, LotteryExceptionType type) {
    super(cause);
    this.type = type;
  }

  public LotteryException(
      String message,
      Throwable cause,
      boolean enableSuppression,
      boolean writableStackTrace,
      LotteryExceptionType type) {
    super(message, cause, enableSuppression, writableStackTrace);
    this.type = type;
  }
}
