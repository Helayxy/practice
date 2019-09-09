package cn.lynu.service.controller;

import cn.lynu.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("consumer/user")
public class UserController {
    // restTemplate用来获取rest服务
    @Autowired
    private RestTemplate restTemplate;

    // eureka客户端，可以获取到eureka中服务的信息
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping
    @ResponseBody
    public User findUserById(@RequestParam("id") Long id) {
        // 根据服务名称(id)，获取服务实例。有可能是集群，所以是service实例集合
        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
        // 因为只有一个Service-provider。所以获取第一个实例
        ServiceInstance serviceInstance = instances.get(0);
        // 获取ip和端口信息，拼接成服务地址
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id;
        // 两个参数表示通过url获取到的数据设置到User对象中
        User user = this.restTemplate.getForObject(url, User.class);
        return user;
    }
}
