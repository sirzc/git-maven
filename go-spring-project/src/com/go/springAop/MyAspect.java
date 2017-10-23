package com.go.springAop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**   
 * @Title: MyAspect.java
 * @Package com.go.springAop
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月20日 下午5:34:52
 * @version V1.0   
 */
public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("方法执行前");
		Object object = arg0.proceed();
		System.out.println("方法执行后");
		return object;
	}
	
}
