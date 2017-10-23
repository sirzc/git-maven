package com.go.aopJDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Title: MyBeanFactory.java
 * @Package com.go.aop
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月19日 下午9:59:27
 * @version V1.0
 */
public class MyBeanFactory {

	public static StudentDao getBean() {
		// 1.准备目标类（sprin 创建对象 IOC）
		final StudentDao studentDao = new StudentDaoImpl();
		// 2.创建切面实例
		final MyAspect myAspect = new MyAspect();
		// 3.使用代理类进行增强
		return (StudentDao) Proxy.newProxyInstance(MyBeanFactory.class.getClassLoader(), new Class[] { StudentDao.class },
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						myAspect.myBefore();
						Object object =method.invoke(studentDao, args);
						myAspect.myAfter();
						return object;
					}
				});
	}
}
