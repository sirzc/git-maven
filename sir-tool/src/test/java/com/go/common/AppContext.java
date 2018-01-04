package com.go.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContext {
	private static final String APP = "applicationContext.xml";
	private static final ApplicationContext context = new ClassPathXmlApplicationContext(APP);

	/**
	 * 获取连接对象
	 * @return
	 */
	public static ApplicationContext getContext() {
		return context;
	}
	
	public static Object getBean(String arg0) {
		return context.getBean(arg0);
	}
	
	public static <T> Object getBean(String arg0,Class<T> arg1) {
		return context.getBean(arg0, arg1);
	}
}
