package com.rjq.cloud.service.impl;

import com.rjq.cloud.dao.PaymentDao;
import com.rjq.cloud.entities.Payment;
import com.rjq.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: ruanjq
 * @DateTime: 2021/2/27$ 15:26$
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
