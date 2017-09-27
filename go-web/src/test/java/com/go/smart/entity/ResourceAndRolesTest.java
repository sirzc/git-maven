package com.go.smart.entity;

import java.util.List;

import org.junit.Test;

import com.app.until.BeanUntil;
import com.go.smart.daoImpl.ResourceDaoImpl;
import com.go.smart.daoImpl.ResourceRolesDaoImpl;
import com.go.smart.entity.Resource_Roles;
import com.go.smart.entity.Resources;

/**
 * @Title: ResourceAndRolesTest.java
 * @Package com.pms.smart.entity
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月23日 上午10:33:02
 */
public class ResourceAndRolesTest {

	@Test
	public void addResource() {
//		ResourceDaoImpl resourceDaoImpl = (ResourceDaoImpl) BeanUntil.getBean("resourceDaoImpl", ResourceDaoImpl.class);
//		Resource resource = new Resource();
//		resource.setPid(0); // 0表示基类
//		resource.setName("系统管理");
//		resource.setOpen(true);
//		resource.setDescription("系统管理");
//		resource.setResourceType(true);
//		resourceDaoImpl.save(resource);
		ResourceDaoImpl resourceDaoImpl = (ResourceDaoImpl) BeanUntil.getBean("resourceDaoImpl", ResourceDaoImpl.class);
		Resources resource = new Resources();
		resource.setpId(1); // 0表示基类
		resource.setName("用户管理");
		resource.setOpen(false);
		resource.setDescription("用户管理");
		resource.setResourceType(true);
		resourceDaoImpl.save(resource);
	}
	@Test
	public void addResourceAndRoles() {
		ResourceRolesDaoImpl resourceRolesDaoImpl = (ResourceRolesDaoImpl) BeanUntil.getBean("resourceRolesDaoImpl", ResourceRolesDaoImpl.class);
//		for (int i = 11; i < 14; i++) {
			Resource_Roles  roles = new Resource_Roles();
			roles.setRole_id(3);
			roles.setResource_id(13);
			resourceRolesDaoImpl.save(roles);
//		}
	}
	
	@Test
	public void findResourceAndRoles() {
		ResourceRolesDaoImpl resourceRolesDaoImpl = (ResourceRolesDaoImpl) BeanUntil.getBean("resourceRolesDaoImpl", ResourceRolesDaoImpl.class);
		List<Resource_Roles> resource_Roles=resourceRolesDaoImpl.findAll(Resource_Roles.class);
		for (Resource_Roles r : resource_Roles) {
			System.out.println(r.toString());
		}
	}
	
	@Test
	public void rolesUserGetTest() {
		ResourceRolesDaoImpl resourceRolesDaoImpl = (ResourceRolesDaoImpl) BeanUntil.getBean("resourceRolesDaoImpl", ResourceRolesDaoImpl.class);
		List<Resource_Roles> user_Roles=resourceRolesDaoImpl.findAllByRolesId(Resource_Roles.class, 1);
		for (Resource_Roles user_Roles2 : user_Roles) {
			System.out.println(user_Roles2);
		}
	}
}
