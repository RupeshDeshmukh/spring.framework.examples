/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example8;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Intercepter/aspect providing methods that will act as advice for performing
 * logging operation.
 * 
 * @author Rupesh Deshmukh
 */
public class LoggingInterceptor {

    /**
     * Logger instance for doing logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingInterceptor.class);

    /**
     * This is the method which I would like to execute before a selected method
     * execution.
     * 
     * @param joinPoint
     *            <code>org.aspectj.lang.JoinPoint</code>.
     */
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
    public void afterAdvice(final JoinPoint joinPoint) {

        LOGGER.info("Completed operation: " + joinPoint.getSignature().toShortString() + ": Student profile has been setup.");
    }

    /**
     * This is the method which I would like to execute when any method returns.
     */
    public void afterReturningAdvice(final Object retVal) {

        LOGGER.info("Returning:" + retVal.toString());
    }

    /**
     * This is the method which I would like to execute if there is an exception
     * raised.
     */
    public void afterThrowingAdvice(IllegalArgumentException ex) {

        LOGGER.info("There has been an exception: " + ex.toString());
    }
}
