package com.sir.go.tool.email.service.impl;

import java.util.List;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sir.go.tool.email.entity.Email;
import com.sir.go.tool.email.entity.SubjectEmail;
import com.sir.go.tool.email.service.IEmail;
 
/**
 * @Title: EmailImpl.java
 * @Package com.pms.tool.email
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月10日 上午9:35:44
 */
public class EmailImpl implements IEmail {

	public void sendMail(List<Email> lEmails,SubjectEmail subjectEmail) throws Exception {
		// 1. 创建参数配置, 用于连接邮件服务器的参数配置
		Properties props = new Properties(); // 参数配置
		props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
		props.setProperty("mail.smtp.host", EMAIL_SMT_HOST); // 发件人的邮箱的 SMTP 服务器地址
		props.setProperty("mail.smtp.auth", "true"); // 需要请求认证

		// 2. 根据配置创建会话对象, 用于和邮件服务器交互
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true); // 设置为debug模式, 可以查看详细的发送 log

		// 3. 创建一封邮件
		MimeMessage message = createMimeMessage(session,lEmails,subjectEmail);

		// 4. 根据 Session 获取邮件传输对象
		Transport transport = session.getTransport();

		// 5. 使用 邮箱账号(登录帐户) 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
		transport.connect(EMAIL_SEND_ACCOUNT, EMAIL_SEND_PASSWORD);

		// 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人,
		// 密送人
		transport.sendMessage(message, message.getAllRecipients());

		// 7. 关闭连接
		transport.close();
	}

	public MimeMessage createMimeMessage(Session session,List<Email> lEmails,SubjectEmail subjectEmail)
			throws Exception {
		// 1. 创建一封邮件
		MimeMessage message = new MimeMessage(session);

		// 2. From: 发件人
		message.setFrom(new InternetAddress(EMAIL_SEND_FROM, EMAIL_SEND_NAEM, "UTF-8"));
		
		// 3. To: 收件人（可以增加多个收件人、抄送、密送）
		boolean flag = true;
		for (Email email : lEmails) {
			// To: 增加收件人（可选）
			if("TO".equals(email.getRecipientType()) && flag == true) {
				message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email.getEmail(), email.getUsername(), "UTF-8"));
				flag = false;
			}
			if("TO".equals(email.getRecipientType()) && flag == false) {
				message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email.getEmail(), email.getUsername(), "UTF-8"));
			}
			// Cc: 抄送（可选）
			if("CC".equals(email.getRecipientType())) {
				message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress(email.getEmail(), email.getUsername(), "UTF-8"));
			}
			// Bcc: 密送（可选）
			if("BCC".equals(email.getRecipientType())) {
				message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress(email.getEmail(), email.getUsername(), "UTF-8"));
			}
		}				

		// 4. Subject: 邮件主题
		message.setSubject(subjectEmail.getSubject(), "UTF-8");

		// 5. Content: 邮件正文（可以使用html标签）
		message.setContent(subjectEmail.getContent(), "text/html;charset=UTF-8");

		// 6. 设置发件时间
		message.setSentDate(subjectEmail.getSentDate());

		// 7. 保存设置
		message.saveChanges();

		return message;
	}

}
