package cn.aethli.thoth.entity;

import cn.aethli.thoth.common.enums.VersionType;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author Termite

 */
@Entity
@Data
@Table(name = "data_version")
public class DataVersion {
  @Id
  @Column(name = "id", length = 36)
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
  private String id;

  @Column(name = "version", nullable = false)
  private String version;

  @Column(name = "update_dt", nullable = false)
  private LocalDate updateDt;

  @Column(name = "type", nullable = false)
  private VersionType type;

  public DataVersion() {
  }

  public DataVersion(String version, VersionType type) {
    this.version = version;
    this.type = type;
  }
}
