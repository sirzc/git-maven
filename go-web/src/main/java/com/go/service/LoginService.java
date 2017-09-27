package com.go.service;

import java.util.List;

import com.go.smart.entity.Resources;
import com.go.smart.entity.ShiroUser;

/** 
 * @Title: LoginService.java
 * @Package com.go.service
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月23日 上午11:42:05
 */
public interface LoginService {
	
	List<Resources> selectTree(ShiroUser shiroUser);
}
