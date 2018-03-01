package com.sir.go.model.ac.persistence.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 
 * </p>
 *
 * @author careertree
 * @since 2018-01-17
 */
@TableName("ac_detail")
public class AcDetail extends Model<AcDetail> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 高校代码
     */
	private String Coc;
    /**
     * 高校名称
     */
	@TableField("college_name")
	private String collegeName;
    /**
     * 高校层次
     */
	@TableField("college_level")
	private String collegeLevel;
    /**
     * 原名称
     */
	@TableField("major_class")
	private String majorClass;
    /**
     * 专业\类 名称
     */
	private String major;
    /**
     * 专业代码
     */
	private String Moc;
    /**
     * 前一级moc
     */
	@TableField("parent_moc")
	private String parentMoc;
    /**
     * 该专业课程
     */
	private String subject;
    /**
     * 相关信息
     */
	private String top;
    /**
     * 类型 BA\AH
     */
	private String category;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCoc() {
		return Coc;
	}

	public void setCoc(String Coc) {
		this.Coc = Coc;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCollegeLevel() {
		return collegeLevel;
	}

	public void setCollegeLevel(String collegeLevel) {
		this.collegeLevel = collegeLevel;
	}

	public String getMajorClass() {
		return majorClass;
	}

	public void setMajorClass(String majorClass) {
		this.majorClass = majorClass;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMoc() {
		return Moc;
	}

	public void setMoc(String Moc) {
		this.Moc = Moc;
	}

	public String getParentMoc() {
		return parentMoc;
	}

	public void setParentMoc(String parentMoc) {
		this.parentMoc = parentMoc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "AcDetail{" +
			", id=" + id +
			", Coc=" + Coc +
			", collegeName=" + collegeName +
			", collegeLevel=" + collegeLevel +
			", majorClass=" + majorClass +
			", major=" + major +
			", Moc=" + Moc +
			", parentMoc=" + parentMoc +
			", subject=" + subject +
			", top=" + top +
			", category=" + category +
			"}";
	}
}
