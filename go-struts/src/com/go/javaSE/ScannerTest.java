package com.go.javaSE;

import java.util.Scanner;

import org.junit.Test;

/**   
 * @Title: ScannerTest.java
 * @Package com.go.javaSE
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月24日 下午7:48:08
 * @version V1.0   
 */
public class ScannerTest {
	
	@Test
	public void name() {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		System.out.println(a);
	}
}
