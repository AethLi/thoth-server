package cn.aethli.thoth.controller;

import cn.aethli.thoth.model.ResponseModel;
import java.util.Map;
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

  @RequestMapping("dataGet")
  public Object dataGet(@RequestBody Map<String, String> params) {
    if (params.get("password").equals("nviebrei")) {
      return new ResponseModel(ResponseModel.STATUS_OK, "task start");
    } else {
      return new ResponseModel(ResponseModel.STATUS_ERROR, "wrong password");
    }
  }
}
