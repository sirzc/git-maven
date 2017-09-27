package com.go.smart.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.go.service.UserService;
import com.go.smart.daoImpl.ResourceRolesDaoImpl;
import com.go.smart.daoImpl.UserDaoImpl;
import com.go.smart.daoImpl.UserRolesDaoImpl;
import com.go.smart.entity.Resource_Roles;
import com.go.smart.entity.Roles;
import com.go.smart.entity.User;
import com.go.smart.entity.User_Roles;
import com.go.tool.Pager;
import com.go.tool.Response;

/**
 * @Title: userServiceImpl.java
 * @Package com.go.smart.serviceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月23日 下午5:44:22
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDaoImpl userDaoImpl;

	@Resource
	private UserRolesDaoImpl uRolesDaoImpl;
	
	@Resource
	private ResourceRolesDaoImpl reRolesDaoImpl;

	@Override
	public Response<Pager<User>> searchDatas(User user) {
		Pager<User> pager = new Pager<User>();
		Response<Pager<User>> response = new Response<Pager<User>>();

		List<User_Roles> list = uRolesDaoImpl.findAll(User_Roles.class);
		// 筛选用户
		Set<User> users = new HashSet<>();
		for (User_Roles ur : list) {
			users.add(ur.getUser());
		}
		// 筛选用户对应权限
		List<User> uList = new ArrayList<>();
		for (User ur : users) {
			Set<Roles> roles = new HashSet<>();
			for (int i = 0; i < list.size(); i++) {
				if (ur.getId().equals(list.get(i).getUser_id())) {
					roles.add(list.get(i).getRoles());
				}
			}
			ur.setRoles(roles);
			uList.add(ur);
		}
		// List<User> uList = userDaoImpl.findAll(User.class);

		/**
		 * 按照id对数据进行排序
		 */
		Collections.sort(uList);
		/**
		 * 进行分页处理,通过setRecords(list)计算出当前页显示的值有哪些
		 */
		pager.setPageSize(user.getRows());
		pager.setCurrentPage(user.getPage());
		pager.setTotalRecords(uList.size());
		pager.setRecords(uList);

		response.setSuccess(true);
		response.setResult(pager);
		return response;
	}

	@Override
	public User getUserByName(String userName) {
		return userDaoImpl.getUserByName(userName);
	}

	@Override
	public Map<String, Set<String>> getRolesAndUrls(Integer id) {		
		Map<String, Set<String>> resourceMap = new HashMap<String, Set<String>>();
		List<User_Roles> uRoles = uRolesDaoImpl.findAllByUserId(User_Roles.class, id);
		if (uRoles == null || uRoles.isEmpty())
			return null;
        Set<String> urlSet = new HashSet<String>();
        Set<String> roles = new HashSet<String>();
        for (User_Roles ur : uRoles) {
            List<Resource_Roles> resourceList = reRolesDaoImpl.findAllByRolesId(Resource_Roles.class,ur.getRole_id());
            if (resourceList != null) {
                for (Resource_Roles resourceRoles : resourceList) {
                	String url = resourceRoles.getResource().getOpurl();
					if (!StringUtils.isEmpty(url)) {
						urlSet.add(url);
					}
				}
            }
            Roles role = ur.getRoles();
            if (role != null) {
                roles.add(role.getName());
            }
        }
        resourceMap.put("urls", urlSet);
        resourceMap.put("roles", roles);
        return resourceMap;
	}

}
