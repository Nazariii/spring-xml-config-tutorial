package com.epam.nivash.spring.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Pointcut("execution(* *.*logEvent(*,*,*))")
    private void allLogEventMethods() {

    }

    @Before("allLogEventMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(" ============ logBefore is started");
        System.out.println(joinPoint.getTarget());

    }

}
