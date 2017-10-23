package com.go.test;

import org.junit.Test;

import com.go.autowire.AutowireBean1;
import com.go.spring.BeanUntil;

/**   
 * @Title: AutowireBeanTest.java
 * @Package com.go.test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月19日 下午9:33:27
 * @version V1.0   
 */
public class AutowireBeanTest {

	@Test
	public void AutowireBean() {
		AutowireBean1 aBean1 = (AutowireBean1) BeanUntil.getBean("autowireBean1");
		aBean1.disPlay();
	}
}
