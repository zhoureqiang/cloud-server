package com.cloud.controller;

import com.cloud.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//@DefaultProperties(defaultFallback = "dept_Global_FallbackMethod") //全局的服务降级方法
public class HystrixConsumerController {

    @Autowired
    private HystrixService hystrixService;

    @RequestMapping(value = "/consumer/hystrix/ok/{id}")
    public String deptInfo_Ok(@PathVariable("id") Integer id) {
        return hystrixService.hystrixOk(id);
    }

    //在客户端进行降级
    @RequestMapping(value = "/consumer/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "timeoutHandler") //为该请求指定专属的回退方法
    @HystrixCommand //定义了全局fallback方法，不需要再指定fallbackMethod
    public String Timeout(@PathVariable("id") Integer id) {
        String s = hystrixService.hystrixTimeout(id);
        log.info(s);
        return s;
    }

    // hystrixTimeout方法的 专用 fallback 方法
    public String timeoutHandler(@PathVariable("id") Integer id) {
        log.info("hystrixTimeout 出错，服务已被降级！");
        return "靓仔提醒您：服务端系统繁忙，请稍后再试！（客户端 hystrixTimeout 专属的回退方法触发）";
    }

    /**
     * 全局的 fallback 方法，
     * 回退方法必须和 hystrix 的执行方法在相同类中
     * @DefaultProperties(defaultFallback = "dept_Global_FallbackMethod") 类上注解，请求方法上使用 @HystrixCommand 注解
     */
    public String dept_Global_FallbackMethod() {
        return "靓仔提醒您，运行出错或服务端系统繁忙，请稍后再试！（客户端全局回退方法触发,）";
    }

}
