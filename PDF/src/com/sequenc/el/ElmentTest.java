package com.sequenc.el;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

/**
 * @Title: ElmentTest.java
 * @Package com.sequenc.el
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：Administrator
 * @date 创建时间：2017年12月8日 下午4:13:43
 * @version V1.0
 */
public class ElmentTest {

	/**
	 * @Title: init
	 * @Description: 初始化数据
	 * @return List<Elment>
	 * @throws
	 * 			@author
	 *             作者：Administrator
	 * @date 创建时间：2017年12月8日 下午4:23:59
	 */
	public static List<Map<String, Object>> init() {
		Random rd = new Random(); // 创建随机对象  
		List<Map<String, Object>> list = new ArrayList<>();
		for (int i = 1; i <= 100; i++){ //50种数据
			int score = Math.abs(rd.nextInt()) % 5 + 1; //随机分数 
			int fa = Math.abs(rd.nextInt()) % 6 + 1; //随机因子类型  6种类型
			//			System.out.println(score+","+fa);
			Map<String, Object> map = new HashMap<>();
			map.put("Score", score);
			map.put("FactorId", "factorID" + fa);
			list.add(map);
		}
		return list;
	}

	/**
	 * 
	 * @Title: disPlay
	 * @Description: 计算出同因子，平均分，最高分
	 * @throws
	 * 			@author
	 *             作者：Administrator
	 * @date 创建时间：2017年12月8日 下午4:24:41
	 */
	@Test
	public void disPlay() {
		List<Map<String, Object>> list = init();
		//		for (Map<String, Object> map : list){
		//			System.out.println(map.toString());
		//		}
		List<Compare> compares = new ArrayList<>();
		List<String> fList = new ArrayList<>();
		Map<String, Compare> compareMap = new HashMap<>();
		for (Map<String, Object> map : list){
			String xFactorId = (String) map.get("FactorId"); ////记录 因子名称
			if (!compareMap.containsKey(xFactorId)){
				Integer max = (Integer) map.get("Score"); //记录当前记录册的最大值
				int number = 1;
				int sum = max;
				int maxNum = 1;
				Compare compare = new Compare();
				for (int i = 1; i < list.size(); i++){
					if (xFactorId.equals(list.get(i).get("FactorId"))){
						number++; //记录值加1
						Integer yScore = (Integer) list.get(i).get("Score"); //记录  因子分数
						if (yScore > max){
							max = yScore;
							maxNum = 1;
						} else if (yScore == max){
							maxNum++;
						}
						sum += yScore; //得到某一类的总分数
					}
				}
				compare.setFactorId(xFactorId);
				compare.setMax(max);
				compare.setAvg(sum * 1.0f / number);
				compare.setMaxNum(maxNum);
				fList.add(xFactorId);
				compares.add(compare);
				compareMap.put(xFactorId, compare);
			}
		}
		System.out.println(fList.toString());
		for (String string : fList){
			System.out.println(compareMap.get(string).toString());
		}
		System.out.println("===================================");
		Collections.sort(compares);
		for (Compare compare : compares){
			System.out.println(compare.toString());
		}
	}

	@Test
	public void name() {
		for (int i = 100; i < 1010; i++){
			Integer aInteger = i;
			Integer bInteger = i;
			if (aInteger == bInteger){
				System.out.println(true + "," + i);
			} else{
				System.out.println(false);
			}
		}
	}

	/**
	 * 
	 * @Title: disPlayPlus
	 * @Description: 计算出同因子，平均分，最高分
	 * @throws
	 * 			@author
	 *             作者：Administrator
	 * @date 创建时间：2017年12月8日 下午4:24:41
	 */
	@Test
	public void disPlayPlus() {
		List<Map<String, Object>> list = init();
		List<Compare> compares = new ArrayList<>();
		List<String> fList = new ArrayList<>();
		Map<String, Compare> compareMap = new HashMap<>();
		for (Map<String, Object> map : list){
			String xFactorId = (String) map.get("FactorId"); //记录 因子名称
			if (!compareMap.containsKey(xFactorId)){
				List<Integer> variance = new ArrayList<>();
				Integer max = (Integer) map.get("Score"); //记录当前记录册的最大值
				int number = 1;
				int sum = max;
				int maxNum = 1;
				Compare compare = new Compare();
				for (int i = 1; i < list.size(); i++){
					if (xFactorId.equals(list.get(i).get("FactorId"))){
						number++; //记录值加1
						Integer yScore = (Integer) list.get(i).get("Score"); //记录  因子分数
						if (yScore > max){
							max = yScore;
							maxNum = 1;
						} else if (yScore == max){
							maxNum++;
						}
						sum += yScore; //得到某一类的总分数
						variance.add(yScore);
					}
				}
				compare.setFactorId(xFactorId);
				compare.setMax(max);
				compare.setAvg(sum * 1.0f / number);
				compare.setMaxNum(maxNum);
				compare.setVariance(Variance(variance));
				fList.add(xFactorId);
				compares.add(compare);
				compareMap.put(xFactorId, compare);
			}
		}
		System.out.println(fList.toString());
		for (String string : fList){
			System.out.println(compareMap.get(string).toString());
		}
		System.out.println("===================================");
		Collections.sort(compares);
		for (Compare compare : compares){
			System.out.println(compare.toString());
		}
	}

	public static float Variance(List<Integer> list) {
		int m = list.size();
		float sum = 0;
		for (Integer integer : list){
			sum += integer;
		}
		float dAve = sum / m;//求平均值  
		float dVar = 0;
		for (int i = 0; i < m; i++){//求方差  
			dVar += (list.get(i) - dAve) * (list.get(i) - dAve);
		}
		return dVar / m;
	}

}
