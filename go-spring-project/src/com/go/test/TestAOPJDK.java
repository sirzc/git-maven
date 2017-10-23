package com.go.test;

import org.junit.Test;

import com.go.aopJDK.MyBeanFactory;
import com.go.aopJDK.StudentDao;

/**   
 * @Title: AOPtest.java
 * @Package com.go.test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月19日 下午10:06:57
 * @version V1.0   
 */
public class TestAOPJDK {
	
	@Test
	public void aopTest() {
		StudentDao studentDao=MyBeanFactory.getBean();
		
		studentDao.delete();
		studentDao.find();
		studentDao.save();
		studentDao.update();
	}
}
