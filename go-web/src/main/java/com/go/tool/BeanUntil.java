package com.go.tool;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * @Title: BeanUntil.java
 * @Package com.go.tool
 * @Description: 获取bean,MD5加密
 * @author 作者：b
 * @date 创建时间：2017年8月22日 下午11:26:03
 */
public class BeanUntil {

	private static ApplicationContext app() {
		return  new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	public static <T> Object getBean(String className,Class<T> entity) {
		ApplicationContext app = app();
		Object object = app.getBean(className, entity);
		return object;
	}
	
	public static String md5(Object password,Object salts) {
		String hashAlgorithmName = "MD5";
		Object credentials =password;
		Object salt = ByteSource.Util.bytes(salts);
		int hashIterations = 1024;
		/*
		 * hashAlgorithmName: 加密类型
		 * credentials：明文密码
		 * salt：盐
		 * hashIterations：加密次数（散列的次数）
		 */
		Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		return result.toString();
	}
	
}
