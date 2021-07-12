package com.challenge.challengeW2M.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAdvice {

	private static final Logger logger = LoggerFactory.getLogger(ExecutionTimeAdvice.class);
	
    @Around("@annotation(com.challenge.challengeW2M.annotation.TrackExecutionTime)")
    public Object executionTime(ProceedingJoinPoint point) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object object = point.proceed();
        long endtime = System.currentTimeMillis();
        logger.info("Class Name: "+ point.getSignature().getDeclaringTypeName() 
        		+". Method Name: "+ point.getSignature().getName() 
        		+". Time taken for Execution is : " + (endtime-startTime) +"ms");
        return object;
    }
}