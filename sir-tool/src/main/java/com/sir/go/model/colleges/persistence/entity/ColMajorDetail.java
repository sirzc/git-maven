package com.sir.go.model.colleges.persistence.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 各高校专业库
 * </p>
 *
 * @author careertree
 * @since 2018-01-17
 */
@TableName("col_major_detail")
public class ColMajorDetail extends Model<ColMajorDetail> {

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
     * 专业（类）名称
     */
	@TableField("major_class")
	private String majorClass;
    /**
     * 类中所包含的专业
     */
	private String major;
    /**
     * 专业、专业类编码
     */
	private String Moc;


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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ColMajorDetail{" +
			", id=" + id +
			", Coc=" + Coc +
			", collegeName=" + collegeName +
			", collegeLevel=" + collegeLevel +
			", majorClass=" + majorClass +
			", major=" + major +
			", Moc=" + Moc +
			"}";
	}
}
