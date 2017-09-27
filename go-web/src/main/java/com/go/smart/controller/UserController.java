package com.go.smart.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.go.service.UserService;
import com.go.smart.entity.User;
import com.go.tool.Pager;
import com.go.tool.Response;

/** 
 * @Title: UserController.java
 * @Package com.go.smart.controller
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月23日 下午2:50:01
 */
@Controller
@RequestMapping(value="/users")
public class UserController {

	@Resource
	private UserService userServiceImpl;	
	
	@RequestMapping(value ="/manager",method=RequestMethod.GET)
	public String manager() {
		return "system/users";
	}
 
	@ResponseBody
	@RequestMapping(value = "/loadGrid", method = RequestMethod.POST)
	public Map<Object, Object> loadGrid(User user) {
		Map<Object, Object> map = new HashMap<>();
		Response<Pager<User>> responseResult = userServiceImpl.searchDatas(user);
		if (responseResult.isSuccess()) {
			Pager<User> pager = responseResult.getResult();
			map.put("total", pager.getTotalRecords());
			map.put("rows", pager.getRecords());
		}
		return map;
	}
	
	
}
