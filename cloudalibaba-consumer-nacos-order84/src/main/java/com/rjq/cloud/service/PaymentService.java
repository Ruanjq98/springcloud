package com.rjq.cloud.service;

import com.rjq.cloud.entities.CommonResult;
import com.rjq.cloud.entities.Payment;
import com.rjq.cloud.serviceFllBack.paymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: ruanjq
 * @DateTime: 2021/5/2$ 16:55$
 */
@FeignClient(value = "nacos-payment-provider" ,fallback = paymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
