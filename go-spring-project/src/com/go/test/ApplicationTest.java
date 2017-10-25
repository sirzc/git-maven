package com.go.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.go.dao.UserDao;
import com.go.factory.MyBean;
import com.go.spring.BeanUntil;
import com.go.spring.Customer;

/**   
 * @Title: Test.java
 * @Package com.go.spring
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月19日 下午6:02:55
 * @version V1.0   
 */
public class ApplicationTest {
	
	@Test
	public void name() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(BeanUntil.APP);
		System.out.println(applicationContext);
		System.out.println("==============================");
		ApplicationContext context = new FileSystemXmlApplicationContext("D:\\NewWork\\git-maven\\go-spring-project\\src\\applicationContext.xml");
		System.out.println(context);
	}
	
	@Test
	public void getBeanTest() {
		Customer customer = BeanUntil.getBean("customer", Customer.class);
		customer.setName("spring");
		System.out.println(customer);
		Customer customer2 = BeanUntil.getBean("customer", Customer.class);
		System.out.println(customer2);
	}
	
	@Test
	public void getUaerDao() {
		UserDao userDao = BeanUntil.getBean("userDao", UserDao.class);
		System.out.println(userDao);
		userDao.save();
		UserDao userDao2 = (UserDao) BeanUntil.getBean("userDao");
		System.out.println(userDao2);
		userDao.save();
	}
	
	@Test
	public void myBeanFactoryTest() {
		MyBean bean = (MyBean) BeanUntil.getBean("myBean");
		MyBean bean2 = (MyBean) BeanUntil.getBean("myBean");
		System.out.println(BeanUntil.getBean("myBean"));
		System.out.println(bean);
		System.out.println(bean2);
	}
	
	@Test
	public void myBeanByStatic() {
		System.out.println(BeanUntil.getBean("myBeanByStatic"));
	}
	
	@Test
	public void stringTest() {
		String aString = "yes";
		String bString = "yes";
		if (aString.equals(bString)) {
			System.out.println(true);
		}
	}
}
