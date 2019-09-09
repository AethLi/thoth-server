package cn.aethli.thoth.service;

import cn.aethli.thoth.entity.CWLData;
import cn.aethli.thoth.entity.CWLResult;
import cn.aethli.thoth.entity.MData;
import cn.aethli.thoth.feign.CWLLotteryFeign;
import cn.aethli.thoth.feign.PELotteryFeign;
import cn.aethli.thoth.repository.CWLLotteryRepository;
import cn.aethli.thoth.repository.PELotteryRepository;
import cn.aethli.thoth.utils.StringUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Iterator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-26 09:34
 **/
@Slf4j
@Service
@EnableAsync
public class DataGetTaskServiceImpl implements DataGetTaskService {

  private ObjectMapper objectMapper = new ObjectMapper();

  @Autowired
  private PELotteryFeign PELotteryFeign;
  @Autowired
  private PELotteryRepository PELotteryRepository;
  @Autowired
  private CWLLotteryFeign cwlLotteryFeign;
  @Autowired
  private CWLLotteryRepository cwlLotteryRepository;

  @Async
  @Override
  public void getPELotteries(String type, String startTerm, String num, String endTerm)
      throws IOException {
    while (Integer.parseInt(startTerm) <= Integer.parseInt(endTerm)) {
      log.info(String.format("start with term=%s", startTerm));
      String lottery = PELotteryFeign
          .getLottery(type, StringUtils.termParamsConvert(startTerm), num);
      JsonNode jsonNode = objectMapper.readTree(lottery);
      jsonNode = jsonNode.findParent("mdata");
      Iterator<JsonNode> mdataJsonNodes;
      try {
        mdataJsonNodes = jsonNode.findValue("mdata").elements();
      } catch (NullPointerException e) {
//        log.info(e.getMessage());
        log.info(String.format("can not parse json data,term=%s", startTerm));
        startTerm = StringUtils.peTermJump(type, startTerm, num);
        continue;
      }
      MData thisMData;
      while (mdataJsonNodes.hasNext()) {
        thisMData = objectMapper.treeToValue(mdataJsonNodes.next(), MData.class);
        try {
          PELotteryRepository.save(thisMData.getLottery());
        } catch (Exception e) {
//          log.info(e.getMessage());
          log.info(String.format("can not insert,term=%s", startTerm));
        }
      }
      startTerm = StringUtils.peTermJump(type, startTerm, num);
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    log.info(String.format("task complete,startTerm=%sendTerm=%s", startTerm, endTerm));
  }

  @Override
  public void getCWLLotteries(String name, String issueStart, String issueEnd, String issueCount) {
    while (Integer.parseInt(issueStart) + (Integer.parseInt(issueCount) * 2) < Integer
        .parseInt(issueEnd)) {
      String lottery = cwlLotteryFeign
          .getLottery("spider", name, issueCount, issueStart, issueEnd, null, null);
      try {
        CWLData cwlData = objectMapper.readValue(lottery, CWLData.class);
        for (CWLResult cwlResult : cwlData.getResult()) {

        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      issueStart = StringUtils.cwlIssueJump(name, issueStart, issueCount);
    }
  }
}