package com.go.spring;

 

import org.junit.Test;

import go.go_spring_java.App;

/**   
 * @Title: SystemTest.java
 * @Package com.go.spring
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年11月2日 下午11:18:44
 * @version V1.0   
 */
public class SystemTest {

	@Test
	public void systemTest() {
		System.out.println();
		System.out.println("this is test");
		System.out.println();
		App app = new App();
		app.disPlay();
	}
}
