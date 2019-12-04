package cn.aethli.thoth.repository;

import cn.aethli.thoth.common.enums.VersionType;
import cn.aethli.thoth.entity.DataVersion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Termite
 * @device Hades
 * @date 2019-12-04 10:07
 */
public interface DataVersionRepository
    extends JpaRepository<DataVersion, String>, JpaSpecificationExecutor<DataVersion> {

  @Query("from DataVersion d where d.type=:type")
  Optional<DataVersion> findByType(@Param("type") VersionType type);
}
