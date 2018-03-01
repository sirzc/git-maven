package com.sir.go.model.colleges.persistence.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 高校专业评分表
 * </p>
 *
 * @author careertree
 * @since 2018-01-17
 */
@TableName("col_rankings")
public class ColRankings extends Model<ColRankings> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增系列
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 专业类别
     */
	private String category;
    /**
     * 专业代码
     */
	private String Moc;
    /**
     * 专业名称
     */
	private String major;
    /**
     * 评分(A+,A,B+,B...)
     */
	private String score;
    /**
     * 高校代码
     */
	private String Coc;
    /**
     * 高校名称
     */
	@TableField("college_name")
	private String collegeName;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMoc() {
		return Moc;
	}

	public void setMoc(String moc) {
		Moc = moc;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ColRankings{" +
			", id=" + id +
			", category=" + category +
			", Moc=" + Moc +
			", major=" + major +
			", score=" + score +
			", Coc=" + Coc +
			", collegeName=" + collegeName +
			"}";
	}
}
