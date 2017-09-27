package com.go.dao;

import java.util.List;

/** 
 * @Title: ResourceRolesDao.java
 * @Package com.go.dao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月23日 上午9:09:45
 */
public interface ResourceRolesDao<T> {
	 List<T> findAllByRolesId(Class<T> entity, Integer id);
}
