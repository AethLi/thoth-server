package cn.aethli.thoth.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-23 10:53
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MData {

  @JsonProperty(value = "codeNumber")
  String[] codeNumber;
  @JsonProperty(value = "details")
  List<PEDetail> details;
  @JsonProperty(value = "lottery")
  PELottery lottery;

  /**
   * json反序列化时将details设置到lottery里面,将lottery设置到details里面
   *
   * @param details
   */
  public void setDetails(List<PEDetail> details) {
    this.details = details;
    if (this.lottery != null) {
      this.lottery.setPeDetails(details);
      this.details.forEach(i -> i.setPeLottery(this.lottery));
    }
  }

  /**
   * json反序列化时将details设置到lottery里面,将lottery设置到details里面
   *
   * @param lottery
   */
  public void setLottery(PELottery lottery) {
    this.lottery = lottery;
    if (this.details != null && !this.details.isEmpty()) {
      this.lottery.setPeDetails(this.details);
      this.details.forEach(i -> i.setPeLottery(lottery));
    }
  }
}
