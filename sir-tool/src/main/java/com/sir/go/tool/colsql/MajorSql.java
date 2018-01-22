package com.sir.go.tool.colsql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.sir.go.model.colleges.persistence.entity.ColMajor;
import com.sir.go.model.colleges.persistence.entity.ColMajorDetail;
import com.sir.go.model.colleges.service.IColMajorDetailService;
import com.sir.go.model.colleges.service.IColMajorService;
import com.sir.go.model.colleges.service.impl.ColMajorDetailServiceImpl;
import com.sir.go.model.colleges.service.impl.ColMajorServiceImpl;

/**   
 * @Title: MajorSql.java
 * @Package com.sir.go.tool.colsql
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：sirzc
 * @date 创建时间：2018年1月11日 下午3:00:38
 * @version V1.0   
 */
public class MajorSql {
 
	public void updateMajor() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context);
		IColMajorDetailService iMajor = context.getBean("colMajorDetailServiceImpl", ColMajorDetailServiceImpl.class);
		IColMajorService iProfessional = context.getBean("colMajorServiceImpl", ColMajorServiceImpl.class);
		List<ColMajorDetail> cDetails = iMajor.selectList(null);
		Map<Integer, String> question = new HashMap<Integer, String>();
		for (int i = 0; i < cDetails.size(); i++) {
			 ColMajorDetail colMajorDetail = new ColMajorDetail();
			 colMajorDetail = cDetails.get(i);
			 String major = colMajorDetail.getMajor();
			 Map<String, Object> map = new HashMap<String, Object>();
			 map.put("professional", major);
			 List<ColMajor> list = iProfessional.selectByMap(map);
			 if(list.size()>0) {
				 String Moc = list.get(0).getMoc();
				 colMajorDetail.setMoc(Moc);
				 colMajorDetail.updateById();
			 }else {
				 question.put(colMajorDetail.getId(), major);
			 }
		}
		System.out.println("==============================【end】===============================");
		System.out.println(question.toString());
	}
	
 
	@Test
	public void name() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context);
		IColMajorDetailService iMajor = context.getBean("colMajorDetailServiceImpl", ColMajorDetailServiceImpl.class);
		IColMajorService iProfessional = context.getBean("colMajorServiceImpl", ColMajorServiceImpl.class);
		Wrapper<ColMajorDetail> wrapper = new EntityWrapper<ColMajorDetail>();
		wrapper.isNull("Poc");
		List<ColMajorDetail> cDetails = iMajor.selectList(wrapper);
		Map<Integer, String> question = new HashMap<Integer, String>();
		for (int i = 0; i < cDetails.size(); i++) {
			 ColMajorDetail colMajorDetail = new ColMajorDetail();
			 colMajorDetail = cDetails.get(i);
			 String major = colMajorDetail.getMajor().split("\\(")[0];
			 Map<String, Object> map = new HashMap<String, Object>();
			 map.put("professional", major);
			 List<ColMajor> list = iProfessional.selectByMap(map);
			 if(list.size()>0) {
				 String Poc = list.get(0).getMoc();
				 colMajorDetail.setMoc(Poc);
				 colMajorDetail.updateById();
			 }else {
				 question.put(colMajorDetail.getId(), major);
			 }
		}
		System.out.println("==============================【end】===============================");
		System.out.println(question.toString());
	}
 
}
