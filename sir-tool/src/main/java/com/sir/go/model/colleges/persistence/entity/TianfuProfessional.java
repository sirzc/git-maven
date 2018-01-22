package com.sir.go.model.colleges.persistence.entity;

import java.io.Serializable;
import java.util.List;

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
@TableName("tianfu_professional")
public class TianfuProfessional extends Model<TianfuProfessional> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	@TableField("college_name")
	private String collegeName;
	@TableField("major_id")
	private Integer majorId;
	@TableField("del_flag")
	private String delFlag;
	@TableField("major_name")
	private String majorName;
	@TableField("major_code")
	private String majorCode;
	@TableField("major_level")
	private String majorLevel;
	@TableField("education_length")
	private String educationLength;
	@TableField("parent_code")
	private String parentCode;
	@TableField("college_id")
	private String collegeId;
	@TableField(exist = false)
	private List<TianfuProfessional> chirdMajor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public Integer getMajorId() {
		return majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getMajorCode() {
		return majorCode;
	}

	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}

	public String getMajorLevel() {
		return majorLevel;
	}

	public void setMajorLevel(String majorLevel) {
		this.majorLevel = majorLevel;
	}

	public String getEducationLength() {
		return educationLength;
	}

	public void setEducationLength(String educationLength) {
		this.educationLength = educationLength;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	
	public List<TianfuProfessional> getChirdMajor() {
		return chirdMajor;
	}

	public void setChirdMajor(List<TianfuProfessional> chirdMajor) {
		this.chirdMajor = chirdMajor;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	
	
	@Override
	public String toString() {
		return "TianfuProfessional [id=" + id + ", collegeName=" + collegeName + ", majorId=" + majorId + ", delFlag="
				+ delFlag + ", majorName=" + majorName + ", majorCode=" + majorCode + ", majorLevel=" + majorLevel
				+ ", educationLength=" + educationLength + ", parentCode=" + parentCode + ", collegeId=" + collegeId
				+ ", chirdMajor=" + chirdMajor + "]";
	}
}
