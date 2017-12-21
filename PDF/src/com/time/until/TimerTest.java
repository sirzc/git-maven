package com.time.until;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Title: TimerTest.java
 * @Package com.time.until
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：Administrator
 * @date 创建时间：2017年12月11日 上午9:59:15
 * @version V1.0
 */
public class TimerTest {
	public static void main(String[] args) {
		Timer timer = new Timer();
		// 5s后执行
		// timer.schedule(new MyTask(), 5000);
		// 马上执行任务,每隔1000执行一次
		timer.scheduleAtFixedRate(new MyTask(), new Date(), 1000);
	}

}

// 定时任务,这是一个线程
class MyTask extends TimerTask {
	@Override
	public void run() {
		System.out.println("task execute "+ new Date());
	}
}
