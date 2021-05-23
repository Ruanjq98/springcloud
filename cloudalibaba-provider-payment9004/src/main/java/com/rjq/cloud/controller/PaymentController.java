package com.rjq.cloud.controller;

import com.rjq.cloud.entities.CommonResult;
import com.rjq.cloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author: ruanjq
 * @DateTime: 2021/5/2$ 15:27$
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap= new HashMap<>();
    static
    {
        hashMap.put(1L,new Payment(1L,"1"));
        hashMap.put(2L,new Payment(2L,"2"));
        hashMap.put(3L,new Payment(3L,"3"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id)
    {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult(200,"from mysql,serverPort:  "+serverPort,payment);
        return result;
    }
}
