package com.go.autowire;

/**
 * @Title: AutowireBean1.java
 * @Package com.go.autowire
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月19日 下午9:29:53
 * @version V1.0
 */
public class AutowireBean1 {
	private AutowireBean2 autowireBean2;

	public AutowireBean2 getAutowireBean2() {
		return autowireBean2;
	}

	public void setAutowireBean2(AutowireBean2 autowireBean2) {
		this.autowireBean2 = autowireBean2;
	}

	public void disPlay() {
		System.out.println("this is autowireBean1 method");
		autowireBean2.disPlay();
		
	}
}
