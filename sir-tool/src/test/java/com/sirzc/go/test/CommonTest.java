package com.sirzc.go.test;

import org.junit.Test;

/**
 * @Title: CommonTest.java
 * @Package com.sirzc.go.test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：Administrator
 * @date 创建时间：2018年2月27日 下午4:33:56
 * @version V1.0
 */
public class CommonTest {
	@Test
	public void display() {
		String aString = "1.A.2";
		System.out.println(aString.substring(0, aString.length()));
	}
}
