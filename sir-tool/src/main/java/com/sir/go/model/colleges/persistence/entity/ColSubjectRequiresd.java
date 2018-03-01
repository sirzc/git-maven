package com.sir.go.model.colleges.persistence.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 各高校 高考学科库
 * </p>
 *
 * @author careertree
 * @since 2018-01-17
 */
@TableName("col_subject_requiresd")
public class ColSubjectRequiresd extends Model<ColSubjectRequiresd> {

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
     * 科目
     */
	private String subject;


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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ColSubjectRequiresd{" +
			", id=" + id +
			", Coc=" + Coc +
			", collegeName=" + collegeName +
			", collegeLevel=" + collegeLevel +
			", majorClass=" + majorClass +
			", subject=" + subject +
			"}";
	}
}
