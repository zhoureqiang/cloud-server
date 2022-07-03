package com.cloud.service;

import com.cloud.service.impl.HystrixFallBackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "PROVIDER-HYSTRIX",fallback = HystrixFallBackService.class)
public interface HystrixService {
    @RequestMapping(value = "/provider/hystrix/ok/{id}")
    public String hystrixOk(@PathVariable("id") Integer id);

    @RequestMapping(value = "/provider/hystrix/timeout/{id}")
    public String hystrixTimeout(@PathVariable("id") Integer id);
}
