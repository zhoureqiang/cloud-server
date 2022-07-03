package com.cloud.controller;

import com.cloud.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    //private static final String REST_URL_PROVIDER_PREFIX = "http://localhost:8001/"; 这种方式是直调用服务方的方法，根本没有用到 Spring Cloud
    //面向微服务编程，即通过微服务的名称来获取调用地址
    private static final String REST_URL_PROVIDER_PREFIX = "http://PROVIDER"; // 使用注册到 Spring Cloud Eureka 服务注册中心中的服务，即 application.name
    @Autowired
    private RestTemplate restTemplate; //RestTemplate 是一种简单便捷的访问 restful 服务模板类，是 Spring 提供的用于访问 Rest 服务的客户端模板工具集，提供了多种便捷访问远程 HTTP 服务的方法

    //获取用户列表
    @RequestMapping(value = "/user/list")
    public List<User> list() {
        return restTemplate.getForObject(REST_URL_PROVIDER_PREFIX + "/provider/user/getAll", List.class);
    }
}
