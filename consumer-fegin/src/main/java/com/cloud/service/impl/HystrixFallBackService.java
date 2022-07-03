package com.cloud.service.impl;

import com.cloud.service.HystrixService;
import org.springframework.stereotype.Component;

/**
 * Hystrix 服务降级
 * 解耦回退逻辑
 */
@Component
public class HystrixFallBackService implements HystrixService {
    @Override
    public String hystrixOk(Integer id) {
        return "--------------------靓仔提醒您，系统繁忙，请稍后重试！（解耦回退方法触发）hystrixOk-----------------------";
    }

    @Override
    public String hystrixTimeout(Integer id) {
        return "--------------------靓仔提醒您，系统繁忙，请稍后重试！（解耦回退方法触发）hystrixTimeout-----------------------";
    }
}
