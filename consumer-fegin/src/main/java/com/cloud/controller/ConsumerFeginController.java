package com.cloud.controller;

import com.cloud.entity.User;
import com.cloud.service.UserFeginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/consumer/fegin")
public class ConsumerFeginController {

    @Autowired
    private UserFeginService userFeginService;

    @GetMapping("/user/list")
    public List<User> list(){
        return userFeginService.list();
    }

    @GetMapping("/timeout")
    public String timeout(){
        return userFeginService.feignTimeout();
    }

}
