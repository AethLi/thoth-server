package cn.aethli.thoth.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-23 18:02
 **/
public interface DataGetTaskService {

  void getPELotteries(String type, String startTerm, String num, String endTerm) throws IOException;

  void getCWLLotteries(String type, String startTerm, String num, String endTerm);
}
