package com.time.until;

import java.util.Date;

/**
 * @Title: MyTimer.java
 * @Package com.time.until
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：Administrator
 * @date 创建时间：2017年12月11日 上午9:57:14
 * @version V1.0
 */
public class MyTimer extends Thread {
	private Long time;

	public MyTimer(Long time){
		this.time = time;
	}

	@Override
	public void run() {
		while (true){
			try{
				Thread.sleep(time);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			send();
		}
	}

	/**
	 * 开始执行任务
	 */
	public void execute() {
		this.start();
	}

	/**
	 * 定时任务
	 */
	private void send() {
		System.out.println("任务执行了:" + new Date());
	}

	public static void main(String[] args) {
		MyTimer myTimer = new MyTimer(2000L);
		myTimer.execute();
	}

}
