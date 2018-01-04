package com.sir.go.email.service;

import java.util.List;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import com.sir.go.email.entity.Email;
import com.sir.go.email.entity.SubjectEmail;
 
/** 
 * @Title: EmailInterface.java
 * @Package com.pms.tool.email
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月10日 上午9:20:24
 */
public interface IEmail {
	/**
	 * 发件人邮箱的 SMTP 服务器地址
	 */
	public static final String EMAIL_SMT_HOST = "smtp.163.com";
	/**
	 * 发件人邮箱地址登录账户
	 */
	public static final String EMAIL_SEND_ACCOUNT = "zhouchao151724@163.com";

	/**
	 * 发送人邮箱登录密码
	 */
	public static final String EMAIL_SEND_PASSWORD = "rs9658241";

	/**
	 * 发件人邮箱地址
	 */
	public static final String EMAIL_SEND_FROM = "zhouchao151724@163.com";
	/**
	 * 发件人别称
	 */
	public static final String EMAIL_SEND_NAEM = "雨果工作室";
	/**
	 * 
	 * @Title: sendMail
	 * @Description: 发送一封邮件，多个联系人
	 * @param lEmails 多个收件人
	 * @param subjectEmail 邮件内容的相关信息
	 * @throws Exception void 
	 * @throws
	 * @author 作者：b
	 * @date 创建时间：2017年8月10日 上午10:53:52
	 */
	public void sendMail(List<Email> lEmails,SubjectEmail subjectEmail) throws Exception;
	
	/**
	 * 
	 * @Title: createMimeMessage
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param session 和服务器交互的会话
	 * @param lEmails 多个收件人
	 * @param subjectEmail 邮件内容的相关信息
	 * @return MimeMessage 包含一封文本的简单邮件
	 * @throws Exception MimeMessage 
	 * @throws
	 * @author 作者：b
	 * @date 创建时间：2017年8月10日 上午10:52:33
	 */
	public MimeMessage createMimeMessage(Session session,List<Email> lEmails,SubjectEmail subjectEmail) throws Exception;
}
