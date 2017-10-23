package com.go.test;

import org.junit.Test;

import com.go.aopCGLIB.BookDao;
import com.go.aopCGLIB.MyBeanFactory;

/**   
 * @Title: TestCGLIB.java
 * @Package com.go.test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月20日 下午4:58:57
 * @version V1.0   
 */
public class TestCGLIB {

	@Test
	public void demo() {
		BookDao bookDao = MyBeanFactory.getBean();
		bookDao.save();
	}
}
