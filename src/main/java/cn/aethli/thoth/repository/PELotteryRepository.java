package cn.aethli.thoth.repository;

import cn.aethli.thoth.entity.PELottery;
import java.util.List;
import java.util.Optional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Termite
 */
public interface PELotteryRepository
    extends JpaRepository<PELottery, String>, JpaSpecificationExecutor<PELottery> {

  @Cacheable
  @Query("FROM PELottery p WHERE p.lType=:type ORDER BY p.openTime DESC")
  List<PELottery> findByLType(@Param("type") Integer type);

  @Cacheable
  @Query(
      "FROM PELottery p WHERE p.openTime=(SELECT MAX(pe.openTime) FROM PELottery pe WHERE pe.lType=:type)")
  Optional<PELottery> findTopByOpenTimeAndLType(@Param("type") Integer type);
}
