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
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-09-02 11:55
 **/
@Data
@Entity
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true, value = {"prizeGrades", "open_time"})
@Table(name = "cwl_lottery",uniqueConstraints = {@UniqueConstraint(columnNames = {"code","name"})})
public class CWLResult {

  public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

  @Id
  @Column(name = "cwl_lottery_id", length = 32)
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
  private String id;
  @Column(name = "name", length = 15)
  @JsonProperty(value = "name")
  private String name;
  @Column(name = "code")
  @JsonProperty(value = "code")
  private String code;
  @Column(name = "details_link")
  @JsonProperty(value = "detailsLink")
  private String detailsLink;
  @Column(name = "video_link")
  @JsonProperty(value = "videoLink")
  private String videoLink;
  @Transient
  @JsonProperty(value = "date")
  private String date;
  @Transient
  @JsonProperty(value = "week")
  private String week;
  @Column(name = "red")
  @JsonProperty(value = "red")
  private String red;
  @Column(name = "blue")
  @JsonProperty(value = "blue")
  private String blue;
  @Column(name = "blue2")
  @JsonProperty(value = "blue2")
  private String blue2;
  @Column(name = "sales")
  @JsonProperty(value = "sales")
  private String sales;
  @Column(name = "pool_money")
  @JsonProperty(value = "poolmoney")
  private String poolMoney;
  @Column(name = "content")
  @JsonProperty(value = "content")
  private String content;
  @Transient
  @JsonProperty(value = "addmoney")
  private String addMoney;
  @Transient
  @JsonProperty(value = "addmoney2")
  private String addMoney2;
  @Transient
  @JsonProperty(value = "msg")
  private String msg;
  @Transient
  @JsonProperty(value = "z2add")
  private String z2add;
  @Transient
  @JsonProperty(value = "m2add")
  private String m2add;
  @OneToMany(mappedBy = "cwlResult", cascade = CascadeType.ALL)
  @JsonProperty(value = "prizegrades")
  private List<CWLPrizeGrade> prizeGrades;
  @Column(name = "open_time")
  private Date openTime;

  public void setDate(String date) {
    try {
      this.openTime = dateFormat.parse(date.substring(0,10));
    } catch (ParseException e) {
//      e.printStackTrace();
      log.error(e.getMessage());
    }
    this.date = date;
  }
}
