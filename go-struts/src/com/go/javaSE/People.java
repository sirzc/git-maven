package com.go.javaSE;

/**   
 * @Title: People.java
 * @Package com.go.javaSE
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月23日 下午5:26:51
 * @version V1.0   
 */
public abstract class People {
	public abstract void name();
}

class  zhou{
	private String name;
	public zhou(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}