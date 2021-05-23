package com.rjq.cloud.serviceFllBack;

import com.rjq.cloud.entities.CommonResult;
import com.rjq.cloud.entities.Payment;
import com.rjq.cloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @Author: ruanjq
 * @DateTime: 2021/5/2$ 16:59$
 */
@Component
public class paymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444444,"服务降级返回，--------paymentFallbackService");
    }
}
