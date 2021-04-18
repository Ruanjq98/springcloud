package com.rjq.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ruanjq
 * @DateTime: 2021/3/21$ 17:59$
 */
@RestController
@RefreshScope
public class ConfigController
{
    @Value("${config.info}")
    private String config;

    @GetMapping("/configInfo")
    public String getConfig(){
        return config;
    }
}
