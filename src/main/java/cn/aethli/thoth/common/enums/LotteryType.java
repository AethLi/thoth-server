package cn.aethli.thoth.common.enums;

/**
 * @author Termite
 * @device Hades
 * @date 2019-10-29 15:48
 */
public enum LotteryType {
  SSQ("双色球", 0, "ssq"),
  TD("3d", 1, "td"),
  QLC("七乐彩", 2, "qlc"),
  QXC("七星彩", 3, "8");

  String desc;
  int value;
  String param;

  LotteryType(String desc, int value, String param) {
    this.desc = desc;
    this.value = value;
    this.param = param;
  }

  public static LotteryType get(int value) {
    for (LotteryType type : LotteryType.values()) {
      if (type.value == value) {
        return type;
      }
    }
    throw new IllegalArgumentException("argument error: " + value);
  }

  public static LotteryType get(String param) {
    for (LotteryType type : LotteryType.values()) {
      if (type.param.equals(param)) {
        return type;
      }
    }
    throw new IllegalArgumentException("argument error: " + param);
  }

  public int getValue() {
    return this.value;
  }

  public String getParam() {
    return param;
  }

  public String getDesc() {
    return this.desc;
  }
}
