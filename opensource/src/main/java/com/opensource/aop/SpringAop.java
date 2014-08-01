package com.opensource.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SpringAop {
	
	@Pointcut("execution(* com.opensource.service.*.*(..))")
	public void aopPointcut(){}
	
	@Around("aopPointcut()")
	public Object process(ProceedingJoinPoint jp) {
		System.out.println("go aop");
		try {
			return jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
