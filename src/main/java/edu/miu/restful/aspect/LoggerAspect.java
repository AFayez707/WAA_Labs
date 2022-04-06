package edu.miu.restful.aspect;

import edu.miu.restful.entity.Logger;
import edu.miu.restful.entity.UserModel;
import edu.miu.restful.service.LoggerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class LoggerAspect {

    @Autowired
    LoggerService loggerService;

    @Pointcut("@annotation(edu.miu.restful.aspect.annotation.ExecutionTime)")
    public void logMeAnnotation(){

    }

    @Around("logMeAnnotation()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        long executionTime = System.currentTimeMillis() - start;
        Logger logger = new Logger();
        logger.setOperation(joinPoint.getSignature().getName());
        logger.setDatetime(new Date());
        logger.setDuration(executionTime);
        logger.setPrinciple(UserModel.getLoggedInUser());
        loggerService.save(logger);
        return joinPoint.proceed();
    }

}
