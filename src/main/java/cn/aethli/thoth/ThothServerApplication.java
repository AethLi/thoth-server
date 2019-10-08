package cn.aethli.thoth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class ThothServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ThothServerApplication.class, args);
  }
}
