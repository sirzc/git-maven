package com.go.smart.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.go.service.ResourceService;
import com.go.smart.daoImpl.ResourceDaoImpl;
import com.go.smart.entity.Resources;
import com.go.tool.Pager;
import com.go.tool.Response;

/** 
 * @Title: ResourceServiceImpl.java
 * @Package com.go.smart.serviceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月23日 下午7:21:28
 */
@Service
public class ResourceServiceImpl implements ResourceService {

	@Resource
	private ResourceDaoImpl resourceDaoImpl;
	
	@Override
	public Response<Pager<Resources>> searchDatas(Resources resource) {
		Pager<Resources> pager = new Pager<Resources>();
		Response<Pager<Resources>> response = new Response<Pager<Resources>>();
		List<Resources> list = resourceDaoImpl.findAll(Resources.class);
		/**
		 * 进行分页处理,通过setRecords(list)计算出当前页显示的值有哪些
		 */
		pager.setPageSize(resource.getRows());
		pager.setCurrentPage(resource.getPage());
		pager.setTotalRecords(list.size());
		pager.setRecords(list);

		response.setSuccess(true);
		response.setResult(pager);
		return response;
	}


}
