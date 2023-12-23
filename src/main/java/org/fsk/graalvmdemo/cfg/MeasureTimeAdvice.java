package org.fsk.graalvmdemo.cfg;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect
@Component
public class MeasureTimeAdvice {

    private static Logger logger = LoggerFactory.getLogger(MeasureTimeAdvice.class);

    @Around("@annotation(org.fsk.graalvmdemo.cfg.MeasureTime)")
    public Object measureTime(ProceedingJoinPoint point) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object object = point.proceed();
        stopWatch.stop();
        logger.info("Time take by " + point.getSignature().getName() + "() method is "
                + stopWatch.getTotalTimeMillis() + " ms");
        return object;
    }
}
