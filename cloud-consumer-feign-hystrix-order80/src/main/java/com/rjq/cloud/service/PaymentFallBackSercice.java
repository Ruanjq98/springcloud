package com.rjq.cloud.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: ruanjq
 * @DateTime: 2021/3/13$ 17:57$
 */
@Component
public class PaymentFallBackSercice implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----------PaymentHystrixServiceImpl --- paymentInfo_OK fall back-------";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----------PaymentHystrixServiceImpl ---paymentInfo_TimeOut fall back-------";
    }
}
