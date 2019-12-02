package cn.aethli.thoth.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

  @Override
  public void run(String... args) {

  }
}
