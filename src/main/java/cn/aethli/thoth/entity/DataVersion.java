package cn.aethli.thoth.entity;

import cn.aethli.thoth.common.enums.VersionType;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author Termite
 * @device Hades
 * @date 2019-12-03 10:42
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

  @Column(name = "create_dt", nullable = false)
  private Date createDt;

  @Column(name = "type", nullable = false)
  private VersionType type;

  public DataVersion() {
    createDt = new Date();
  }

  public DataVersion(String version, VersionType type) {
    createDt = new Date();
    this.version = version;
    this.type = type;
  }
}
