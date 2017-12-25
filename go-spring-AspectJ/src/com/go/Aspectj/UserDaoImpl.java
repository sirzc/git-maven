package com.go.Aspectj;

/**   
 * @Title: UserDaoImpl.java
 * @Package com.go.daoImpl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月19日 下午7:27:43
 * @version V1.0   
 */
public class UserDaoImpl implements UserDao {
 
	@Override
	public void save() {
		System.out.println("this is spring method");
		System.out.println(5/0);
	}

	@Override
	public void delete() {
		System.out.println("this is spring method delete");
	}
}
