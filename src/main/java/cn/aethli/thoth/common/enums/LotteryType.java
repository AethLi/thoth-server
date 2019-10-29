package cn.aethli.thoth.common.enums;

/**
 * @author Termite
 * @device Hades
 * @date 2019-10-29 15:48
 */
public enum LotteryType {
  SSQ("双色球", 0),
  TD("3d", 1),
  QLC("七乐彩", 2),
  QXC("七星彩", 3);

  String desc;
  int value;

  LotteryType(String desc, int value) {
    this.desc = desc;
    this.value = value;
  }

  public static LotteryType get(int value) {
    for (LotteryType type : LotteryType.values()) {
      if (type.value == value) {
        return type;
      }
    }
    throw new IllegalArgumentException("argument error: " + value);
  }

  public int getValue() {
    return this.value;
  }

  public String getDesc() {
    return this.desc;
  }
}
