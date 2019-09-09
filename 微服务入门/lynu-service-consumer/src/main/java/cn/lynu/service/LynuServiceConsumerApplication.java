package cn.lynu.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//开启eureka客户端功能
@EnableDiscoveryClient
//开启熔断功能
@EnableCircuitBreaker
public class LynuServiceConsumerApplication {

    //RestTemplate用于访问restful服务
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(LynuServiceConsumerApplication.class, args);
    }

}
