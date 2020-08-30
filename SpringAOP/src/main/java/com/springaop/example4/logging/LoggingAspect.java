package com.springaop.example4.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class LoggingAspect {
    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class.getName());

   @Around("logPointCut5()")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] methodArgs = proceedingJoinPoint.getArgs();
        LOGGER.info("Input to Method: " + methodName + " with agrs: " + methodArgs[0]);
        Object result = proceedingJoinPoint.proceed();
        LOGGER.info("Method :" + methodName + " returns " + result);
        return result;
    }

    /**
     * Match all methods within a class in another package
     */
    @Pointcut("execution(* com.springaop.example4.dao.PassengerDaoImpl.*(..))")
    public void logPointCut(){

    }

    /**
     * Match all methods within a class within same package
     * You can omit the package name if the target class or interface is
     * located in the same package
     */
    @Pointcut("execution(* PassengerDaoImpl.*(..))")
    public void logPointCut1(){

    }

    /**
     * Match all public methods in PassengerDaoImpl
     */
    @Pointcut("execution(public * com.springaop.example4.dao.PassengerDaoImpl.*(..))")
    public void logPointCut2(){

    }

    /**
     * Match all public methods in PassengerDaoImpl with return type Passenger
     */
    @Pointcut("execution(public Passenger com.springaop.example4.dao.PassengerDaoImpl.*(..))")
    public void logPointCut3(){

    }

    /**
     * Match all public methods in PassengerDaoImpl with return type Passenger
     * and first parameter as Integer
     */
    @Pointcut("execution(public Passenger com.springaop.example4.dao.PassengerDaoImpl.*(Integer, ..))")
    public void logPointCut4(){

    }

    /**
     * Match all methods defined in classes inside package com.springaop.example4.dao
     */
    @Pointcut("within(com.springaop.example4.dao.*)")
    public void logPointCut5(){

    }

    /**
     * Match all methods defined in classes inside
     * package com.springaop.example4.dao and classes inside all sub-packages as well
     */
    @Pointcut("within(com.springaop.example4.dao..*)")
    public void logPointCut6(){

    }


    /**
     * Match all methods defined in beans whose name ends with ‘DaoImpl’.
     */
    @Pointcut("bean(*DaoImpl)")
    public void logPointCut7(){

    }

    /**
     * Match all methods with names ending with Manager and DAO
     */
    @Pointcut("bean(*Manager) && bean(*DAO)")
    public void logPointCut8(){

    }
}
