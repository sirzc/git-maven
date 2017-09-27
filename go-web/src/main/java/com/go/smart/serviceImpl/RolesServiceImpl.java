package com.go.smart.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.go.service.RolesService;
import com.go.smart.daoImpl.RolesDaoImpl;
import com.go.smart.entity.Roles;
import com.go.tool.Pager;
import com.go.tool.Response;

/** 
 * @Title: RolesServiceImpl.java
 * @Package com.go.smart.serviceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月23日 下午7:12:02
 */
@Service
public class RolesServiceImpl implements RolesService{

	@Resource
	private RolesDaoImpl rolesDaoImpl;
	
	@Override
	public Response<Pager<Roles>> searchDatas(Roles roles) {
		Pager<Roles> pager = new Pager<Roles>();
		Response<Pager<Roles>> response = new Response<Pager<Roles>>();
		List<Roles> list = rolesDaoImpl.findAll(Roles.class);
		/**
		 * 进行分页处理,通过setRecords(list)计算出当前页显示的值有哪些
		 */
		pager.setPageSize(roles.getRows());
		pager.setCurrentPage(roles.getPage());
		pager.setTotalRecords(list.size());
		pager.setRecords(list);

		response.setSuccess(true);
		response.setResult(pager);
		return response;
	}


}
