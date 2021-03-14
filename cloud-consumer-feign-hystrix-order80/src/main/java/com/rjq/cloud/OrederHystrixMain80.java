package com.rjq.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: ruanjq
 * @DateTime: 2021/3/13$ 16:27$
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class OrederHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrederHystrixMain80.class,args);
    }
}
