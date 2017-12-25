package com.go.javaSE;
/**   
 * @Title: RegSingSingle.java
 * @Package com.go.javaSE
 * @Description: 注册模式
 * @author 作者：zc
 * @date 创建时间：2017年10月16日 上午11:52:05
 * @version V1.0   
 */

import java.util.HashMap;
import java.util.Map;

public class RegSingSingle {

	public static Map<String, RegSingSingle> reg = new HashMap<>();

	static {
		RegSingSingle regSingSingle = new RegSingSingle();
		reg.put(regSingSingle.getClass().getName(), regSingSingle);
//		System.out.println(regSingSingle.getClass().getName());
	}

	private RegSingSingle() {

	}

	public static RegSingSingle getInstance(String key) {
		if (key == null)
			return null;
		try {
			if (reg.get(key) == null) {
				reg.put(key, RegSingSingle.class.newInstance());
			}
			return reg.get(key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}  
	}
	
	public static void main(String[] args) {
		RegSingSingle regSingSingle = RegSingSingle.getInstance("zhouchao");
		System.out.println(regSingSingle);
		RegSingSingle regSingSingle2 = RegSingSingle.getInstance("jkeke");
		System.out.println(regSingSingle2);
		System.out.println(reg);
	}
}
