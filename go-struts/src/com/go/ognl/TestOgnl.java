package com.go.ognl;
 

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import ognl.Ognl;
import ognl.OgnlException;

/**
 * @Title: TestOgnl.java
 * @Package com.go.ognl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月10日 下午4:08:43
 * @version V1.0
 */
public class TestOgnl {
	@Test
	public void test() throws OgnlException {
		User user = new User();
		Group group = new Group();
		Branch branch = new Branch();
		
		branch.setBranchId("233");
		group.setBranch(branch);
		user.setGroup(group);
		
		//用Java进行访问
		System.out.println("this is java method :"+user.getGroup().getBranch().getBranchId());
		//用ognl进行访问
		System.out.println("this is ognl method :"+Ognl.getValue("group.branch.branchId", user));
		
		//设置username的属性为test
		user.setUsername("test");
		Map<Object, Object> context = new HashMap<>();
		context.put("u", user);
		System.out.println("this is ognl method with map :"+Ognl.getValue("#u.username", context, user));
	}
	
	@Test
	public void test1() throws OgnlException {
		User user = new User();
		user.setUsername("sir zhou");
		System.out.println("this username :"+Ognl.getValue("getUsername()",user));
	}
	
	@Test
	public void test2() {
		String key = "";
		switch (key) {
			case "":
				
				break;
			case "12":
				
				break;
	
			default:
				break;
		}
	}
}
