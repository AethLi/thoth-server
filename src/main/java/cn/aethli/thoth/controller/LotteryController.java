package cn.aethli.thoth.controller;

import cn.aethli.thoth.common.enums.LotteryType;
import cn.aethli.thoth.common.exception.LotteryException;
import cn.aethli.thoth.common.utils.LotteryUtils;
import cn.aethli.thoth.service.LotteryService;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-26 14:58
 */
@Slf4j
@RestControllerAdvice
@RequestMapping("lottery")
public class LotteryController {

  @Autowired private LotteryService lotteryService;

  @GetMapping
  public Object doGet(@RequestBody Map<String, String> params) {
    LotteryType type = LotteryType.get(Integer.parseInt(params.get("type")));
    lotteryService.getNewest(type);
    switch (type) {
      case QXC:
        break;
    }
    return null;
  }

  @GetMapping(value = "compare")
  public Object compare(@RequestParam int typeValue, @RequestParam String lotteryValue) {
    LotteryType type = LotteryType.get(typeValue);
    switch (type) {
      case QXC:
        try {
          List<String> lotteryValues = LotteryUtils.resolve(LotteryType.QXC, lotteryValue);
          lotteryService.compare(type, lotteryValues);
        } catch (LotteryException e) {
          log.error(e.getMessage(), e);
        }
        break;
    }
    return null;
  }
}
