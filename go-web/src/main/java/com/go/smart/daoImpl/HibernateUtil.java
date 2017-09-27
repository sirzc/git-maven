package com.go.smart.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.go.dao.BaseDao;

/**
 * @ClassName: HibernateUtil
 * @Description: 获取sqlSession
 * @author 作者：zhouchao
 * @param <T>
 * @date 创建时间：2017年4月1日 下午2:42:21
 *
 */
public class HibernateUtil<T> implements BaseDao<T, Serializable> {
	
	@Autowired
	private HibernateTemplate hTemplate;

	public HibernateTemplate gethTemplate() {
		return hTemplate;
	}

	public void sethTemplate(HibernateTemplate hTemplate) {
		this.hTemplate = hTemplate;
	}

	@Override
	public void save(T object) {
		hTemplate.save(object);
	}

	@Override
	public int delete(T object) {
		hTemplate.delete(object);
		return 1;
	}
	
	@Override
	public void update(T object) {
		hTemplate.update(object);
	}

	@Override
	public Object get(Class<T> entity,Serializable id) {
		return hTemplate.get(entity, id);
	}

 
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> entity) {
//		String hql = "from "+entity.getSimpleName()+" order by id desc";
		String hql = "from "+entity.getSimpleName();
	    return (List<T>) hTemplate.find(hql);
	}
}
