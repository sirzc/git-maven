package com.go.javaSE;

/**
 * @Title: HungrySingle.java
 * @Package com.go.javaSE
 * @Description: 饿汉模式
 * @author 作者：zc
 * @date 创建时间：2017年10月15日 下午11:39:24
 * @version V1.0
 */
public class HungrySingle {
	private HungrySingle hungrySingle = new HungrySingle();

	private HungrySingle() {

	}

	public HungrySingle getInstance() {
		return hungrySingle;
	}

}
