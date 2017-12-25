package com.go.javaSE;

/**   
 * @Title: GrandFather.java
 * @Package com.go.javaSE
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月15日 下午5:31:20
 * @version V1.0   
 */
public class GrandFather {
	
	private Integer money;
	protected Integer age;
	public String name;
	
	{
		age = 80;
		name = "高山";
		money = 50000;
		System.out.println("this is GrandFather code");
	}
	
	public void disPlay() {
		System.out.println("this is GrandFather disPlay method:"+money+","+age+","+name);
	}
}
