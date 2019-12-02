package cn.aethli.thoth.dto;

import cn.aethli.thoth.common.enums.LotteryType;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;

/**
 * @author Termite
 * @device Hades
 * @date 2019-12-02 16:33
 */
@Data
public class Lottery {

  @JsonProperty("values")
  String values;

  @JsonProperty("type")
  LotteryType type;

  @JsonProperty("date")
  Date checkDate;

  public Lottery() {
    super();
    checkDate = new Date();
  }
}
