package com.go.javaSE;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Title: PropertiesUnit.java
 * @Package com.go.javaSE
 * @Description: 解析Properties配置文件
 * @author 作者：zc
 * @date 创建时间：2017年10月16日 下午12:24:37
 * @version V1.0
 */
public class PropertiesUnit {
	
	
	
	
	public static void main(String[] args) {
		Properties properties = new Properties();
		String address = "D:/NewWork/git-maven/go-struts/src/db.properties";
		try {
			FileInputStream input = new FileInputStream(address);
			properties.load(input);
			/**
			 * 使用这种方式获取db.properties中的值的时候，要求db.properties必须和当前类在同一个文件目录
			 */
//			properties.load(PropertiesUnit. class.getResourceAsStream("db.properties"));
			System.out.println(properties.getProperty("username"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(System.getProperty("user.dir"));
	}
}
