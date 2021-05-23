package com.rjq.cloud.fallbackhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.rjq.cloud.entities.CommonResult;

/**
 * @Author: ruanjq
 * @DateTime: 2021/5/2$ 16:14$
 */
public class CustomerBlockHandler {
    /*
    * BlockHandler1 控制sentinel的异常问题
    * 方法必须为 static 并且 方法与 主方法参数必须一致，并且后面加上 BlockException
    * */

    public static CommonResult handlerException(Long id,BlockException exception)
    {
        return new CommonResult(4444,"按客戶自定义,global handlerException----1");
    }
}
