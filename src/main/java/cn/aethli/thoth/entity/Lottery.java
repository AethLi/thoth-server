package cn.aethli.thoth.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author Termite

 */
@MappedSuperclass
@Data
public abstract class Lottery {
  @Id
  @Column(name = "id", length = 36)
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
  private String id;
}
