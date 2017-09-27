package com.go.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @ClassName: BaseDao
 * @Description: 对象操作
 * @author 作者：zc
 * @date 创建时间：2017年9月22日 下午7:06:20
 * @param <T>
 * @param <PK>
 */
public interface BaseDao<T , PK extends Serializable>{
	
	/**
	 * 
	 * @Title: save
	 * @Description: 保存对象
	 * @param object void 
	 * @throws
	 *
	 */
	public void save(T object);

	/**
	 * @Title: delete
	 * @Description: 删除某个实体对象
	 * @param entity
	 * @param id
	 * @return int 
	 * @date 创建时间：2017年7月27日 上午10:51:58
	 */
	public int delete(T object);

	/**
	 * 
	 * @Title: update
	 * @Description: 更新对象
	 * @param object
	 * @throws
	 *
	 */
	public void update(T object);
	
	/**
	 * 
	 * @Title: get
	 * @Description: 根据ID获取，实体对象
	 * @param id
	 * @return Object 
	 * @throws
	 *
	 */
	public Object get(Class<T> entity,PK id);
	
	/***
	 * 
	 * @Title: findAll
	 * @Description: 查询所有实体
	 * @param entity
	 * @return List<T> 
	 * @date 创建时间：2017年7月27日 上午10:49:14
	 */
	public List<T> findAll(Class<T> entity);
	
}
