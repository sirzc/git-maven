package com.go.service;

import java.util.Map;
import java.util.Set;

import com.go.smart.entity.User;
import com.go.tool.Pager;
import com.go.tool.Response;

/** 
 * @Title: UserService.java
 * @Package com.go.service.UserService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月23日 下午5:44:22
 */
public interface UserService{
	Response<Pager<User>> searchDatas(User user);

	User getUserByName(String userName);

	Map<String, Set<String>> getRolesAndUrls(Integer id);
}
