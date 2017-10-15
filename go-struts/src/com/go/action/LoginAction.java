package com.go.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @Title: LoginAction.java
 * @Package com.go.action
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年9月28日 下午4:32:38
 * @version V1.0
 */
public class LoginAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	public String error() {
		System.out.println("this is error method");
		return SUCCESS;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

}
