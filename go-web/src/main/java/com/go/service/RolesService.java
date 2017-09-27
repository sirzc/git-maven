package com.go.service;

import com.go.smart.entity.Roles;
import com.go.tool.Pager;
import com.go.tool.Response;

/** 
 * @Title: RolesService.java
 * @Package com.go.service
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月23日 下午7:11:30
 */
public interface RolesService {

	Response<Pager<Roles>> searchDatas(Roles roles);

}
