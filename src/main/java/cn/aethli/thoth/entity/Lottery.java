package cn.aethli.thoth.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-23 11:06
 **/
@Data
public class Lottery {

  @JsonProperty(value = "drawNews")
  private String drawNews;
  @JsonProperty(value = "fTime")
  private String fTime;
  @JsonProperty(value = "isAP")
  private String isAP;
  @JsonProperty(value = "ispool")
  private String isPool;
  @JsonProperty(value = "lType")
  private String lType;
  @JsonProperty(value = "numSequence")
  private String numSequence;
  @JsonProperty(value = "numSequence_pool")
  private String numSequencePool;
  @JsonProperty(value = "number")
  private String number;
  @JsonProperty(value = "number_pool")
  private String numberPool;
  @JsonProperty(value = "openTime")
  private Date openTime;
  @JsonProperty(value = "openTime_fmt")
  private String openTimeFmt;
  @JsonProperty(value = "openTime_fmt1")
  private String openTimeFmt1;
  @JsonProperty(value = "pool")
  private String pool;
  @JsonProperty(value = "sTime")
  private String sTime;
  @JsonProperty(value = "status")
  private String status;
  @JsonProperty(value = "term")
  private String term;
  @JsonProperty(value = "totalSales")
  private String totalSales;
  @JsonProperty(value = "totalSales2")
  private String totalSales2;
  @JsonProperty(value = "totlSaleNews")
  private String totalSaleNews;
  @JsonProperty(value = "verify")
  private String verify;

}
