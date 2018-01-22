package com.sir.go.tool.colsql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.sir.go.model.colleges.persistence.entity.TianfuProfessional;
import com.sir.go.model.colleges.service.ITianfuProfessionalService;
import com.sir.go.model.colleges.service.impl.TianfuProfessionalServiceImpl;

/**   
 * @Title: MajorMenuTest.java
 * @Package com.sir.go.tool.colsql
 * @Description: 组装专业菜单
 * @author 作者：sirzc
 * @date 创建时间：2018年1月17日 上午11:09:18
 * @version V1.0   
 */
public class MajorMenuTest {
	
	public static List<TianfuProfessional> getChird(String id,List<TianfuProfessional> root){
		List<TianfuProfessional> chirdList = new ArrayList<TianfuProfessional>();
		for (int i = 0; i < root.size(); i++) {
			 if(id.equals(root.get(i).getParentCode())) {	//父类ID 等于 子类的ID
				chirdList.add(root.get(i));
			 }		 
		}
		for (TianfuProfessional professional : chirdList) {
			if(professional.getMajorCode().length() == 4) {
				professional.setChirdMajor(getChird(professional.getMajorCode(), root));
			}
		}
		if(chirdList.size() == 0) {
			return null;
		}
		return chirdList;
	}
	
	
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context);
 		ITianfuProfessionalService tService = context.getBean("tianfuProfessionalServiceImpl", TianfuProfessionalServiceImpl.class);
 		Map<String, Object> map = new HashMap<String, Object>();
 		map.put("college_name", "北京大学");
 		List<TianfuProfessional> root = tService.selectByMap(map);	//需要格式化的数据
 		System.out.println(JSON.toJSON(root).toString());
 		
 		List<TianfuProfessional> major = new ArrayList<TianfuProfessional>(); //最终得到的菜单
 		for (int i = 0; i < root.size(); i++) {
			if("0".equals(root.get(i).getParentCode())) {
				major.add(root.get(i));
			}
		}
 		for (TianfuProfessional professional : major) {
			professional.setChirdMajor(getChird(professional.getMajorCode(), root));
		}
 		System.out.println(JSON.toJSON(major));
	}
	
}
