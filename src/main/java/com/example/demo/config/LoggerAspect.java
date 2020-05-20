package com.example.demo.config;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;


@Aspect
@Component
public class LoggerAspect {
    // 定义切点 @Pointcut。是面前注解类的地址。
    @Pointcut("@annotation(com.example.demo.config.LoggerOperation)")
    public void controllerAspect() {
    }

    //切面 配置通知
    @AfterReturning("controllerAspect()")
    public void saveStatistics(JoinPoint joinPoint) {
        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        //获取操作
        LoggerOperation operation = method.getAnnotation(LoggerOperation.class);
        String value = null;
        String type = null;
        if (operation != null) {
            value = operation.value();
            type = operation.value();
        }
        Date dateNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        ft.format(dateNow);
    }
}
