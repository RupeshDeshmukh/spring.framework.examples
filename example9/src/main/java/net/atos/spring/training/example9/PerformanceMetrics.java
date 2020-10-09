/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example9;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.util.StopWatch;

/**
 * Intercepter/aspect providing methods that will act as advice for measuring
 * performance metrics for the called operation.
 * 
 * @author Rupesh Deshmukh
 */
@Aspect
@Order(value = 0)
public class PerformanceMetrics {

    /**
     * Logger instance for doing logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMetrics.class);

    /**
     * Following is the definition for a pointcut to select the save method
     * available. So advice will be called only for the saveStudent method.
     */
    @Pointcut("execution(* net.atos.spring.training.example9.StudentService.saveStudent(..))")
    private void studentSave() {
    }

    /**
     * Profiling method that will act as Around invoke for calculating
     * performance of the service.
     * 
     * @param pjp
     *            <code>org.aspectj.lang.ProceedingJoinPoint</code>.
     * @return
     * @throws Throwable
     */
    @Around("studentSave()")
    public Object profile(final ProceedingJoinPoint pjp) throws Throwable {

        final StopWatch sw = new StopWatch(getClass().getSimpleName());
        try {
            sw.start(pjp.getSignature().getName());
            return pjp.proceed();
        } finally {
            sw.stop();
            LOGGER.info(sw.prettyPrint());
        }
    }
}
