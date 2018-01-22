package com.sir.go.tool;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.sir.go.model.ac.persistence.entity.AcDetail;
import com.sir.go.model.colleges.persistence.entity.ColSchool;

public class ToolTest {

	@Test
	public void name() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context);
		ColSchool colSchool = new ColSchool();
		long bgTime = new Date().getTime();
		List<ColSchool> lists = colSchool.selectAll().subList(0, 50);
		for (ColSchool col : lists) {
			Wrapper<AcDetail> wrapper = new EntityWrapper<AcDetail>();
			wrapper.where("Coc='"+col.getCoc()+"'");
			AcDetail acDetail = new AcDetail();
			acDetail. selectList(wrapper);
		}
		long endTime = new Date().getTime();
		double time = (double) (endTime - bgTime) / (double) 1000;
		System.out.println(time);
	}

}
