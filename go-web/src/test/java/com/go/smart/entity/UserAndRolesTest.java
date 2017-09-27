package com.go.smart.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.app.until.BeanUntil;
import com.go.service.UserService;
import com.go.smart.daoImpl.RolesDaoImpl;
import com.go.smart.daoImpl.UserDaoImpl;
import com.go.smart.daoImpl.UserRolesDaoImpl;
import com.go.smart.entity.Roles;
import com.go.smart.entity.User;
import com.go.smart.entity.User_Roles;
import com.go.smart.serviceImpl.UserServiceImpl;
/**
 * @Title: UserAndRolesTest.java
 * @Package com.pms.smart.entity
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月22日 下午10:58:49
 */
public class UserAndRolesTest {

	@Test
	public void userTest() {
		UserDaoImpl userDao = (UserDaoImpl) BeanUntil.getBean("userDaoImpl", UserDaoImpl.class);
		System.out.println(userDao.gethTemplate());
		User user = new User();
		user.setUsername("wd");
		user.setName("吴凯");
		user.setPassword(BeanUntil.md5("123465", "pms"));
		user.setSalt("pms");
		user.setEmpId(1);
		userDao.save(user);
	}

	@Test
	public void rolesTest() {
		RolesDaoImpl rolesDaoImpl = (RolesDaoImpl) BeanUntil.getBean("rolesDaoImpl", RolesDaoImpl.class);
		System.out.println(rolesDaoImpl);
		Roles roles = new Roles();
		roles.setName("user");
		roles.setDescription("普通用户");
		rolesDaoImpl.save(roles);
	}

	@Test
	public void rolesUserTest() {
		UserRolesDaoImpl uDaoImpl = (UserRolesDaoImpl) BeanUntil.getBean("userRolesDaoImpl", UserRolesDaoImpl.class);
//		for (int i = 0; i < 3; i++) {
			User_Roles uRoles = new User_Roles();
			uRoles.setUser_id(3);
			uRoles.setRole_id(3);
			uDaoImpl.save(uRoles);
//		}
	}
	
	@Test
	public void test() {
		System.out.println(BeanUntil.md5("123465", "pms"));
		// fb79d57bc3a27e349abe8f66dd4c5917
		System.out.println(com.go.tool.BeanUntil.md5("123465", "pms"));
	}
	
	@Test
	public void gettest() {
		UserRolesDaoImpl uDaoImpl = (UserRolesDaoImpl) BeanUntil.getBean("userRolesDaoImpl", UserRolesDaoImpl.class);
		List<User_Roles> list = uDaoImpl.findAll(User_Roles.class);
		//筛选用户
		Set<User> users = new HashSet<>(); 
		for (User_Roles ur : list) {
			users.add(ur.getUser());
		}
		//筛选用户对应权限
		List<User> uList = new ArrayList<>();
		for (User ur : users) {
			Set<Roles> roles = new HashSet<>();
			for (int i = 0; i < list.size(); i++) {
				if(ur.getId().equals(list.get(i).getUser_id())) {
					roles.add(list.get(i).getRoles());
				}
			}
			ur.setRoles(roles);
			uList.add(ur);
		}
		Collections.sort(uList);
		for (User user : uList) {
			System.out.println(user.toString());
		}
	}
	
	@Test
	public void getUser() {
		UserDaoImpl uDaoImpl = (UserDaoImpl) BeanUntil.getBean("userDaoImpl", UserDaoImpl.class);
		List<User> list = uDaoImpl.findAll(User.class);
		for (User ur : list) {
			System.out.println(ur.toString());
		}
		
	}
	
	@Test
	public void getUserByName() {
		UserDaoImpl uDaoImpl = (UserDaoImpl) BeanUntil.getBean("userDaoImpl", UserDaoImpl.class);
		User user = uDaoImpl.getUserByName("admin");
		System.out.println(user.toString());
		
	}
	
	@Test
	public void rolesUserGetTest() {
		UserRolesDaoImpl uDaoImpl = (UserRolesDaoImpl) BeanUntil.getBean("userRolesDaoImpl", UserRolesDaoImpl.class);
		List<User_Roles> user_Roles=uDaoImpl.findAllByUserId(User_Roles.class, 1);
		for (User_Roles user_Roles2 : user_Roles) {
			System.out.println(user_Roles2);
		}
	}
	
	@Test
	public void getRolesAndUrlsTest() {
		UserService userService = (UserService) BeanUntil.getBean("userServiceImpl", UserServiceImpl.class);
		System.out.println(userService);
		Map<String, Set<String>> map = userService.getRolesAndUrls(1);
		Set<String> set = map.get("urls");
		Set<String> setc = map.get("roles");
		for (String string : setc) {
			System.out.println(string);
		}
		for (String string : set) {
			System.out.println(string);
		}
	}
}
