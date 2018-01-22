package com.sir.go.tool.crawler.school;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.sir.go.common.utils.ToolUtil;
import com.sir.go.model.colleges.persistence.entity.ColRankings;

/**
 * @Title: SchoolMajor.java
 * @Package com.sir.go.tool.crawler.school
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：sirzc
 * @date 创建时间：2018年1月10日 下午6:03:47
 * @version V1.0
 */
public class SchoolRankings {
	private static final String url = "http://www.cdgdc.edu.cn/webrms/pages/Ranking/";

	/**
	 * 
	 * @Title: getAddress1
	 * @Description: 获取地址一
	 * @return List<String> 
	 * @author :作者：Administrator
	 * @date :创建时间：2018年1月10日 下午7:38:56
	 * @throws
	 */
	public static List<String> getAddress1() {
		List<String> list = new ArrayList<String>();
		String html1 = url + "xkpmGXZJ2016.jsp?xkdm=01,02,03,04,05,06"; // 人文社科类
		String html2 = url + "xkpmGXZJ2016.jsp?xkdm=07";// 理学
		String html3 = url + "xkpmGXZJ2016.jsp?xkdm=08";// 工学
		String html4 = url + "xkpmGXZJ2016.jsp?xkdm=09";// 农学
		String html5 = url + "xkpmGXZJ2016.jsp?xkdm=10";// 医学
		String html6 = url + "xkpmGXZJ2016.jsp?xkdm=12";// 管理学
		String html7 = url + "xkpmGXZJ2016.jsp?xkdm=13";// 艺术学
		list.add(html1);
		list.add(html2);
		list.add(html3);
		list.add(html4);
		list.add(html5);
		list.add(html6);
		list.add(html7);
		return list;
	}

	@Test
	public void name() {
		Connection connect = Jsoup.connect(url+ "xkpmGXZJ2016.jsp?yjxkdm=0101&xkdm=01,02,03,04,05,06");
		Document document;
		try {
			document = connect.get();
			if(document!=null) {
				Elements tables = document.getElementsByTag("table");
//				System.out.println(tables.size());
				Element table = tables.get(tables.size()-1);
//				System.out.println(tr.toString());
				Elements trs = table.getElementsByTag("tr");
				String str = null; //记录分数
				for (int i = 0; i < trs.size(); i++) {
					Element tr = trs.get(i);
					String row = tr.getElementsByTag("td").get(0).attr("rowspan");
					if(ToolUtil.isNotEmpty(row)) {
						str = tr.getElementsByTag("td").get(0).text();
					}
					String score = str;
					String name = tr.getElementsByTag("div").get(0).text();
					System.out.println(score+","+name);
				} 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * 
	 * @Title: getAddress2
	 * @Description: 获取列表二
	 * @param address
	 * @return Map<String,List<String>> 
	 * @author :作者：Administrator
	 * @date :创建时间：2018年1月10日 下午7:38:02
	 * @throws
	 */
	public static Map<String, List<String>> getAddress2(String address) {
		System.out.println(address);
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		Connection connect = Jsoup.connect(address);
		Document document;
		try {
			List<String> href = new ArrayList<String>();
			List<String> majors = new ArrayList<String>();
			document = connect.get();
		 
			if(document!=null) {
				Element two = document.getElementById("leftgundong");
				Elements aElements = two.getElementsByTag("a");
				for (Element a : aElements) {
					String address2 = a.attr("href");
					String context = a.html();
					href.add(address2);
					majors.add(context);
				}
			}
			map.put("address", href);
			map.put("context", majors);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return map;
	}
	
	/**
	 * 
	 * @Title: getRankings
	 * @Description: 获取详细值
	 * @param address
	 * @return List<ColRankings> 
	 * @author :作者：Administrator
	 * @date :创建时间：2018年1月10日 下午7:38:13
	 * @throws
	 */
	public static List<ColRankings> getRankings(String address) {
		Connection connect = Jsoup.connect(url+address);
		Document document;
		List<ColRankings> list = new ArrayList<ColRankings>();
		try {
			document = connect.get();
			if(document!=null) {
				Elements tables = document.getElementsByTag("table");
				Element table = tables.get(tables.size()-1);
				Elements trs = table.getElementsByTag("tr");
				String str = null; //记录分数
				for (int i = 0; i < trs.size(); i++) {
					ColRankings rankings = new ColRankings();
					Element tr = trs.get(i);
					String row = tr.getElementsByTag("td").get(0).attr("rowspan");
					if(ToolUtil.isNotEmpty(row)) {
						str = tr.getElementsByTag("td").get(0).text();
					}
					String score = str;
					String name = tr.getElementsByTag("div").get(0).text();
					rankings.setScore(score);
					rankings.setCollegeName(name);
					list.add(rankings);
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
	public void name1() {
		Connection connect = Jsoup.connect("http://www.cdgdc.edu.cn/webrms/pages/Ranking/xkpmGXZJ2016.jsp?xkdm=01,02,03,04,05,06");
		Document document;
		try {
 
			document = connect.get();
			if(document!=null) {
				Element two = document.getElementById("leftgundong");
				Elements aElements = two.getElementsByTag("a");
				for (Element a : aElements) {
					String address2 = a.attr("href");
					String context = a.html();
					System.out.println(address2+","+context);
				}
			}
 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
