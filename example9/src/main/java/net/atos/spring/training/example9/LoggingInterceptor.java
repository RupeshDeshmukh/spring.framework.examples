/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example9;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

/**
 * Intercepter providing methods that will act as advice for performing logging
 * operation.
 * 
 * @author Rupesh Deshmukh
 */
@Aspect
@Order(value = 1)
public class LoggingInterceptor {

    /**
     * Logger instance for doing logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingInterceptor.class);

    /**
     * Following is the definition for a pointcut to select the save method
     * available. So advice will be called only for the saveStudent method.
     */
    @Pointcut("execution(* net.atos.spring.training.example9.StudentService.saveStudent(..))")
    private void studentSave() {
    }

    /**
     * This is the method which I would like to execute before a selected method
     * execution.
     * 
     * @param joinPoint
     *            <code>org.aspectj.lang.JoinPoint</code>.
     */
    @Before("studentSave()")
    public void beforeAdvice(final JoinPoint joinPoint) {

        LOGGER.info("Invoking operation: " + joinPoint.getSignature().toShortString() + ": Going to setup student profile.");
    }

    /**
     * This is the method which I would like to execute after a selected method
     * execution.
     * 
     * @param joinPoint
     *            <code>org.aspectj.lang.JoinPoint</code>.
     */
    @After("studentSave()")
    public void afterAdvice(final JoinPoint joinPoint) {

        LOGGER.info("Completed operation: " + joinPoint.getSignature().toShortString() + ": Student profile has been setup.");
    }

    /**
     * This is the method which I would like to execute when any method returns.
     * 
     * @param retVal
     *            The object return by the target object method.
     */
    @AfterReturning(pointcut = "studentSave()", returning = "retVal")
    public void afterReturningAdvice(final Object retVal) {

        LOGGER.info("Returning:" + retVal.toString());
    }

    /**
     * This is the method which I would like to execute if there is an exception
     * raised.
     * 
     * @param ex
     *            Exception object thrown by the target object method.
     */
    @AfterThrowing(pointcut = "studentSave()", throwing = "ex")
    public void afterThrowingAdvice(final IllegalArgumentException ex) {

        LOGGER.info("There has been an exception: " + ex.toString());
    }
}
