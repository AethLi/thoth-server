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

  @Column(name = "update_dt", nullable = false)
  private Date updateDt;

  @Column(name = "type", nullable = false)
  private VersionType type;

  public DataVersion() {
    // 默认为1时间
    updateDt = new Date(946656000000L);
  }

  public DataVersion(String version, VersionType type) {
    // 默认为1时间
    updateDt = new Date(946656000000L);
    this.version = version;
    this.type = type;
  }
}
