package cn.aethli.thoth.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-23 11:02
 **/
@Data
public class Detail {

  @JsonProperty(value = "allmoney")
  private String allMoney;
  @JsonProperty(value = "level")
  private String level;
  @JsonProperty(value = "money")
  private String money;
  @JsonProperty(value = "num")
  private String num;
  @JsonProperty(value = "piece")
  private String piece;
  @JsonProperty(value = "sendPrize")
  private String sendPrize;
}
