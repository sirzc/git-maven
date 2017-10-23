package com.go.factory;
/**   
 * @Title: StaticBeanFactory.java
 * @Package com.go.factory
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月19日 下午8:54:53
 * @version V1.0   
 */
public class StaticBeanFactory {

	public static MyBean createBean() {
		return new MyBean();
	}
}
