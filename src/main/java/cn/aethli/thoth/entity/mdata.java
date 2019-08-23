package cn.aethli.thoth.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-23 10:53
 **/
@Data
public class mdata {

  @JsonProperty(value = "codeNumber")
  String[] codeNumber;
  @JsonProperty(value = "details")
  List<Detail> details;
  @JsonProperty(value = "lottery")
  Lottery lottery;
}
