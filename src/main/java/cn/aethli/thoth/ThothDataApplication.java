package cn.aethli.thoth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@Cacheable
//@EnableEurekaClient
public class ThothDataApplication {

  public static void main(String[] args) {
    SpringApplication.run(ThothDataApplication.class, args);
  }
}
