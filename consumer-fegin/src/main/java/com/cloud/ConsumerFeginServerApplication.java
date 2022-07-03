package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //开启 OpenFeign 功能
@EnableHystrix //启用 Hystrix
public class ConsumerFeginServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeginServerApplication.class,args);
    }
}
