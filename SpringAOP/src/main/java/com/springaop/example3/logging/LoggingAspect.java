package com.springaop.example3.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class.getName());

    //@Before("execution(* com.springaop.example3.dao.PassengerDaoImpl.getPassenger(..))")
    public void before(JoinPoint joinPoint) {
        Object[] methodArgs = joinPoint.getArgs();
        LOGGER.info("Input to Method :" + joinPoint.getSignature().getName() + " with args :" + methodArgs[0]);
    }

    //@After("execution(* com.springaop.example3.dao.PassengerDaoImpl.getPassenger(..))")
    public void after(JoinPoint joinPoint) {
        LOGGER.info(" Existing Method : " + joinPoint.getSignature().getName());
    }

    //@Around("execution(* *.*Passenger(..))")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] methodArgs = proceedingJoinPoint.getArgs();
        LOGGER.info("Input to Method: " + methodName + " with agrs: " + methodArgs[0]);
        Object result = proceedingJoinPoint.proceed();
        LOGGER.info("Method :" + methodName + " returns " + result);
        return result;
    }

    @AfterReturning(pointcut = "execution(* com.springaop.example3.dao.*.*(..))", returning="val")
    public void logAfterReturning(JoinPoint joinPoint, Object val){
        LOGGER.info("Method "+ joinPoint.getSignature().getName() + " return value:"+ val);
    }


    @AfterThrowing(pointcut = "execution(* com.springaop.example3.dao.*.*(..))",
            throwing="exception")
    public void logAfterThrowing(Exception exception){
        LOGGER.info("Exception caught:"+ exception.getMessage());
    }


}