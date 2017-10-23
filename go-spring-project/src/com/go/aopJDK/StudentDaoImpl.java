package com.go.aopJDK;

/**
 * @Title: StudentDaoImpl.java
 * @Package com.go.aop
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月19日 下午9:50:53
 * @version V1.0
 */
public class StudentDaoImpl implements StudentDao {

	@Override
	public void save() {
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("this is studen " + method + " method");
	}

	@Override
	public void delete() {
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("this is studen " + method + " method");
	}

	@Override
	public void update() {
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("this is studen " + method + " method");
	}

	@Override
	public void find() {
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("this is studen " + method + " method");
	}

}
