package com.modern.process.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Log output before executing the service.
     * Target: [UserService] is included in the class name.
     */
    @Before("execution(* *..*.*EmployeeResource.*(..))")
    public void startLog(JoinPoint jp) {
        logger.info("Method start: " + jp.getSignature());
    }

    /**
     * Log output after executing the service.
     * Target: [UserService] is included in the class name.
     */
    @After("execution(* *..*.*EmployeeResource.*(..))")
    public void endLog(JoinPoint jp) {
        logger.info("Method end: " + jp.getSignature());
    }

    /*
     * Log output before and after the controller is executed */
    //@Around("bean(*Controller)")
    //@Around("@annotation(org.springframework.web.bind.annotation.Get Mapping)")
    @Around("@within(org.springframework.stereotype.Controller)")
    public Object startLog(ProceedingJoinPoint jp) throws Throwable {
        // Output start log
        logger.info("Method start: " + jp.getSignature());
        try {
            // Method execution
            Object result = jp.proceed();
            // Output end log
            logger.info("Method end: " + jp.getSignature());
            // Return the execution result to the caller
            return result;
        } catch (Exception e) {
            // Output error log
            logger.error("Method abend: " + jp.getSignature());
            // Rethrow the error
            throw e;
        }
    }
}
