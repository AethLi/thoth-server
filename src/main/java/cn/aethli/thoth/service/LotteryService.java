package cn.aethli.thoth.service;

import cn.aethli.thoth.common.enums.LotteryType;
import java.util.List;
import java.util.Map;

/**
 * @author Termite
 * @device Hades
 * @date 2019-10-29 15:53
 **/
public interface LotteryService {

  List<Map<String,String>> getNewest(LotteryType type);
}
