package com.go.aopCGLIB;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.go.aopJDK.MyAspect;

/**
 * @Title: MyBeanFactory.java
 * @Package com.go.aopCGLIB
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月20日 下午4:47:14
 * @version V1.0
 */
public class MyBeanFactory {
	public static BookDao getBean() {
		// 创建目标对象
		final BookDao bookDao = new BookDao();
		// 创建切面实例
		final MyAspect myAspect = new MyAspect();
		// 生成代理类，CGLIB在运行时，生成指定对象的子类，增强
		// 核心类
		Enhancer enhancer = new Enhancer();
		// 确定需要增强的类
		enhancer.setSuperclass(bookDao.getClass());
		// 添加回调函数
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)
					throws Throwable {
				// TODO Auto-generated method stub
				myAspect.myBefore();
				Object object = method.invoke(bookDao, args);
				myAspect.myAfter();
				return object;
			}
		});
		// 创建代理类
		BookDao bookDaoProxy = (BookDao) enhancer.create();
		return bookDaoProxy;
	}
}
