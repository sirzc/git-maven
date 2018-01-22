package com.sir.go.tool.crawler.school;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.sir.go.common.utils.ToolUtil;
import com.sir.go.model.colleges.persistence.entity.ColTest;

/**
 * @Title: SchoolDetail.java
 * @Package com.sir.go.tool.crawler.school
 * @Description: 获取高校信息
 * @author 作者：sirzc
 * @date 创建时间：2018年1月9日 下午1:55:44
 * @version V1.0
 */
public class SchoolDetail {
	private static final String url = "http://zt.zjzs.net/xuanke/";

	/**
	 * 
	 * @Title: getColTestsByCocWithHtml
	 * @Description: 从网页上获取高校信息
	 * @param Coc
	 *            高校代码
	 * @return List<ColTest>
	 * @author :作者：Administrator
	 * @date:创建时间：2018年1月9日 下午3:45:40 @throws
	 */
	public static List<ColTest> getColTestsByCocWithHtml(String Coc) {

		String html = url + Coc + ".html";
		Connection connect = Jsoup.connect(html);
		Document document;
		List<ColTest> list = new ArrayList<ColTest>();
		try {
			document = connect.get();
			if (document != null) {
				Elements subTitle = document.getElementsByClass("subTitle");
				Elements school = subTitle.get(0).getElementsByTag("div");
				String name = null;
				String coc = null;
				if (ToolUtil.isNotEmpty(school)) {
					name = school.get(1).text().substring(5);
					coc = school.get(2).text().substring(5);
				}
				Elements tr = document.getElementsByTag("tr");
				for (int i = 1; i < tr.size(); i++) {
					Elements td = tr.get(i).getElementsByTag("td");
					if (td.size() == 5) {
						ColTest colTest = new ColTest();
						colTest.setCollegeName(name);
						colTest.setCoc(coc);
						String collegeLevel = td.get(0).text();
						String majorClass = td.get(1).text();
						String num = td.get(2).text();
						String subjects = td.get(3).text();
						String majors = td.get(4).text();
						colTest.setCollegeLevel(collegeLevel);
						colTest.setMajorClass(majorClass);
						colTest.setNum(Integer.parseInt(num));
						colTest.setMajor(majors);
						colTest.setSubject(subjects);
						list.add(colTest);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Test
	public void name() {
		String html = url + "10246" + ".html";
		Connection connect = Jsoup.connect(html);
		Document document;
		try {
			document = connect.get();
			Elements subTitle = document.getElementsByClass("subTitle");
			Elements school = subTitle.get(0).getElementsByTag("div");
			if (ToolUtil.isNotEmpty(school)) {
				String name = school.get(1).text().substring(5);
				String Coc = school.get(2).text().substring(5);
				System.out.println(name + "," + Coc);
			}

			Elements tr = document.getElementsByTag("tr");

			for (int i = 1; i < tr.size(); i++) {
				Elements td = tr.get(i).getElementsByTag("td");
				if (td.size() == 5) {
					String collegeLevel = td.get(0).text();
					System.out.println(collegeLevel);
					String majorClass = td.get(1).text();
					System.out.println(majorClass);
					String num = td.get(2).text();
					System.out.println(num);
					String[] majors = td.get(3).text().split(" ");
					for (String major : majors) {
						System.out.println(major);
					}
					String[] subjects = td.get(4).text().split(" ");
					for (String subject : subjects) {
						System.out.println(subject);
					}
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
