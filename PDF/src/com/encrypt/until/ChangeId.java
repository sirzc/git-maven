package com.encrypt.until;

import java.util.Random;

/**   
 * @Title: ChangeId.java
 * @Package com.pdf.until
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：Administrator
 * @date 创建时间：2017年12月6日 下午4:26:20
 * @version V1.0   
 */
public class ChangeId {

	public static String encrypt(Integer id,String key) {
		Random rd = new Random(); // 创建随机对象  
		int rdGet = Math.abs(rd.nextInt()) % 26 + 65;
		String str = Long.toString((2147483647l-id*rdGet), 32);
		str = str.toUpperCase();
		char num1 = (char) rdGet;
		String response = "";
		response+=key;
		response+=str;
		response+=num1;
		return response;
	}
	
	public static Integer decrypt(String encrypt) {
		int length =  encrypt.length();
		String str = encrypt.substring(1, length-1); //获取32位值
		str = str.toLowerCase();
		String rdGet = encrypt.substring(length-1,length); //获取自动生成的字符串
		char ch = rdGet.charAt(0);
		Integer cha = (int) ch;
		int response = (2147483647-Integer.parseInt(str, 32))/cha; //获取传入的Id值
		return response;
	}
	public static void main(String[] args) {
//		String request = encrypt(Integer.getInteger("151@163.com"), "T");
//		System.out.println(request);
		System.out.println(decrypt("U1VVVGN7U"));
		System.out.println("4564456465".matches("[0-9]*"));
	}
}
