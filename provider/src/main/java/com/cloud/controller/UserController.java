package com.cloud.controller;

import com.cloud.entity.User;
import com.cloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/provider")
public class UserController {

    @Autowired
    IUserService userService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/user/getAll")
    public List<User> list(){
        return userService.queryUserList();
    }

    //超时测试,该服务的响应时间为 5 秒
    @RequestMapping(value = "/user/timeout")
    public String DeptFeignTimeout() {
        //暂停 5 秒
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
