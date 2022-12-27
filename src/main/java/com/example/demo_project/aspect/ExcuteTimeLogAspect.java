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
//	//���J�I�A�w�q controller �U�Ҧ��{�����|�Q�]�t
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
//		System.out.println("���檺��k�W��: " + signature.getName());
//		long startTime = System.currentTimeMillis();
//		//�I�s proceed() �~�|�}�l������k
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
//	                                                 //�����M�ѼƦW�٤@��
//	@AfterThrowing(pointcut = "pointcut()", throwing = "throwable")
//	public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
//		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//		System.out.println("���檺��k�W��: " + signature.getName());
//		System.out.println("���~�T��: " + throwable.getMessage());
//		System.out.println("=====afterThrowing advice=====");
//	}
//}
