package com.rjq.cloud.service;

import com.rjq.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: ruanjq
 * @DateTime: 2021/2/27$ 15:24$
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
