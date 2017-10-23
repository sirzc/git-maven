package com.go.test;
/**   
 * @Title: SpringAopTest.java
 * @Package com.go.test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月20日 下午6:23:45
 * @version V1.0   
 */

import org.junit.Test;

import com.go.dao.UserDao;
import com.go.spring.BeanUntil;

public class SpringAopTest {

	@Test
	public void name() {
		UserDao userDao = (UserDao) BeanUntil.getBean("proxyFactoryBean");
		userDao.save();
	}
}
