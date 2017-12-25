package com.go.Aspectj;
/**   
 * @Title: BeanUntil.java
 * @Package com.go.spring
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月19日 下午6:11:03
 * @version V1.0   
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanUntil{
	public static final String APP;
	private static ApplicationContext applicationContext;
	static {
		APP = "applicationContext.xml";
		applicationContext = new ClassPathXmlApplicationContext(APP);
	}

	public static <T> T getBean(String name,Class<T> requiredType) {
		return applicationContext.getBean(name,requiredType);
	}

	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}
}
