package cn.aethli.thoth.service;

import cn.aethli.thoth.common.enums.LotteryType;
import cn.aethli.thoth.dto.Lottery;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * @author Termite
 * @device Hades
 * @date 2019-10-29 15:53
 */
@Service
public class LotteryServiceImpl implements LotteryService {

  @Override
  public List<Map<String, String>> getNewest(LotteryType type) {
    //todo auto-generate
    return null;
  }

  @Override
  public List<Lottery> compare(LotteryType type, List<String> lotteryValues) {
    return null;
  }
}
