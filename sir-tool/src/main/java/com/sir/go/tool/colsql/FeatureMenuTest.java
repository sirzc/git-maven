package com.sir.go.tool.colsql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.sir.go.model.job.persistence.entity.FeatureReference;
import com.sir.go.model.job.service.IFeatureReferenceService;
import com.sir.go.model.job.service.impl.FeatureReferenceServiceImpl;

/**
 * @Title: MajorMenuTest.java
 * @Package com.sir.go.tool.colsql
 * @Description: 组装专业菜单
 * @author 作者：sirzc
 * @date 创建时间：2018年1月17日 上午11:09:18
 * @version V1.0
 */
public class FeatureMenuTest {

	public static List<FeatureReference> getChird(String id, List<FeatureReference> root) {
		List<FeatureReference> chirdList = new ArrayList<FeatureReference>();
		for (int i = 0; i < root.size(); i++){
			String chirdId = root.get(i).getElementID();
			if (id.equals(chirdId.substring(0, id.length())) && chirdId.length() == (id.length() + 2)){
				chirdList.add(root.get(i));
			}
		}
		for (FeatureReference feature : chirdList){
			if (feature.getElementID().length() == 7){
				feature.setChirdFeature(getChird(feature.getElementID(), root));
			}
		}
		if (chirdList.size() == 0){
			return null;
		}
		return chirdList;
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context);
		IFeatureReferenceService fService = context.getBean("featureReferenceServiceImpl",
				FeatureReferenceServiceImpl.class);
		List<FeatureReference> root = fService.selectList(null); //需要格式化的数据
		System.out.println(JSON.toJSON(root).toString());
		List<FeatureReference> feature = new ArrayList<FeatureReference>(); //最终得到的菜单
		for (int i = 0; i < root.size(); i++){
			if (root.get(i).getElementID().length() == 1){
				feature.add(root.get(i));
			}
		}
		for (FeatureReference professional : feature){
			professional.setChirdFeature(getChird(professional.getElementID(), root));
		}
		System.out.println(JSON.toJSON(feature));
	}

}
