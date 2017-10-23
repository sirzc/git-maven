package com.go.aopCGLIB;
/**   
 * @Title: BookDao.java
 * @Package com.go.aopCGLIB
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月20日 下午4:45:43
 * @version V1.0   
 */
public class BookDao {
	
	public void save() {
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("this is BookDao " + method + " method");
	}
}
