package com.softdev.system.demo.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@Log
public class AspectConfig {


    @Pointcut("execution(public * com.softdev.system.demo.controller.DemoController.index(..))")
    public void index_log(){}

    /**
     * 记录HTTP请求结束时的日志
     */
    @Before("index_log()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        log.info(">>>>>>>>>>Before");
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("PATH : " +  request.getServletPath());
        log.info("METHOD : " + request.getMethod());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }
    @AfterReturning(returning = "obj",pointcut = "index_log()")
    public void doAfterReturning(Object obj) throws Throwable {
        //处理完请求，返回内容
        log.info(">>>>>>>>>>AfterReturning");
        log.info("RESPONSE : " + JSON.toJSONString(obj));
    }

    @AfterThrowing(value = "index_log()",throwing = "exception")
    public void doAfterThrowing(JoinPoint joinPoint,Throwable exception){
        //目标方法名：
        log.info(">>>>>>>>>>AfterThrowing");
        log.info(joinPoint.getSignature().getName());
        if(exception instanceof NullPointerException){
            log.info("发生了空指针异常!!!!!");
        }else{
            log.info("发生了未知异常!!!!!");
        }
    }

    @Around(value = "index_log()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        log.info(">>>>>>>>>>Around");
        log.info("环绕通知的目标方法名："+proceedingJoinPoint.getSignature().getName());
        try {
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
