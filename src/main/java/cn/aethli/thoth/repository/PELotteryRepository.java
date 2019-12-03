package cn.aethli.thoth.repository;

import cn.aethli.thoth.entity.PELottery;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-26 10:46
 */
@Repository("LotteryRepository")
public interface PELotteryRepository
    extends JpaRepository<PELottery, String>, JpaSpecificationExecutor<PELottery> {

  @Cacheable
  @Query("FROM PELottery p WHERE p.lType=:type sorted by openTime desc")
  List<PELottery> findByType(@Param("type") String type);
}
