package com.springaop.example2.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class.getName());

    @Before("execution(* com.springaop.example2.dao.PassengerDaoImpl.*(..))")
    public void before(){
        LOGGER.info("Entering Method");
    }

    @After("execution(* com.springaop.example2.dao.PassengerDaoImpl.getPassenger(..))")
    public void after(){
        LOGGER.info("Existing Method");
    }
}
