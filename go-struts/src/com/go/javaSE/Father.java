package com.go.javaSE;

/**   
 * @Title: Father.java
 * @Package com.go.javaSE
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月15日 下午5:34:40
 * @version V1.0   
 */
public class Father extends GrandFather {
	{
		age = 40;
		name = "高翔";
		System.out.println("this is Father code");
	}
	
	public void goSleep() {
		System.out.println("father go to sleep");
	}
 
	@Override
	public void disPlay() {
		super.disPlay();
		System.out.println("this is Father disPlay method:"+age+","+name);
	}
}
