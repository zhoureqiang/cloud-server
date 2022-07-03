package com.cloud.controller;

import com.cloud.service.IHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HystrixController {

    @Autowired
    private IHystrixService hystrixService;

    @Value("${server.port}")
    private String serverPort;


    @RequestMapping(value = "/provider/hystrix/ok/{id}")
    public String deptInfo_Ok(@PathVariable("id") Integer id) {

        String result = hystrixService.deptInfo_Ok(id);
        log.info("端口号：" + serverPort + " result:" + result);
        return result + "，   端口号：" + serverPort;
    }


    // Hystrix 服务超时降级
    @RequestMapping(value = "/provider/hystrix/timeout/{id}")
    public String deptInfo_Timeout(@PathVariable("id") Integer id) {

        String result = hystrixService.deptInfo_Timeout(id);
        log.info("端口号：" + serverPort + " result:" + result);
        return result + "，   端口号：" + serverPort;
    }

    // Hystrix 服务熔断
    @RequestMapping(value = "/provider/hystrix/circuit/{id}")
    public String deptCircuitBreaker(@PathVariable("id") Integer id){
        String result = hystrixService.deptCircuitBreaker(id);
        log.info("result:"+result);
        return result;
    }
}
