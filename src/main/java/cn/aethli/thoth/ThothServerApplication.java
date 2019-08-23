package cn.aethli.thoth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ThothServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ThothServerApplication.class, args);
  }
}
