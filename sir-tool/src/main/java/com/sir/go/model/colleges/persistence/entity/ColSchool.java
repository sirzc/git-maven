package com.sir.go.model.colleges.persistence.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 全国高校库（教育部2017年6月更新）
 * </p>
 *
 * @author careertree
 * @since 2018-01-17
 */
@TableName("col_school")
public class ColSchool extends Model<ColSchool> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增编号
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 高校名称
     */
	@TableField("college_name")
	private String collegeName;
    /**
     * 英文名称
     */
	@TableField("en_name")
	private String enName;
    /**
     * 学校标志码
     */
	private String Cocs;
    /**
     * 学校标志码简化版
     */
	private String Coc;
    /**
     * 主管部门
     */
	private String affiliated;
    /**
     * 所在地
     */
	private String location;
    /**
     * 办学层次（本科、专科）
     */
	@TableField("edu_level")
	private String eduLevel;
    /**
     * 所属地
     */
	private String area;
    /**
     * 招生办网址
     */
	@TableField("college_site")
	private String collegeSite;
    /**
     * 网址
     */
	private String website;
    /**
     * 学校术语（211、985、重点等）
     */
	@TableField("college_term")
	private String collegeTerm;
    /**
     * 办学类型（民办等）
     */
	private String type;
    /**
     * 院校类型
     */
	@TableField("col_type")
	private String colType;
    /**
     * 学校地址（详细）
     */
	@TableField("college_address")
	private String collegeAddress;
    /**
     * 学校介绍
     */
	private String description;
    /**
     * 是否启用
     */
	private Integer enable;


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

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getCocs() {
		return Cocs;
	}

	public void setCocs(String Cocs) {
		this.Cocs = Cocs;
	}

	public String getCoc() {
		return Coc;
	}

	public void setCoc(String Coc) {
		this.Coc = Coc;
	}

	public String getAffiliated() {
		return affiliated;
	}

	public void setAffiliated(String affiliated) {
		this.affiliated = affiliated;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEduLevel() {
		return eduLevel;
	}

	public void setEduLevel(String eduLevel) {
		this.eduLevel = eduLevel;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCollegeSite() {
		return collegeSite;
	}

	public void setCollegeSite(String collegeSite) {
		this.collegeSite = collegeSite;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getCollegeTerm() {
		return collegeTerm;
	}

	public void setCollegeTerm(String collegeTerm) {
		this.collegeTerm = collegeTerm;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColType() {
		return colType;
	}

	public void setColType(String colType) {
		this.colType = colType;
	}

	public String getCollegeAddress() {
		return collegeAddress;
	}

	public void setCollegeAddress(String collegeAddress) {
		this.collegeAddress = collegeAddress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ColSchool{" +
			", id=" + id +
			", collegeName=" + collegeName +
			", enName=" + enName +
			", Cocs=" + Cocs +
			", Coc=" + Coc +
			", affiliated=" + affiliated +
			", location=" + location +
			", eduLevel=" + eduLevel +
			", area=" + area +
			", collegeSite=" + collegeSite +
			", website=" + website +
			", collegeTerm=" + collegeTerm +
			", type=" + type +
			", colType=" + colType +
			", collegeAddress=" + collegeAddress +
			", description=" + description +
			", enable=" + enable +
			"}";
	}
}
