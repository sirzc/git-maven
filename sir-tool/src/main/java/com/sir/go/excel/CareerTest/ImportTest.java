package com.sir.go.excel.CareerTest;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.easy.excel.ExcelContext;
import org.easy.excel.result.ExcelImportResult;

import com.go.common.AppContext;
import com.sir.go.excel.CareerTest.entity.Options;
import com.sir.go.excel.CareerTest.entity.Question;
import com.sir.go.model.job.persistence.entity.JQuFactor;
import com.sir.go.model.job.persistence.entity.JQuestion;
import com.sir.go.model.job.persistence.entity.JTest;

public class ImportTest {
	public static void main(String[] args) throws Exception {
		// 准备excel文件流
		InputStream excelStream = new FileInputStream("C:/Users/Administrator/Desktop/questionImport1.xlsx");
		// 创建excel上下文实例,它的构成需要配置文件的路径
		ExcelContext context = new ExcelContext("excel-config.xml");
		// 按照xml配置中id为student的配置形式读取excel文件,并转换成StudentModel
		// 这里的第二个参数是值,标题是第几行开始,之前也说了标题之前的数据并不是规则的数据
		ExcelImportResult result = context.readExcel("question", 3, excelStream);
		// 打印导入结果,查看标题之前不规则的数据
		List<List<Object>> header = result.getHeader();
		System.out.println(header.get(0).get(1));
		System.out.println(header.get(1).get(1));
		System.out.println(header.get(2).get(1));
		// 查看学生集合导入结果
		List<Question> questions = result.getListBean();
		AppContext.getContext();
		/*
		 * 插入题目名称
		 */
		String jTestId = "C02";
		insertJtest(header, questions.size(),jTestId);
		System.out.println(questions.size());
		insertJQuestion(questions,jTestId);
	}

	public static void insertJtest(List<List<Object>> header, Integer num, String jTestId) {
		String testName = (String) header.get(0).get(1);
		String description = (String) header.get(1).get(1);
		String fullDescription = (String) header.get(2).get(1);
		JTest jTest = new JTest();
		jTest.setId(jTestId);
		jTest.setTestName(testName);
		jTest.setTestNum(num);
		jTest.setDescription(description);
		jTest.setCreateTime(new Date());
		jTest.setFullDescription(fullDescription);
		jTest.insert();
	}

	public static void insertJQuestion(List<Question> questions, String jTestId) {
		String id = jTestId + ".";
		for (Question question : questions) {
			JQuestion jQuestion = new JQuestion();
			jQuestion.setId(id + question.getSort());
			jQuestion.setQuestionTitle(question.getQuestionTitle());
			jQuestion.setFactorId(changeFactor(question.getFactorId()));
			jQuestion.setBelongId(jTestId);
			jQuestion.setSort(question.getSort());
			jQuestion.setElementID(changeElementID(question.getFactorId()));
			jQuestion.insert();
			insertJFactor(question.getOptions(), jQuestion.getId());
		}
	}

	public static void insertJFactor(Options options, String jQuId) {
		List<String> list = options.getList();
		for (int i = 0; i < list.size(); i++) {
			JQuFactor jQuFactor = new JQuFactor();
			jQuFactor.setBelongQuId(jQuId);
			jQuFactor.setScore(i+1);
			jQuFactor.setTip(list.get(i));
			jQuFactor.insert();
		}
	}

	/**
	 * 转换因子变为中文
	 * 
	 * @param factor
	 * @return
	 */
	public static String changeFactor(String factor) {
		if ("C02.I".equals(factor))
			factor = "独立性";
		if ("C02.S".equals(factor))
			factor = "社会性";
		if ("C02.C".equals(factor))
			factor = "保障性";
		if ("C02.U".equals(factor))
			factor = "支持感";
		if ("C02.R".equals(factor))
			factor = "认同感";
		if ("C02.A".equals(factor))
			factor = "成就感";
		return factor;
	}
	
	/**
	 * 转换因子变为中文
	 * 
	 * @param factor
	 * @return
	 */
	public static String changeElementID(String factor) {
		if ("C02.I".equals(factor))
			factor = "1.B.2.f";
		if ("C02.S".equals(factor))
			factor = "1.B.2.d";
		if ("C02.C".equals(factor))
			factor = "1.B.2.b";
		if ("C02.U".equals(factor))
			factor = "1.B.2.e";
		if ("C02.R".equals(factor))
			factor = "1.B.2.c";
		if ("C02.A".equals(factor))
			factor = "1.B.2.a";
		return factor;
	}
	
}
