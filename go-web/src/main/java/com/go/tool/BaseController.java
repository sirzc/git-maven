package com.go.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;

import com.go.smart.entity.ShiroUser;

/**
 * @Title: BaseController.java
 * @Package com.go.tool
 * @Description:基础 controller
 * @author 作者：b
 * @date 创建时间：2017年8月26日 下午3:02:43
 */
public class BaseController {
	// 控制器本来就是单例，这样似乎更加合理
	protected Logger logger = LogManager.getLogger(getClass());

	/**
	 * 获取当前登录用户对象
	 * 
	 * @return {ShiroUser}
	 */
	public ShiroUser getShiroUser() {
		return (ShiroUser) SecurityUtils.getSubject().getPrincipal();
	}

	/**
	 * 获取当前登录用户id
	 * 
	 * @return {Long}
	 */
	public int getUserId() {
		return this.getShiroUser().getId();
	}

	/**
	 * 获取当前登录用户名
	 * 
	 * @return {String}
	 */
	public String getStaffName() {
		return this.getShiroUser().getName();
	}

	/**
	 * redirect跳转
	 * 
	 * @param url
	 *            目标url
	 */
	protected String redirect(String url) {
		return new StringBuilder("redirect:").append(url).toString();
	}
}
