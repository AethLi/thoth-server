package cn.aethli.thoth.common.enums;

/**
 * @author Termite
 */
public enum VersionType {
  QXC_UPDATE("七星彩更新",0);

  String desc;
  int value;

  VersionType(String desc, int value) {
    this.desc = desc;
    this.value = value;
  }

  public static VersionType get(int value) {
    for (VersionType type : VersionType.values()) {
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
