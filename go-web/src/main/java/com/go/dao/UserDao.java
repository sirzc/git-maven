package com.go.dao;

import com.go.smart.entity.User;

/** 
 * @Title: UserDao.java
 * @Package com.go.dao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月22日 下午11:32:52
 */
public interface UserDao{
	
	User getUserByName(String username);
}
