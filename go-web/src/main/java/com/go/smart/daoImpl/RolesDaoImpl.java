package com.go.smart.daoImpl;

import org.springframework.stereotype.Repository;

import com.go.dao.RolesDao;
import com.go.smart.entity.Roles;

/** 
 * @Title: RolesDaoImpl.java
 * @Package com.go.smart.daoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月23日 上午8:56:44
 */
@Repository
public class RolesDaoImpl extends HibernateUtil<Roles> implements RolesDao {
	
}
