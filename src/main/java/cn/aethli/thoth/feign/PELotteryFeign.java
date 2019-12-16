package cn.aethli.thoth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Termite
 **/
@FeignClient(url = "http://m.lottery.gov.cn", name = "pe")
public interface PELotteryFeign {

  /**
   * 体彩
   *
   * @param _ltype:彩票种类:七星彩(8)
   * @param _term:查询开始期号
   * @param _num:查询条数
   * @return
   */
  @RequestMapping(value = "/api/mlottery_kj_detail.jspx", method = RequestMethod.GET)
  String getLottery(@RequestParam("_ltype") String _ltype,
      @RequestParam("_term") String _term,
      @RequestParam("_num") String _num);

  @RequestMapping(value = "/api/mlottery_kj_detail.jspx", method = RequestMethod.GET)
  String getLottery(@RequestParam("_ltype") String type,
      @RequestParam("_num") String _num);
}
