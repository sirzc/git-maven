package com.go.service;

import com.go.smart.entity.Resources;
import com.go.tool.Pager;
import com.go.tool.Response;

/** 
 * @Title: ResourceService.java
 * @Package com.go.service
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月23日 下午7:20:27
 */
public interface ResourceService {

	Response<Pager<Resources>> searchDatas(Resources resource);

}
