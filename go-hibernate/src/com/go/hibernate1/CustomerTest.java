package com.go.hibernate1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

/**
 * @Title: CustomerTest.java
 * @Package com.go.hibernate1
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月16日 下午6:18:36
 * @version V1.0
 */
public class CustomerTest{
	
	@Test
	public void findTest() {
		Session session = HibernateUntils.getSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, 4);
		System.out.println(customer.toString());
		transaction.commit();
		session.close();
	}
	
	@Test
	public void insertTest() {
		Configuration configuration =new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		System.out.println("2323:"+session);
		System.out.println("2323:"+sessionFactory);
		Transaction transaction = session.beginTransaction();
		Customer customer = new Customer();
		customer.setId(5);
		customer.setName("王五");
		customer.setAge(20);
		customer.setSex("男");
		customer.setCity("上海");
		session.save(customer);	 
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void c3p0Test() {
		System.out.println(HibernateUntils.getSession());
		System.out.println(HibernateUntils.getSession());
		System.out.println(HibernateUntils.getSession());
		System.out.println(HibernateUntils.getSession());
	}
	
	@Test
	public void CriteriaTest() {
		 Session  session = HibernateUntils.getSession();
		 Transaction transaction = session.beginTransaction();
		 
		 Criteria criteria = session.createCriteria(Customer.class);
		 criteria.add(Restrictions.eq("name", "王五"));
		 @SuppressWarnings("unchecked")
		List<Customer> list = criteria.list();
		 for (Customer customer : list) {
			System.out.println(customer.toString());
		 }
		 transaction.commit();
		 session.close();
	}
}
