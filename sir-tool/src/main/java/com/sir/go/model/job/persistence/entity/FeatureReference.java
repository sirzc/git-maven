package com.sir.go.model.job.persistence.entity;

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
 * @since 2018-02-26
 */
@TableName("feature_reference")
public class FeatureReference extends Model<FeatureReference> {

	private static final long		serialVersionUID	= 1L;

	@TableId(value = "Fid", type = IdType.AUTO)
	private Integer					Fid;
	@TableField("Element_Name")
	private String					ElementName;
	@TableField("Element_Name_Chinese")
	private String					ElementNameChinese;
	@TableField("Element_ID")
	private String					ElementID;
	private String					Description;
	@TableField("Description_Chinese")
	private String					DescriptionChinese;
	@TableField(exist = false)
	private List<FeatureReference>	chirdFeature;

	public Integer getFid() {
		return Fid;
	}

	public void setFid(Integer Fid) {
		this.Fid = Fid;
	}

	public String getElementName() {
		return ElementName;
	}

	public void setElementName(String ElementName) {
		this.ElementName = ElementName;
	}

	public String getElementNameChinese() {
		return ElementNameChinese;
	}

	public void setElementNameChinese(String ElementNameChinese) {
		this.ElementNameChinese = ElementNameChinese;
	}

	public String getElementID() {
		return ElementID;
	}

	public void setElementID(String ElementID) {
		this.ElementID = ElementID;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	public String getDescriptionChinese() {
		return DescriptionChinese;
	}

	public void setDescriptionChinese(String DescriptionChinese) {
		this.DescriptionChinese = DescriptionChinese;
	}

	public List<FeatureReference> getChirdFeature() {
		return chirdFeature;
	}

	public void setChirdFeature(List<FeatureReference> chirdFeature) {
		this.chirdFeature = chirdFeature;
	}

	@Override
	protected Serializable pkVal() {
		return this.Fid;
	}

	@Override
	public String toString() {
		return "FeatureReference{" +
				", Fid=" + Fid +
				", ElementName=" + ElementName +
				", ElementNameChinese=" + ElementNameChinese +
				", ElementID=" + ElementID +
				", Description=" + Description +
				", DescriptionChinese=" + DescriptionChinese +
				"}";
	}
}
