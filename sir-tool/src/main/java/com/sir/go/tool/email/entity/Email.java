package com.sir.go.tool.email.entity;

/**
 * @Title: Email.java
 * @Package com.pms.tool
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月9日 下午5:32:32
 */

public class Email {

	private String email;
	private String username;
	private String recipientType;

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRecipientType() {
		return recipientType;
	}

	public void setRecipientType(String recipientType) {
		this.recipientType = recipientType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
