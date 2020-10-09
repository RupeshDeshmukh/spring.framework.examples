/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example8;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * Intercepter/aspect providing methods that will act as advice for measuring
 * performance metrics for the called operation.
 * 
 * @author Rupesh Deshmukh
 */
public class PerformanceMetrics {

    /**
     * Logger instance for doing logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMetrics.class);

    /**
     * Profiling method that will act as Around invoke for calculating
     * performance of the service.
     * 
     * @param pjp
     *            <code>org.aspectj.lang.ProceedingJoinPoint</code>.
     * @return
     * @throws Throwable
     */
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
