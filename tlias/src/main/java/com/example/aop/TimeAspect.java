package com.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class TimeAspect {

//    @Around("execution(* com.example.service.*.*(..))")
    @Around("com.example.aop.MyAspect1.pt()")
    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();//调用原始方法运行
        long end = System.currentTimeMillis();
        log.info(proceedingJoinPoint.getSignature() + "执行耗时: {}ms", end - begin);
        return object;
    }
}


