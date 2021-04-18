package com.rjq.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: ruanjq
 * @DateTime: 2021/3/21$ 17:57$
 */
@EnableEurekaClient
@SpringBootApplication
public class Config3355Main {
    public static void main(String[] args) {
        SpringApplication.run(Config3355Main.class,args);
    }
}
