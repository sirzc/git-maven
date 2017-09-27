package com.go.smart.daoImpl;

import org.springframework.stereotype.Repository;

import com.go.dao.ResourceDao;
import com.go.smart.entity.Resources;

/** 
 * @Title: ResourceDaoImpl.java
 * @Package com.go.smart.daoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月23日 上午10:30:23
 */
@Repository
public class ResourceDaoImpl extends HibernateUtil<Resources> implements ResourceDao {
 
}
