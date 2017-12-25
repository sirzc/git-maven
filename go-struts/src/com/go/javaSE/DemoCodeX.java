package com.go.javaSE;
/**   
 * @Title: DemoCodeX.java
 * @Package com.go.javaSE
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月18日 上午10:49:07
 * @version V1.0   
 */
public class DemoCodeX extends DemoCode {
	private static String name;
	private String city;
	static {
		System.out.println("this is static code >> son");
		name="sar";
		
	}
	{
//		name="fds";
		city = "fgvd";
		System.out.println("this is code >> son");
	}
	public DemoCodeX() {
		System.out.println("this is static constructor code >> son");
	}
	public static void main(String[] args) {
		DemoCodeX demoCodeX = new DemoCodeX();
		System.out.println(DemoCodeX.name+"."+demoCodeX.city);
	}
}
