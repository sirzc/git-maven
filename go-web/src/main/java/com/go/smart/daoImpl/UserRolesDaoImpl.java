package com.go.smart.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.go.dao.UserRolesDao;
import com.go.smart.entity.User_Roles;

/**
 * @Title: UserRolesDaoImpl.java
 * @Package com.go.smart.daoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月23日 上午9:10:27
 */
@Repository
public class UserRolesDaoImpl extends HibernateUtil<User_Roles> implements UserRolesDao<User_Roles> {

	@SuppressWarnings("unchecked")
	@Override
	public List<User_Roles> findAllByUserId(Class<User_Roles> entity, Integer id) {
		String hql = " from "+entity.getSimpleName()+" where user_id = ?";
		return (List<User_Roles>) gethTemplate().find(hql, id);
	} 

}
