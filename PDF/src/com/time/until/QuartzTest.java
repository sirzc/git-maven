package com.time.until;

import org.junit.Test;

/**
 * @Title: QuartzTest.java
 * @Package com.time.until
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：Administrator
 * @date 创建时间：2017年12月11日 上午10:05:38
 * @version V1.0
 */
public class QuartzTest {

	@Test
	public void name() {
		String string = "/careerTest/add";
		String[] strings = string.split("/");
		System.out.println(strings.length);
		name1("str");
	}

	public String name1(String name) {
		if ("str".equals(name)){
			System.out.println("yes...");
			return null;
		}
		System.out.println("no");
		return name;
	}
}
