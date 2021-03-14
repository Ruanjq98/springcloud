package com.rjq.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author: ruanjq
 * @DateTime: 2021/3/14$ 11:57$
 */

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixMain9001.class,args);
    }
}
