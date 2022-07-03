package com.cloud.service;

import com.cloud.entity.User;
import com.cloud.service.impl.HystrixFallBackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//添加为容器内的一个组件
@Component
// 服务提供者提供的服务名称，即 application.name
@FeignClient(value = "PROVIDER")
public interface UserFeginService {
    //对应服务提供者（8001、8002、8003）Controller 中定义的方法
//    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
//    public Dept get(@PathVariable("id") int id);
    @RequestMapping(value = "/provider/user/getAll", method = RequestMethod.GET)
    public List<User> list();

    @RequestMapping(value = "/provider/user/timeout")
    public String feignTimeout();
}
