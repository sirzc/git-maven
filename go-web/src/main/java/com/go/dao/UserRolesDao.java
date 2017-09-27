package com.go.dao;

import java.util.List;

import com.go.smart.entity.User_Roles;

/** 
 * @Title: UserRolesDao.java
 * @Package com.go.dao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月23日 上午9:09:24
 */
public interface UserRolesDao<T> {
	List<User_Roles> findAllByUserId(Class<T> entity,Integer id);
}
