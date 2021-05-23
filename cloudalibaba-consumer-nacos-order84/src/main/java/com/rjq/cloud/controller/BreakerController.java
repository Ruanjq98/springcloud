package com.rjq.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.rjq.cloud.entities.CommonResult;
import com.rjq.cloud.entities.Payment;
import com.rjq.cloud.fallbackhandler.CustomerBlockHandler;
import com.rjq.cloud.fallbackhandler.FallbackHander;
import com.rjq.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: ruanjq
 * @DateTime: 2021/5/2$ 15:39$
 */
@RestController
@Slf4j
public class BreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";
    @Resource
    private RestTemplate restTemplate;


    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",
            fallbackClass = FallbackHander.class, fallback = "FallbackHander", //控制 java异常
            blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException" //BlockHandler1 控制sentinel的异常问题
             )
    public CommonResult<Payment> fallback(@PathVariable Long id){
        CommonResult result = restTemplate.getForObject(SERVICE_URL+"/paymentSQL/"+id,CommonResult.class,id);

        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }
    //openfeign
    @Resource
    PaymentService paymentService;

    @RequestMapping("/consumer/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable Long id){

        return paymentService.paymentSQL(id);

    }

}
