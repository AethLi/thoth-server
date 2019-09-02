package cn.aethli.thoth.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-09-02 11:48
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CWLData {

  @JsonProperty(value = "state")
  private Integer state;
  @JsonProperty(value = "message")
  private String message;
  @JsonProperty(value = "pageCount")
  private Integer pageCount;
  @JsonProperty(value = "countNum")
  private Integer countNum;
  @JsonProperty(value = "Tflag")
  private Integer tFlag;
  @JsonProperty(value = "result")
  private List<CWLResult> result;
}
