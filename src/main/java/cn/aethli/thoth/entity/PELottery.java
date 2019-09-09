package cn.aethli.thoth.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-23 11:06
 **/
@Data
@Table(name = "pe_lottery",uniqueConstraints = {@UniqueConstraint(columnNames = {"term","l_type"})})
@Entity
@JsonIgnoreProperties(ignoreUnknown = true, value = {"openTime", "peDetails"})
public class PELottery {

  public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

  @Id
  @Column(name = "pe_lottery_id", length = 32)
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
  private String id;
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
  private Date openTime;
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
  @Column(name = "totalSales")
  @JsonProperty(value = "totalSales")
  private String totalSales;
  @Column(name = "totalSales2")
  @JsonProperty(value = "totalSales2")
  private String totalSales2;
  @Transient
  @JsonProperty(value = "totlSaleNews")
  private String totalSaleNews;
  @Transient
  @JsonProperty(value = "verify")
  private Integer verify;
  @OneToMany(mappedBy = "peLottery",cascade = CascadeType.ALL)
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
      this.openTime = dateFormat.parse(openTimeFmt1);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    this.openTimeFmt1 = openTimeFmt1;
  }
}
