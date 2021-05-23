package com.rjq.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 * @Author: ruanjq
 * @DateTime: 2021/5/2$ 15:06$
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment9003Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment9003Main.class, args);
    }
}
