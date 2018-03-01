package com.sirzc.go.excel;

import org.junit.Test;

import com.sir.go.common.utils.DateUtil;

/**   
 * @Title: DateTest.java
 * @Package com.sirzc.go.excel
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：sirzc
 * @date 创建时间：2018年1月29日 下午4:43:03
 * @version V1.0   
 */
public class DateTest {
	
	@Test
	public void name() {
		System.out.println(DateUtil.getDay());
		System.out.println(DateUtil.getAfterDayWeek("0"));
	}
}
