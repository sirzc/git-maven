package com.go.javaSE;
/**   
 * @Title: DemoCode.java
 * @Package com.go.javaSE
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月18日 上午10:45:51
 * @version V1.0   
 */
public class DemoCode {
	
	static {
		System.out.println("this is static code >> father");
	}
	{
		System.out.println("this is code >> father");
	}
	public DemoCode() {
		System.out.println("this is static construct code >> father");
	}
}
