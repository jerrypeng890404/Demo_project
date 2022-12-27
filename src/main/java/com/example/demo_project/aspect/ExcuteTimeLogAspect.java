//package com.example.demo_project.aspect;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
//public class ExcuteTimeLogAspect {
//
//	//切入點，定義 controller 下所有程式都會被包含
////	@Pointcut("execution (* com.example.demo_project.controller.*.*(..))")
//	@Pointcut("execution (* com.example.demo_project.impl.*.*(..))")
//	public void pointcut() {
//	}
//	
//	@Before("pointcut()")
//	public void before() {
//		System.out.println("=====before advice=====");
//	}
//	
//	@After("pointcut()")
//	public void after() {
//		System.out.println("=====after advice=====");
//	}
//	
//	@Around("pointcut()")
//	public Object around(ProceedingJoinPoint pjp)throws Throwable {
//		System.out.println("=====around advice start=====");
//		MethodSignature signature = (MethodSignature) pjp.getSignature();
//		System.out.println("執行的方法名稱: " + signature.getName());
//		long startTime = System.currentTimeMillis();
//		//呼叫 proceed() 才會開始執行原方法
//		Object result = pjp.proceed();
//		long spentTime = System.currentTimeMillis() - startTime;
//		System.out.println("result: " + result);
//		System.out.println("Time spent: " + spentTime);
//		System.out.println("=====around advice end=====");
//		return result;
//	}
//	
//	@AfterReturning("pointcut()")
//	public void afterReturning() {
//		System.out.println("=====afterReturning advice=====");
//	}
//	
//	                                                 //必須和參數名稱一樣
//	@AfterThrowing(pointcut = "pointcut()", throwing = "throwable")
//	public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
//		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//		System.out.println("執行的方法名稱: " + signature.getName());
//		System.out.println("錯誤訊息: " + throwable.getMessage());
//		System.out.println("=====afterThrowing advice=====");
//	}
//}
