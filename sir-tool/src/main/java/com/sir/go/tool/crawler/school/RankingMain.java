package com.sir.go.tool.crawler.school;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sir.go.model.colleges.persistence.entity.ColRankings;

/**
 * @Title: RankingMain.java
 * @Package com.sir.go.tool.crawler.school
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：sirzc
 * @date 创建时间：2018年1月10日 下午7:39:37
 * @version V1.0
 */
public class RankingMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context);
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "人文社科类");
		map.put(1, "理学");
		map.put(2, "工学");
		map.put(3, "农学");
		map.put(4, "医学");
		map.put(5, "管理学");
		map.put(6, "艺术学");
		List<String> address1 = SchoolRankings.getAddress1();
		for (int i = 0; i < address1.size(); i++) {
			String category = map.get(i);
			Map<String, List<String>> map2 = SchoolRankings.getAddress2(address1.get(i));
			List<String> href = map2.get("address");
			List<String> majors = map2.get("context");
			for (int j = 0; j < majors.size(); j++) {
				String majorName = majors.get(j);
				List<ColRankings> list = SchoolRankings.getRankings(href.get(j));
				for (int k = 0; k < list.size(); k++) {
					ColRankings colRankings = new ColRankings();
					colRankings = list.get(k);
					colRankings.setCategory(category);
					colRankings.setMajor(majorName);
					colRankings.insert();
					System.out.println("===========================【success】==========================");
					System.out.println(colRankings.toString());
				}
			}
		}

	}
}
