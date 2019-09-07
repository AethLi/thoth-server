package cn.aethli.thoth.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-09-02 12:02
 **/
@Entity
@Data
@Table(name = "cwl_prize_grade")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"cwlResult"})
public class CWLPrizeGrade {

  @Id
  @Column(name = "cwl_prize_grade_id", length = 32)
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
  private String id;
  @Column(name = "type", length = 2)
  @JsonProperty(value = "type")
  private Integer type;
  @Column(name = "typeNum", length = 10)
  @JsonProperty(value = "typeNum")
  private String typeNum;
  @Column(name = "typeMoney", length = 20)
  @JsonProperty(value = "typeMoney")
  private String typeMoney;
  @ManyToOne
  @JoinColumn(name = "cwl_result_id")
  private CWLResult cwlResult;
}
