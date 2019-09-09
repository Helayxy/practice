package cn.lynu.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//声明是一个eureka客户端服务中心
@EnableEurekaServer
public class LynuEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LynuEurekaApplication.class, args);
    }

}
