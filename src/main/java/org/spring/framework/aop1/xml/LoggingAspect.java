package org.spring.framework.aop1.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

import java.util.Arrays;

public class LoggingAspect {
	
	public void beforeMethod(JoinPoint joinPoint){
		System.out.println("beforeMethod...");
		String methodName = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs();
		
		System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
	}
	
	public void afterMethod(JoinPoint joinPoint){
		System.out.println("afterMethod...");
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends");
	}
	
	public void afterReturning(JoinPoint joinPoint, Object result){
		System.out.println("afterReturning...");
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}
	
	public void afterThrowing(JoinPoint joinPoint, Exception e){
		System.out.println("afterThrowing...");
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs excetion:" + e);
	}
	
	@Around("execution(public int org.spring.framework.aop1.xml.ArithmeticCalculator.*(..))")
	public Object aroundMethod(ProceedingJoinPoint pjd){
		
		Object result = null;
		String methodName = pjd.getSignature().getName();
		System.out.println("@Around...");
		try {
			//前置通知
			System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
			//执行目标方法
			result = pjd.proceed();
			//返回通知
			System.out.println("The method " + methodName + " ends with " + result);
		} catch (Throwable e) {
			//异常通知
			System.out.println("The method " + methodName + " occurs exception:" + e);
			throw new RuntimeException(e);
		}
		//后置通知
		System.out.println("The method " + methodName + " ends");
		
		return result;
	}
}
