package com.jsp.security_example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.jsp.security_example.*.*(..))")
    public void before(JoinPoint joinPoint) {
        log.info("Entering Method : " + joinPoint.getSignature().getName());
    }

    @AfterReturning(
            value = "execution((* com.jsp.security_example.*.*(..))",
            returning = "result"
    )
    public void after(JoinPoint joinPoint, Object result) {
        log.info("Exiting Method : "
                + joinPoint.getSignature().getName()
                + " Result : "
                + result);
    }
}