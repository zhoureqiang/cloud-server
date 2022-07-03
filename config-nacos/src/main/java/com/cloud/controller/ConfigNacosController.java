package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigNacosController {

    @Value("${config.info}")
    private String ConfigInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return ConfigInfo;
    }


}
