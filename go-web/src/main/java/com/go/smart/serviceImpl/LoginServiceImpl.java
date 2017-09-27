package com.go.smart.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.go.service.LoginService;
import com.go.smart.daoImpl.ResourceDaoImpl;
import com.go.smart.daoImpl.ResourceRolesDaoImpl;
import com.go.smart.daoImpl.UserRolesDaoImpl;
import com.go.smart.entity.Resource_Roles;
import com.go.smart.entity.Resources;
import com.go.smart.entity.ShiroUser;
import com.go.smart.entity.User_Roles;

/** 
 * @Title: LoginServiceImpl.java
 * @Package com.go.smart.serviceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月23日 上午9:44:41
 */
@Service
public class LoginServiceImpl implements LoginService{

	@Resource
	private ResourceDaoImpl resourceDaoImpl;

	@Resource
	private UserRolesDaoImpl uRolesDaoImpl;
	
	@Resource
	private ResourceRolesDaoImpl reRolesDaoImpl;
	
	@Override
	public List<Resources> selectTree(ShiroUser shiroUser) {
		Set<String> roles = shiroUser.getRoles();
	    if (roles == null) {
            return null;
        }
	    // 如果有超级管理员权限
        if (roles.contains("sys")) {
        	return resourceDaoImpl.findAll(Resources.class);
        }
      
        List<User_Roles> uRoles = uRolesDaoImpl.findAllByUserId(User_Roles.class, shiroUser.getId());
		if (uRoles == null || uRoles.isEmpty()) {
			return null;
		}
        Set<Resources> resources = new HashSet<Resources>();
        for (User_Roles ur : uRoles) {
            List<Resource_Roles> resourceList = reRolesDaoImpl.findAllByRolesId(Resource_Roles.class,ur.getRole_id());
            if (resourceList != null) {
                for (Resource_Roles resourceRoles : resourceList) {
                	resources.add(resourceRoles.getResource());
				}
            }
        }
        List<Resources> list = new ArrayList<>(resources);
        /**
		 * 按照id对数据进行排序
		 */
		Collections.sort(list);
        return list;
	}

	 
	
}
