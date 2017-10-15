package com.go.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {

	public String index() throws Exception {
		System.out.println(getActionMessages() + "this is index method");
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(getActionMessages() + "this is execute method");
		return SUCCESS;
	}

	private static final long serialVersionUID = 1L;

}
