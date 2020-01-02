package cn.aethli.thoth.controller;

import cn.aethli.thoth.common.enums.ResponseStatus;
import cn.aethli.thoth.common.exception.RetryException;
import cn.aethli.thoth.model.ResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Termite
 */
@Slf4j
@RestControllerAdvice
public class GlobeExceptionController {

  /**
   * 全局所有controller默认异常处理
   *
   * @param e
   * @return
   */
  @ExceptionHandler(value = Exception.class)
  public Object exceptionCatch(Exception e) {
    log.error(e.toString());
    e.printStackTrace();
    return new ResponseModel(ResponseStatus.ERROR, e.getMessage());
  }

  /**
   * 重试异常
   *
   * @param e
   * @return
   */
  @ExceptionHandler(value = RetryException.class)
  public Object retryExceptionCatch(RetryException e) {
    log.error("重试结束,未连接成功,url:{}", e.getUrl());
    return new ResponseModel(ResponseStatus.ERROR, e.getMessage());
  }
}
