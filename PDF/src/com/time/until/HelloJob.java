package com.time.until;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Title: HelloJob.java
 * @Package com.time.until
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：Administrator
 * @date 创建时间：2017年12月11日 上午10:04:24
 * @version V1.0
 */
public class HelloJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDetail detail = context.getJobDetail();
		String name = detail.getJobDataMap().getString("name");
		System.out.println("say hello " + name);
	}

}
