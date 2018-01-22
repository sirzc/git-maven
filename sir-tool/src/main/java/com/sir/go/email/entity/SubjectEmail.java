package com.sir.go.email.entity;

import java.util.Date;

/** 
 * @Title: SubjectEmail.java
 * @Package com.pms.tool.email
 * @Description: 邮件主题
 * @author 作者：b
 * @date 创建时间：2017年8月10日 上午11:07:36
 */
public class SubjectEmail {
	private String subject;//邮件主题
	private String content;//邮件内容
	private Date sentDate;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	
	
}
