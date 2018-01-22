package com.sirzc.go.test;

import java.util.Date;

import org.junit.Test;

import com.go.common.AppContext;
import com.sir.go.model.job.persistence.entity.JQuestion;
import com.sir.go.model.job.persistence.entity.JTest;
import com.sir.go.model.job.service.impl.JTestServiceImpl;
 
public class JobTest {

	@Test
	public  void name() {
		JTestServiceImpl jTestServiceImpl = (JTestServiceImpl) AppContext.getBean("JTestServiceImpl",JTestServiceImpl.class);
		JTest jTest = new JTest();
		jTest.setId("3");
		jTest.setTestName("个人生涯规划测验-职业兴趣");
		jTest.setTestNum(60);
		jTest.setDescription("本量表用以测定个体的职业兴趣，和协助个人职业规划。");
		jTest.setCreateTime(new Date());
		jTest.setFullDescription(
				" 约翰·霍兰德是美国约翰·霍普金斯大学心理学教授，美国著名的职业指导专家。他于1959年提出了具有广泛社会影响的职业兴趣理论。认为人的人格类型、兴趣与职业密切相关，兴趣是人们活动的巨大动力，凡是具有职业兴趣的职业，都可以提高人们的积极性，促使人们积极地、愉快地从事该职业，且职业兴趣与人格之间存在很高的相关性。\r\n"
						+ "本测验基于其提出的职业兴趣学说和职业数据库，旨在帮助个体更好地了解自身兴趣和优势、实现更好的生涯规划。\r\n" + "");
		jTestServiceImpl.insert(jTest);
	    
	}
	
	@Test
	public void name2() {
		AppContext.getContext();
		JQuestion jQuestion = new JQuestion();
		System.out.println(jQuestion.selectAll().get(0).toString());
	}
}
