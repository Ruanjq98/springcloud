package com.rjq.alibabacloud.CustomerBlockHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.rjq.cloud.entities.CommonResult;
import com.rjq.cloud.entities.Payment;

/**
 * @Author: ruanjq
 * @DateTime: 2021/4/24$ 18:50$
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException1(BlockException e){
        return new CommonResult(4444,"按客戶自定义,global handlerException----1",e);
    }
    public static CommonResult handlerException2(BlockException e){
        return new CommonResult(4444,"按客戶自定义,global handlerException----2",e);
    }
}
