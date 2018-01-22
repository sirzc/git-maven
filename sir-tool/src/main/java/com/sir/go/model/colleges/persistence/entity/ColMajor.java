package com.sir.go.model.colleges.persistence.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 全国高校专业表（教育部2012年更新）
 * </p>
 *
 * @author careertree
 * @since 2018-01-17
 */
@TableName("col_major")
public class ColMajor extends Model<ColMajor> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增编号
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 专业、专业类编号
     */
	private String Moc;
    /**
     * 专业、专业类名称
     */
	private String major;
    /**
     * 备注
     */
	private String remark;
    /**
     * 基本专业（basic）、特设专业（AD hoc）
     */
	private String category;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMoc() {
		return Moc;
	}

	public void setMoc(String Moc) {
		this.Moc = Moc;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
		return "ColMajor{" +
			", id=" + id +
			", Moc=" + Moc +
			", major=" + major +
			", remark=" + remark +
			", category=" + category +
			"}";
	}
}
