package com.go.smart.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.go.dao.ResourceRolesDao;
import com.go.smart.entity.Resource_Roles;

/** 
 * @Title: ResourceRolesDaoImpl.java
 * @Package com.go.smart.daoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月23日 上午10:56:09
 */
@Repository
public class ResourceRolesDaoImpl extends HibernateUtil<Resource_Roles> implements ResourceRolesDao<Resource_Roles> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource_Roles> findAllByRolesId(Class<Resource_Roles> entity, Integer id) {
		String hql = " from "+entity.getSimpleName()+" where role_id = ?";
		return (List<Resource_Roles>) gethTemplate().find(hql, id);
	}

 
 

}
