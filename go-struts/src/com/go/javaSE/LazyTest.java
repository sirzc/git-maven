package com.go.javaSE;

import java.util.Enumeration;
import java.util.Properties;

import org.junit.Test;

/**   
 * @Title: LazyTest.java
 * @Package com.go.javaSE
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月15日 下午10:35:55
 * @version V1.0   
 */
public class LazyTest {
	
	@Test
	public void LazyTest1() {
		System.out.println(LazySingle.getLazySingle());
		System.out.println(LazySingle.getLazySingle());
	}
	
	@Test
	public void test2() {
		Properties properties = System.getProperties();
		Enumeration<?> enumeration = properties.propertyNames();
		while (enumeration.hasMoreElements()) {
			Object object = (Object) enumeration.nextElement();
			String key = String.valueOf(object);
			System.out.println(key+" : "+System.getProperty(key));
		}
	}
}	

