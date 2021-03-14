package com.rjq.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author: ruanjq
 * @DateTime: 2021/3/13$ 15:45$
 */
@Service
public class PaymentService {

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_handler")
    public String paymentInfo_Ok(Integer id){
        return "线程池："+Thread.currentThread().getName()+ "paymentInfo_Ok,id:"+id+"成功";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_handler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int i = 4;
      //\  int m = 10/0;
        try{
            TimeUnit.SECONDS.sleep(i);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+ "paymentInfo_Ok,id:"+id+"成功耗时间"+i+"S";

    }

    public String paymentInfo_TimeOut_handler(Integer id){

        return "线程池："+Thread.currentThread().getName()+ "paymentInfo_TimeOut_handler,id:"+id+"/(ㄒoㄒ)/~~";
    }

    //=====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
