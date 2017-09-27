package com.go.smart.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.go.service.RolesService;
import com.go.smart.entity.Roles;
import com.go.tool.Pager;
import com.go.tool.Response;

/**
 * @Title: RolesController.java
 * @Package com.go.smart.controller
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月23日 下午2:54:30
 */
@Controller
@RequestMapping(value = "/roles")
public class RolesController {

	@Resource
	private RolesService rolesServiceImpl;
	
	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public String manager() {
		return "system/roles";
	}

	@ResponseBody
	@RequestMapping(value = "/loadGrid", method = RequestMethod.POST)
	public Map<Object, Object> loadGrid(Roles roles) {
		Map<Object, Object> map = new HashMap<>();
		Response<Pager<Roles>> responseResult = rolesServiceImpl.searchDatas(roles);
		if (responseResult.isSuccess()) {
			Pager<Roles> pager = responseResult.getResult();
			map.put("total", pager.getTotalRecords());
			map.put("rows", pager.getRecords());
		}
		return map;
	}
}
