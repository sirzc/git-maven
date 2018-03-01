package com.sir.go.model.job.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author careertree
 * @since 2018-01-03
 */
@TableName("j_test")
public class JTest extends Model<JTest> {

    private static final long serialVersionUID = 1L;

	private String id;
	@TableField("test_name")
	private String testName;
	@TableField("test_num")
	private Integer testNum;
	private String description;
	@TableField("create_time")
	private Date createTime;
	@TableField("create_by")
	private String createBy;
	@TableField("answer_num")
	private Integer answerNum;
	@TableField("full_description")
	private String fullDescription;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Integer getTestNum() {
		return testNum;
	}

	public void setTestNum(Integer testNum) {
		this.testNum = testNum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Integer getAnswerNum() {
		return answerNum;
	}

	public void setAnswerNum(Integer answerNum) {
		this.answerNum = answerNum;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "JTest{" +
			", id=" + id +
			", testName=" + testName +
			", testNum=" + testNum +
			", description=" + description +
			", createTime=" + createTime +
			", createBy=" + createBy +
			", answerNum=" + answerNum +
			", fullDescription=" + fullDescription +
			"}";
	}
}
