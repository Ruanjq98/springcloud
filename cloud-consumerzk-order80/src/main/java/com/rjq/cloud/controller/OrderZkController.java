package com.rjq.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: ruanjq
 * @DateTime: 2021/3/6$ 16:48$
 */
@RestController
@Slf4j
public class OrderZkController {
    public static  final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentinfo(){

        return  restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);

    }
}
