package cn.aethli.thoth.common.enums;
/**
 * @device: Apollo
 * @author: 93162
 * @date: 2019/9/26
 */
public enum ResponseEnum {
  OK("正常", 0),
  FAIL("失败", 1),
  ERROR("错误", 2);
  private String desc;
  private int value;

  ResponseEnum(String desc, int value) {
    this.desc = desc;
    this.value = value;
  }
}
