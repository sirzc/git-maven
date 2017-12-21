package com.encrypt.until;

import java.util.Random;

/**
 * @Title: DesUtil.java
 * @Package com.pdf.until
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：Administrator
 * @date 创建时间：2017年12月6日 下午3:16:56
 * @version V1.0
 */
public class DesUtil {
	public static String getPassword() {
		Random rd = new Random(); // 创建随机对象  
		String n = ""; // 保存随机数  
		String num ="";
		int rdGet; // 取得随机数  
		do{
			if (rd.nextInt() % 2 == 1){
				rdGet = Math.abs(rd.nextInt()) % 10 + 48; // 产生48到57的随机数(0-9的键位值)  
			} else{
				rdGet = Math.abs(rd.nextInt()) % 26 + 97; // 产生97到122的随机数(a-z的键位值)  
			}
			num += Integer.toString(rdGet);
			char num1 = (char) rdGet; // int转换char  
			System.out.println(num1);
			String dd = Character.toString(num1);
			n += dd;
		} while (n.length() < 4);// 设定长度，此处假定长度小于8  
		System.out.println(num);
		return n;

	}

	public static void main(String[] args) {
		System.out.println(getPassword());
	}
}