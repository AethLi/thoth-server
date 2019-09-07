package cn.aethli.thoth.controller;

import cn.aethli.thoth.model.ResponseModel;
import cn.aethli.thoth.service.DataGetTaskService;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-23 17:56
 **/
@RestControllerAdvice
@RequestMapping("task")
public class TaskScheduleCtrl {

  @Autowired
  private DataGetTaskService dataGetTaskService;

  /**
   * @param params
   * @return
   * @throws IOException
   */
  @RequestMapping("dataGet")
  public Object dataGet(@RequestBody Map<String, String> params) throws IOException {
    if (params.get("password").equals("nviebrei")) {
      dataGetTaskService
          .getPELotteries(params.get("type"), params.get("startTerm"), params.get("num"),
              params.get("endTerm"));
      return new ResponseModel(ResponseModel.STATUS_OK, "task start");
    } else if (params.get("password").equals("fbuwi")) {
      dataGetTaskService
          .getCWLLotteries(params.get("type"), params.get("startTerm"), params.get("num"),
              params.get("endTerm"));
      return new ResponseModel(ResponseModel.STATUS_OK, "task start");
    } else {
      return new ResponseModel(ResponseModel.STATUS_ERROR, "wrong password");
    }
  }

  @Scheduled(cron = "0 0 22 0 0 2,5,7 ")
  public void qxcDataGetTask() throws IOException {
    dataGetTaskService.getPELotteries("8", "0", "1", "1");
  }
}
