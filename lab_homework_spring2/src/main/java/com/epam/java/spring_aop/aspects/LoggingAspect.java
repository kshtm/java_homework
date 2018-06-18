package com.epam.java.spring_aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("@annotation(Loggable)")
    public void serviceMethod() {

    }

    @Around("serviceMethod()")
    public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();
        String argsString = Arrays.toString(methodArgs);
        System.out.println((String.format("Call method %s with args %s", methodName, argsString)));
        Object result = joinPoint.proceed();
        System.out.println((String.format("Method %s with args %s has returned %s", methodName, argsString, result)));
        return result;
    }
}