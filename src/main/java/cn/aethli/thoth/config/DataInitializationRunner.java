package cn.aethli.thoth.config;

import cn.aethli.thoth.entity.PELottery;
import cn.aethli.thoth.repository.PELotteryRepository;
import cn.aethli.thoth.service.DataGetTaskService;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Termite
 * @device Hades
 * @date 2019-11-21 09:37
 */
@Order(1)
@Component
public class DataInitializationRunner implements CommandLineRunner {

  private static final Logger LOG = LoggerFactory.getLogger(DataInitializationRunner.class);

  @Autowired private DataGetTaskService dataGetTaskService;
  @Autowired private PELotteryRepository peLotteryRepository;

  @Override
  public void run(String... args) {
    peDataInitialization();
    cwlDataInitialization();
  }

  private void peDataInitialization() {
    // 七星彩
    String endTerm = dataGetTaskService.getPELotteryThisTerm("8");
    String typeString = "8";
    List<PELottery> allLottery = peLotteryRepository.findByType(typeString);
    try {
      dataGetTaskService.getPELotteries(typeString, "4000", "50", endTerm);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void cwlDataInitialization() {}
}
