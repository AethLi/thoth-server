package cn.aethli.thoth.repository;

import cn.aethli.thoth.common.enums.LotteryType;
import cn.aethli.thoth.entity.PELottery;
import java.util.List;
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

  @Query("from PELottery p where p.l_type=:type")
  List<PELottery> findByType(@Param("type") LotteryType type);
}
