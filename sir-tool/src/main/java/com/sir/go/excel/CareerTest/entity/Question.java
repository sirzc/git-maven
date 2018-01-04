package com.sir.go.excel.CareerTest.entity;

/**
 * @Title: Question.java
 * @Package org.go.test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：Administrator
 * @date 创建时间：2017年12月29日 上午10:35:24
 * @version V1.0
 */
public class Question {

	private String questionTitle; // 题目姓名
	private String factorId; // 因子类型
	private Integer sort; // 排序
	private Options options; // 选项

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getFactorId() {
		return factorId;
	}

	public void setFactorId(String factorId) {
		this.factorId = factorId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "Question [questionTitle=" + questionTitle + ", factorId=" + factorId + ", sort=" + sort + ", options="
				+ options + "]";
	}

}
