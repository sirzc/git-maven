package com.go.javaSE;

import org.junit.Test;

/**   
 * @Title: Test.java
 * @Package com.go.javaSE
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月15日 下午9:37:06
 * @version V1.0   
 */
public class TestAbstract {
 
	@Test
	public void name() {
		FatherAbstract fAbstract = new  UseAbstract();
		System.out.println(fAbstract.getClass());
	}
}
