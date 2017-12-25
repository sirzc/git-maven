package com.go.javaSE;

import java.util.Scanner;

/**
 * @Title: ThrowDemo.java
 * @Package com.go.javaSE
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月24日 下午8:24:53
 * @version V1.0
 */
public class ThrowDemo {
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(System.in);
			int age = Integer.parseInt(in.next());
			if (age < 0 || age > 130) {
				// 创建一个异常实例，并将其手工抛出
				throw new Exception("您输入的年龄无效。");
			}
			System.out.println("您的年龄是：" + age + "岁。");
		} catch (Exception e) // 捕捉异常
		{
			// 打印出异常信息
			System.out.println(e.getMessage());
		}
	}

}
