package com.go.smart.daoImpl;

import org.springframework.stereotype.Repository;

import com.go.dao.UserDao;
import com.go.smart.entity.User;

/** 
 * @Title: UserDaoImpl.java
 * @Package com.go.smart.daoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月22日 下午11:33:04
 */
@Repository
public class UserDaoImpl extends HibernateUtil<User> implements UserDao{

	@Override
	public User getUserByName(String username) {
		String hql=" from com.pms.smart.entity.User where username=?";
		if(gethTemplate().find(hql, username).isEmpty())
		  return null;
		return (User) gethTemplate().find(hql, username).get(0);
	}

}
