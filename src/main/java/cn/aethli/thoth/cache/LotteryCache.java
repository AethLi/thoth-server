package cn.aethli.thoth.cache;

import cn.aethli.thoth.common.enums.LotteryType;
import cn.aethli.thoth.dto.Lottery;
import java.util.List;

/**
 * @author Termite
 * @device Hades
 * @date 2019-12-02 16:26
 */
public interface LotteryCache {

  List<Lottery> getLottery(LotteryType type);
}
