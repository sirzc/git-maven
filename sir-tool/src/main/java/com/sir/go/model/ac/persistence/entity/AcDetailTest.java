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
@TableName("ac_detail_test")
public class AcDetailTest extends Model<AcDetailTest> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String Coc;
	@TableField("college_name")
	private String collegeName;
	@TableField("college_level")
	private String collegeLevel;
	@TableField("major_class")
	private String majorClass;
	private String major;
	private String Moc;
	private String subject;
	private String top;
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
		return "AcDetailTest{" +
			", id=" + id +
			", Coc=" + Coc +
			", collegeName=" + collegeName +
			", collegeLevel=" + collegeLevel +
			", majorClass=" + majorClass +
			", major=" + major +
			", Moc=" + Moc +
			", subject=" + subject +
			", top=" + top +
			", category=" + category +
			"}";
	}
}
