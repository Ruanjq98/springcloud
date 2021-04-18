package com.rjq.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 * @Author: ruanjq
 * @DateTime: 2021/4/17$ 18:42$
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ConfigMain3377
{
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3377.class, args);
    }

}
