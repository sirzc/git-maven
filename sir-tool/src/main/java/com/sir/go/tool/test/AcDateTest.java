package com.sir.go.tool.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.sir.go.common.utils.ToolUtil;
import com.sir.go.model.ac.persistence.entity.AcDetail;
import com.sir.go.model.ac.persistence.entity.AcDetailTest;

/**
 * @Title: AcDateTest.java
 * @Package com.sir.go.tool.test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：sirzc
 * @date 创建时间：2018年1月17日 下午4:40:33
 * @version V1.0
 */
public class AcDateTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context);
		AcDetailTest ac = new AcDetailTest();
		Wrapper<AcDetailTest> wrapper = new EntityWrapper<AcDetailTest>();
		wrapper.where("1=1").groupBy("major,college_name").orderBy("Coc").orderBy("Moc").orderBy("id");
		List<AcDetailTest> acDetailTests = ac.selectList(wrapper);
		String one = null;
		String two = null;
		for (AcDetailTest a : acDetailTests) {
			if(ToolUtil.isNotEmpty(a.getMoc())) {	//如果存在Moc
				String Moc = a.getMoc();
				if(Moc.length()==4) {
					String str1 = Moc.substring(0, 2);
					if (!str1.equals(one)) {
						one = str1;
						AcDetail acDetail = new AcDetail();
						acDetail.setCoc(a.getCoc());
						acDetail.setCollegeName(a.getCollegeName()); 
					   	acDetail.setCollegeLevel(a.getCollegeLevel());
					   	acDetail.setMajorClass(a.getMajorClass());
					   	acDetail.setMajor(a.getMajor());
			 		    acDetail.setMoc(str1);
			 		    acDetail.setParentMoc("0");
			 		    acDetail.setSubject(a.getSubject());
			 		    acDetail.setTop(a.getTop());
			 		    acDetail.setCategory(a.getCategory());
						acDetail.insert();
					}
					AcDetail acDetail = new AcDetail();
					acDetail.setCoc(a.getCoc());
					acDetail.setCollegeName(a.getCollegeName()); 
				   	acDetail.setCollegeLevel(a.getCollegeLevel());
				   	acDetail.setMajorClass(a.getMajorClass());
				   	acDetail.setMajor(a.getMajor());
		 		    acDetail.setMoc(a.getMoc());
		 		    acDetail.setParentMoc(two);
		 		    acDetail.setSubject(a.getSubject());
		 		    acDetail.setTop(a.getTop());
		 		    acDetail.setCategory(a.getCategory());
					acDetail.insert();
				}else {
					String str1 = Moc.substring(0, 2);
					if (!str1.equals(one)) {
						one = str1;
						AcDetail acDetail = new AcDetail();
						acDetail.setCoc(a.getCoc());
						acDetail.setCollegeName(a.getCollegeName()); 
					   	acDetail.setCollegeLevel(a.getCollegeLevel());
					   	acDetail.setMajorClass(a.getMajorClass());
					   	acDetail.setMajor(a.getMajor());
			 		    acDetail.setMoc(str1);
			 		    acDetail.setParentMoc("0");
			 		    acDetail.setSubject(a.getSubject());
			 		    acDetail.setTop(a.getTop());
			 		    acDetail.setCategory(a.getCategory());
						acDetail.insert();
					}
					String str2 = Moc.substring(0, 4);
					if (!str2.equals(two)) {
						two = str2;
						AcDetail acDetail = new AcDetail();
						acDetail.setCoc(a.getCoc());
						acDetail.setCollegeName(a.getCollegeName()); 
					   	acDetail.setCollegeLevel(a.getCollegeLevel());
					   	acDetail.setMajorClass(a.getMajorClass());
					   	acDetail.setMajor(a.getMajor());
			 		    acDetail.setMoc(str2);
			 		    acDetail.setParentMoc(one);
			 		    acDetail.setSubject(a.getSubject());
			 		    acDetail.setTop(a.getTop());
			 		    acDetail.setCategory(a.getCategory());
						acDetail.insert();
					}
					AcDetail acDetail = new AcDetail();
					acDetail.setCoc(a.getCoc());
					acDetail.setCollegeName(a.getCollegeName()); 
				   	acDetail.setCollegeLevel(a.getCollegeLevel());
				   	acDetail.setMajorClass(a.getMajorClass());
				   	acDetail.setMajor(a.getMajor());
		 		    acDetail.setMoc(a.getMoc());
		 		    acDetail.setParentMoc(two);
		 		    acDetail.setSubject(a.getSubject());
		 		    acDetail.setTop(a.getTop());
		 		    acDetail.setCategory(a.getCategory());
					acDetail.insert();
				}				
			}else {
				AcDetail acDetail = new AcDetail();
				acDetail.setCoc(a.getCoc());
				acDetail.setCollegeName(a.getCollegeName()); 
			   	acDetail.setCollegeLevel(a.getCollegeLevel());
			   	acDetail.setMajorClass(a.getMajorClass());
			   	acDetail.setMajor(a.getMajor());
			   	acDetail.setMoc("00");
	 		    acDetail.setParentMoc("0");
	 		    acDetail.setSubject(a.getSubject());
	 		    acDetail.setTop(a.getTop());
	 		    acDetail.setCategory("QD");
				acDetail.insert();
			}
		}
	}

}
