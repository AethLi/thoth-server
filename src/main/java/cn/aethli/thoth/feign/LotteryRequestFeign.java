package cn.aethli.thoth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-23 11:26
 **/
@FeignClient(url = "http://m.lottery.gov.cn", name = "lottery")
public interface LotteryRequestFeign {

  @RequestMapping(value = "/api/mlottery_kj_detail.jspx", method = RequestMethod.GET)
  public String getLottery(@RequestParam("_ltype") String _ltype,
      @RequestParam("_term") String _term,
      @RequestParam("_num") String _num);
}
