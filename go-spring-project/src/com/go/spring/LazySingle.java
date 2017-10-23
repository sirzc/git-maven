package com.go.spring;
/**   
 * @Title: LazySnace.java
 * @Package com.go.spring
 * @Description: 分别包含懒汉模式和饿汉模式的优点
 * @author 作者：zc
 * @date 创建时间：2017年10月19日 下午7:14:44
 * @version V1.0   
 */
public class LazySingle {
	
	public static class LazyAndHungry{
		private static LazySingle lSingle = new LazySingle();
	}
	
	private LazySingle() {
		
	}
	
	public static LazySingle getInstance() {
		return LazyAndHungry.lSingle;
	}
}
