package com.go.bean;

/**   
 * @Title: Teacher.java
 * @Package com.go.bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月5日 下午5:06:09
 * @version V1.0   
 */
public class Teacher extends People{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}
	
	public void name() {
		System.out.println("this is method name in teacher");
	}
	
	public static void main(String[] args) {
		People people = new Teacher();
		people.name();
	}
}
