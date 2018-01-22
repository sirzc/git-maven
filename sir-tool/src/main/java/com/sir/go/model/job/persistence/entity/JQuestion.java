package com.sir.go.model.job.persistence.entity;

import java.io.Serializable;

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
@TableName("j_question")
public class JQuestion extends Model<JQuestion> {

    private static final long serialVersionUID = 1L;

	private String id;
	@TableField("question_title")
	private String questionTitle;
	@TableField("factor_id")
	private String factorId;
	@TableField("belong_id")
	private String belongId;
	private Integer sort;
	@TableField("Element_ID")
	private String ElementID;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getBelongId() {
		return belongId;
	}

	public void setBelongId(String belongId) {
		this.belongId = belongId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getElementID() {
		return ElementID;
	}

	public void setElementID(String ElementID) {
		this.ElementID = ElementID;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "JQuestion{" +
			", id=" + id +
			", questionTitle=" + questionTitle +
			", factorId=" + factorId +
			", belongId=" + belongId +
			", sort=" + sort +
			", ElementID=" + ElementID +
			"}";
	}
}
