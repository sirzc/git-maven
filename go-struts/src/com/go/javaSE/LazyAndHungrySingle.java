package com.go.javaSE;
 
/**
 * @Title: LazyAndHungrySingle.java
 * @Package com.go.javaSE
 * @Description: 通过内部类实现 懒汉模式和饿汉模式结合 的单列模式
 * @author 作者：zc
 * @date 创建时间：2017年10月16日 下午4:31:28
 * @version V1.0
 */
public class LazyAndHungrySingle {
	
	private LazyAndHungrySingle() {
		 
	}
	
	public static class LazyAndHungry{
		private static LazyAndHungrySingle lazyAndHungrySingle = new LazyAndHungrySingle();
	}
 
	public static LazyAndHungrySingle getInstance() {
		return LazyAndHungry.lazyAndHungrySingle;
	}
	
}
