package cn.aethli.thoth.service;

import cn.aethli.thoth.common.enums.LotteryType;
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
    return null;
  }
}
