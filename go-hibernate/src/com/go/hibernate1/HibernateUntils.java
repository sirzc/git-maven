package com.go.hibernate1;
/**   
 * @Title: HibernateUntils.java
 * @Package com.go.javaSE
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月17日 下午4:04:27
 * @version V1.0   
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUntils {
	// 声明一个私有的静态的 Configuration对象
	private static final Configuration CONFIGURATION;
	// 声明一个私有的静态的 SessionFactory对象
	private static final SessionFactory SESSION_FACTORY;
	// 通过静态代码块构建sessionfactory
	static {
		CONFIGURATION = new Configuration().configure();
		SESSION_FACTORY = CONFIGURATION.buildSessionFactory();
	}

	public static Session getSession() {
		return SESSION_FACTORY.openSession();
	}
	
	public static Session getCurrentSession() {
		return SESSION_FACTORY.getCurrentSession();
	}
}
