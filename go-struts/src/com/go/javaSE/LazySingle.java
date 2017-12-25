package com.go.javaSE;

/**
 * @Title: Single.java
 * @Package com.go.javaSE
 * @Description: 懒汉模式 - 单列模式
 * @author 作者：zc
 * @date 创建时间：2017年10月15日 下午10:27:40
 * @version V1.0
 */
public class LazySingle {

	private static LazySingle lazySingle = null;

	// 私有构造函数
	private LazySingle() {

	}

	public static LazySingle getLazySingle() {
		// if (lazySingle == null) {
		// lazySingle = new LazySingle();
		// }
		synchronized (LazySingle.class) {
			if (lazySingle == null) {
				lazySingle = new LazySingle();
			}
			return lazySingle;
		}
	}
}
