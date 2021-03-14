package com.rjq.cloud.controller;


import com.rjq.cloud.entities.CommonResult;
import com.rjq.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: ruanjq
 * @DateTime: 2021/2/27$ 15:50$
 */

@RestController
@Slf4j
public class OrderController {
    //public static final  String  PAYMENT_URL = "http://localhost:8001";
    public static final  String  PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE"; //集群

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> crete(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public  CommonResult<Payment> getPayment(@PathVariable(name = "id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);


    }

    @GetMapping("/consumer/postForEntity/create")
    public CommonResult<Payment> crete2(Payment payment){
        ResponseEntity<CommonResult> result = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        if (result.getStatusCode().is2xxSuccessful()){
            return result.getBody();
       }else {
            return new CommonResult<>(444,"操作失败");
        }
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public  CommonResult<Payment> getPayment2(@PathVariable(name = "id")Long id){
        ResponseEntity<CommonResult> result = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (result.getStatusCode().is2xxSuccessful()){
            return result.getBody();
        }else {
            return new CommonResult<>(444,"操作失败");
        }

    }

}
