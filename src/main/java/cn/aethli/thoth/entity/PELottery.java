package cn.aethli.thoth.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import lombok.Data;

/**
 * @author Termite
 */
@Data
@Table(
    name = "pe_lottery",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"term", "l_type"})})
@Entity
@JsonIgnoreProperties(
    ignoreUnknown = true,
    value = {"openTime", "peDetails"})
public class PELottery extends Lottery {

  public static final DateTimeFormatter DATE_TIME_FORMATTER =
      DateTimeFormatter.ofPattern("yyyyMMdd");

  @Transient
  @JsonProperty(value = "drawNews")
  private String drawNews;

  @Transient
  @JsonProperty(value = "fTime")
  private String fTime;

  @Transient
  @JsonProperty(value = "isAP")
  private Integer isAP;

  @Transient
  @JsonProperty(value = "ispool")
  private Integer isPool;

  @Column(name = "l_type")
  @JsonProperty(value = "lType")
  private Integer lType;

  @Transient
  @JsonProperty(value = "numSequence")
  private String numSequence;

  @Column(name = "num_sequence_pool")
  @JsonProperty(value = "numSequence_pool")
  private String numSequencePool;

  @Column(name = "number")
  @JsonProperty(value = "number")
  private String number;

  @Column(name = "number_pool")
  @JsonProperty(value = "number_pool")
  private String numberPool;

  @Column(name = "open_time")
  private LocalDate openTime;

  @Transient
  @JsonProperty(value = "openTime_fmt")
  private String openTimeFmt;

  @Transient
  @JsonProperty(value = "openTime_fmt1")
  private String openTimeFmt1;

  @Column(name = "pool")
  @JsonProperty(value = "pool")
  private String pool;

  @Column(name = "start_time")
  @JsonProperty(value = "sTime")
  private String sTime;

  @Transient
  @JsonProperty(value = "status")
  private Integer status;

  @Column(name = "term")
  @JsonProperty(value = "term")
  private String term;

  @Column(name = "total_sales")
  @JsonProperty(value = "totalSales")
  private String totalSales;

  @Column(name = "total_sales2")
  @JsonProperty(value = "totalSales2")
  private String totalSales2;

  @Transient
  @JsonProperty(value = "totlSaleNews")
  private String totalSaleNews;

  @Transient
  @JsonProperty(value = "verify")
  private Integer verify;

  @OneToMany(mappedBy = "peLottery", cascade = CascadeType.ALL)
  private List<PEDetail> peDetails;

  /**
   * 去除空格
   *
   * @param number
   */
  public void setNumber(String number) {
    this.number = number.replace(" ", "");
  }

  /**
   * 将openTimeFmt1也反序列化到openTime
   *
   * @param openTimeFmt1
   */
  public void setOpenTimeFmt1(String openTimeFmt1) {
    try {
      this.openTime = LocalDate.parse(openTimeFmt1, DATE_TIME_FORMATTER);
    } catch (DateTimeParseException e) {
      e.printStackTrace();
    }
    this.openTimeFmt1 = openTimeFmt1;
  }
}
