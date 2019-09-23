package cn.lynu.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//开启eureka客户端功能
@EnableDiscoveryClient
public class LynuServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(LynuServiceProviderApplication.class, args);
    }
}
