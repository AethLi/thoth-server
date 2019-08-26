package cn.aethli.thoth.repository;

import cn.aethli.thoth.entity.Lottery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-26 10:46
 **/
@Repository("LotteryRepository")
public interface LotteryRepository extends JpaRepository<Lottery, String>,
    JpaSpecificationExecutor<Lottery> {

}
