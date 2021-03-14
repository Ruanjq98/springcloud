package com.rjq.cloud.controller;

import com.rjq.cloud.entities.CommonResult;
import com.rjq.cloud.entities.Payment;
import com.rjq.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: ruanjq
 * @DateTime: 2021/2/27$ 15:25$
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult creat(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        if (i>0){
            return new CommonResult(200, "插入成功 serverPort"+serverPort, payment);
        }else{
            return new CommonResult(404,"插入失败");
        }

    }
    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);/**/


        if(payment != null)
        {
            return new CommonResult(200,"查询成功 serverPort"+serverPort,payment);
        }else{
            return new CommonResult(404,"没有对应记录,查询ID:"+id+"serverPort"+serverPort);
        }
    }
}
