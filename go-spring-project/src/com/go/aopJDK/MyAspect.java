package com.go.aopJDK;
/**   
 * @Title: MyAspect.java
 * @Package com.go.aop
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月19日 下午9:58:03
 * @version V1.0   
 */
public class MyAspect {

	public void myBefore() {
		System.out.println("方法执行前");
	}
	
	public void myAfter() {
		System.out.println("方法执行后");
	}
}
