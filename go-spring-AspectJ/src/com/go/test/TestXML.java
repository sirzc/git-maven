package com.go.test;

import org.junit.Test;

import com.go.Aspectj.BeanUntil;
import com.go.Aspectj.UserDao;

/**   
 * @Title: TestXML.java
 * @Package com.go.test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月23日 下午2:25:28
 * @version V1.0   
 */
public class TestXML {
	
	@Test
	public void testAspectjXml() {
		UserDao userDao = (UserDao) BeanUntil.getBean("userDao");
		userDao.delete();
		userDao.save();
	}
}
