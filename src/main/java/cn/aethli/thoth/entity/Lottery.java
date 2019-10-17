package cn.aethli.thoth.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author Termite
 * @device Hades
 * @date 2019-10-16 14:51
 **/
@MappedSuperclass
@Data
public abstract class Lottery {
  @Id
  @Column(name = "id", length = 32)
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
  private String id;
}
