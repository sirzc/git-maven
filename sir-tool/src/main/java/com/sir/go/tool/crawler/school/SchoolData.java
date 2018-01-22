package com.sir.go.tool.crawler.school;

import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sir.go.common.utils.ToolUtil;
import com.sir.go.model.colleges.persistence.entity.ColMajorDetail;
import com.sir.go.model.colleges.persistence.entity.ColSchool;
import com.sir.go.model.colleges.persistence.entity.ColSubjectRequiresd;
import com.sir.go.model.colleges.persistence.entity.ColTest;
import com.sir.go.model.colleges.service.IColSchoolService;
import com.sir.go.model.colleges.service.impl.ColSchoolServiceImpl;

/**
 * @Title: SchoolData.java
 * @Package com.sir.go.tool.crawler.school
 * @Description: 将获取的数据存入到数据库中
 * @author 作者：sirzc
 * @date 创建时间：2018年1月9日 下午3:46:59
 * @version V1.0
 */
public class SchoolData {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context);
		IColSchoolService iSchool = context.getBean("colSchoolServiceImpl", ColSchoolServiceImpl.class);
		List<ColSchool> schools = iSchool.selectList(null);
//		List<ColSchool> schoolsPlus = iSchool.selectList(null).subList(739, schools.size());
//		System.out.println(schoolsPlus.get(0).getId() + " " + schoolsPlus.size());
		SchoolData schoolData = new SchoolData();
		schoolData.insertColTest(schools);
	}


	public void name() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context);
		String Coc = "12660";
//		String[] str = new String[] { "12933", "12938", "12649", "12650", "12651", "12657", "12658", "12660", "12661",
//				"12662", "12739", "13031" };
//		Random rd = new Random(); // 创建随机对象
//		for (String Coc : str) {
			List<ColTest> colTests = SchoolDetail.getColTestsByCocWithHtml(Coc);
			ColTest cTest = colTests.get(colTests.size() - 3);
			System.out.println(cTest);
			if (ToolUtil.isNotEmpty(colTests)) {
				for (int i = colTests.size() - 3; i < colTests.size(); i++) {
					ColTest test = new ColTest();
					test = colTests.get(i);
					test.insert(); // 保存到colTest表中
					String[] majors = colTests.get(i).getMajors();
					if (ToolUtil.isNotEmpty(majors)) {
						insertColMajorDetail(majors, test);
					}
					String[] subjects = colTests.get(i).getSubjects();
					if (ToolUtil.isNotEmpty(subjects)) {
						insertColSubjectRequiresd(subjects, test);
					}
					System.out.println("===========================【success】==========================");
					System.out.println(colTests.get(i).toString());
				}
			}
//			int score = Math.abs(rd.nextInt()) % 5 + 1; // 随机分数
//			try {
//				Thread.currentThread().sleep(2000 + 1000 * score);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
/*
	@Test
	public void delete() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context);
		String[] str = new String[] { "12933", "12938", "12649", "12650", "12651", "12657", "12658", "12660", "12661",
		"12662", "12739", "13031" };
		for (String string : str) {
			Wrapper<ColTest> wrapperTest = new EntityWrapper<ColTest>();
			wrapperTest.where("Coc", string);
			ColTest colTest = new ColTest();
			colTest.delete(wrapperTest);
			
			Wrapper<ColMajorDetail> wrapperCmd = new EntityWrapper<ColMajorDetail>();
			wrapperCmd.where("Coc", string);
			ColMajorDetail cmd = new ColMajorDetail();
			cmd.delete(wrapperCmd);
			
			Wrapper<ColSubjectRequiresd> wrapperCsr = new EntityWrapper<ColSubjectRequiresd>();
			wrapperCsr.where("Coc", string);
			ColSubjectRequiresd csr = new ColSubjectRequiresd();
			csr.delete(wrapperCsr);
		}
		 
		
	}
*/	
	@SuppressWarnings("static-access")
	private void insertColTest(List<ColSchool> schools) {
		for (ColSchool colSchool : schools) {
			String Coc = colSchool.getCoc();
			List<ColTest> colTests = SchoolDetail.getColTestsByCocWithHtml(Coc);
			Random rd = new Random(); // 创建随机对象
			if (ToolUtil.isNotEmpty(colTests)) {
				for (ColTest colTest : colTests) {
					ColTest test = new ColTest();
					test = colTest;
					test.insert(); // 保存到colTest表中
					String[] majors = colTest.getMajors();
					if (ToolUtil.isNotEmpty(majors)) {
						insertColMajorDetail(majors, test);
					}
					String[] subjects = colTest.getSubjects();
					if (ToolUtil.isNotEmpty(subjects)) {
						insertColSubjectRequiresd(subjects, test);
					}
					System.out.println("===========================【success】==========================");
					System.out.println(colTest.toString());
				}
			}
			int score = Math.abs(rd.nextInt()) % 5 + 1; // 随机分数
			try {
				Thread.currentThread().sleep(2000 + 1000 * score);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @Title: insertColMajorDetail @Description: 插入到专业表 @param majors @param
	 *         colTest void @author :作者：Administrator @date :创建时间：2018年1月9日
	 *         下午4:24:09 @throws
	 */
	private static void insertColMajorDetail(String[] majors, ColTest colTest) {
		String Coc = colTest.getCoc();
		String collegeName = colTest.getCollegeName();
		String collegeLevel = colTest.getCollegeLevel();
		String majorClass = colTest.getMajorClass();
		for (String string : majors) {
			ColMajorDetail cmd = new ColMajorDetail();
			cmd.setCoc(Coc);
			cmd.setCollegeName(collegeName);
			cmd.setCollegeLevel(collegeLevel);
			cmd.setMajorClass(majorClass);
			cmd.setMajor(string);
			cmd.insert();
		}
	}

	/**
	 * 
	 * @Title: insertColSubjectRequiresd @Description: 插入到科目表 @param subjects @param
	 *         colTest void @author :作者：Administrator @date :创建时间：2018年1月9日
	 *         下午4:24:29 @throws
	 */
	private static void insertColSubjectRequiresd(String[] subjects, ColTest colTest) {
		String Coc = colTest.getCoc();
		String collegeName = colTest.getCollegeName();
		String collegeLevel = colTest.getCollegeLevel();
		String majorClass = colTest.getMajorClass();
		for (String string : subjects) {
			ColSubjectRequiresd csr = new ColSubjectRequiresd();
			csr.setCoc(Coc);
			csr.setCollegeName(collegeName);
			csr.setCollegeLevel(collegeLevel);
			csr.setMajorClass(majorClass);
			csr.setSubject(string);
			csr.insert();
		}
	}

}
