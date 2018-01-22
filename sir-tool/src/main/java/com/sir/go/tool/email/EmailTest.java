package com.sir.go.tool.email;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sir.go.tool.email.entity.Email;
import com.sir.go.tool.email.entity.SubjectEmail;
import com.sir.go.tool.email.service.IEmail;
import com.sir.go.tool.email.service.impl.EmailImpl;
 
/** 
 * @Title: Test.java
 * @Package com.pms.tool.email
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 作者：b
 * @date 创建时间：2017年8月10日 上午11:22:27
 */
public class EmailTest {
	@org.junit.Test
	public void sendEmail() {
		Email email = new Email();
		email.setEmail("1069701475@qq.com");
		email.setUsername("周潮");
		email.setRecipientType("TO");
		Email  email1= new Email();
		email1.setEmail("zhouchao151724@163.com");
		email1.setUsername("生涯树");
		email1.setRecipientType("To");
		List<Email> lEmails = new ArrayList<Email>();
		lEmails.add(email);
		lEmails.add(email1);
		SubjectEmail subjectEmail = new SubjectEmail();
		subjectEmail.setSubject("邮件测试");
		subjectEmail.setContent("你收到的是163的邮件");
		subjectEmail.setSentDate(new Date());
		IEmail eInterface = new EmailImpl();
		try {
			eInterface.sendMail(lEmails, subjectEmail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
