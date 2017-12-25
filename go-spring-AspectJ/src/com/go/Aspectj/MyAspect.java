package com.go.Aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Title: MyAspect.java
 * @Package com.go.Aspectj
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月20日 下午6:38:18
 * @version V1.0
 */
public class MyAspect {

	/**
	 * AspectJ 是一个基于Java语言的AOP框架，spring 2.0 以后对 aspectj 切点表达式的支持
	 * 
	 * 切面类 可以在xml配置文件中确定通知类型
	 */
	/**
	 * 
	 * @Title: myBefore
	 * @Description: 前置通知
	 * @param joinPoint void 
	 * @throws
	 * @author 作者：zc
	 * @date 创建时间：2017年10月20日 下午6:43:02
	 */
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("前置通知，目标：" + joinPoint.getTarget() + " 目标方法：" + joinPoint.getSignature().getName());
	}

	/**
	 * 
	 * @Title: myAfterReturning
	 * @Description: 后置通知
	 * @param joinPoint void 
	 * @throws
	 * @author 作者：zc
	 * @date 创建时间：2017年10月20日 下午6:45:01
	 */
	public void myAfterReturning(JoinPoint joinPoint) {
		System.out.println("后置通知，目标：" + joinPoint.getTarget() + " 目标方法：" + joinPoint.getSignature().getName());
	}
	
	/**
	 * 
	 * @Title: myAround
	 * @Description:环绕通知
	 * @param proceedingJoinPoint
	 * @return Object
	 * @throws Throwable Object 
	 * @throws
	 * @author 作者：zc
	 * @date 创建时间：2017年10月20日 下午6:49:32
	 */
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("环绕通知开始");
		Object obj = proceedingJoinPoint.proceed();
		System.out.println("环绕通知结束");
		return obj;
	}
	
	/**
	 * 
	 * @Title: myAfterThrowing
	 * @Description: 异常通知
	 * @param joinPoint
	 * @param e void 
	 * @throws
	 * @author 作者：zc
	 * @date 创建时间：2017年10月20日 下午6:51:59
	 */
	public void myAfterThrowing(JoinPoint joinPoint,Throwable e) {
		System.out.println("异常通知："+e.getMessage());
	}
	
	/**
	 * 
	 * @Title: myAfter
	 * @Description: 最终通知
	 * @throws
	 * @author 作者：zc
	 * @date 创建时间：2017年10月20日 下午6:52:35
	 */
	public void myAfter() {
		System.out.println("最终通知");
	}
}
