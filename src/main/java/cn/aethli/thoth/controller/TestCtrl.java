package cn.aethli.thoth.controller;

import cn.aethli.thoth.common.enums.ResponseStatus;
import cn.aethli.thoth.model.ResponseModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Termite
 * @device Hades
 * @date 2019-10-30 11:25
 */
@RestControllerAdvice
@RequestMapping("/test")
public class TestCtrl {

  @GetMapping
  public Object doGet() {
    return new ResponseModel(ResponseStatus.OK);
  }
}
