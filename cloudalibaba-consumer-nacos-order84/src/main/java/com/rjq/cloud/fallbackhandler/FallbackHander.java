package com.rjq.cloud.fallbackhandler;

import com.rjq.cloud.entities.CommonResult;
import com.rjq.cloud.entities.Payment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: ruanjq
 * @DateTime: 2021/5/2$ 16:05$
 */
public class FallbackHander {
    //必须用static 解析不然无法解析  fallback 控制 处理异常 java异常
    public static CommonResult<Payment> FallbackHander(Long id, Throwable e){
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444,"兜底异常handlerFallback,exception内容  "+e.getMessage(),payment);
    }
}
