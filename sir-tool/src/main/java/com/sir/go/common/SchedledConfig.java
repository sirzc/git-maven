package com.sir.go.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
 
/**
 * @Title: SchedledConfig.java
 * @Package com.stylefeng.guns.config
 * @Description: 加载定时任务
 * @author 作者：sirzc
 * @date 创建时间：2017年12月11日 上午10:38:02
 * @version V1.0
 */
@Configuration
@EnableScheduling
@Component
public class SchedledConfig {

	@Autowired
//	private SendEmail sendEmail;

	/**
	 * 
	 * @Title: sendEmail
	 * @Description: 每天九点发送用户意见或者建议 void
	 * @throws
	 * 			@author
	 *             作者：sirzc
	 * @date 创建时间：2017年12月11日 上午10:42:05
	 */
	@Scheduled(cron = "0 0 9 * * ?")
	public void sendEmail() {
		 
	}
}
