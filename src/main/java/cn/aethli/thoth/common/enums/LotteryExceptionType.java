package cn.aethli.thoth.common.enums;

/**
 * @author Termite
 * @device Hades
 * @date 2019-12-03 09:18
 */
public enum LotteryExceptionType {
  TYPE("类别错误"),
  LENGTH("长度错误"),
  UNKNOWN("未知");
  String desc;

  LotteryExceptionType(String desc) {
    this.desc = desc;
  }

  public String getDesc() {
    return this.desc;
  }
}
