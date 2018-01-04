package com.sir.go.model.job.persistence.entity;

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
 * @since 2018-01-03
 */
@TableName("j_qu_factor")
public class JQuFactor extends Model<JQuFactor> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	@TableField("belong_qu_id")
	private String belongQuId;
	private Integer score;
	private String tip;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBelongQuId() {
		return belongQuId;
	}

	public void setBelongQuId(String belongQuId) {
		this.belongQuId = belongQuId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "JQuFactor{" +
			", id=" + id +
			", belongQuId=" + belongQuId +
			", score=" + score +
			", tip=" + tip +
			"}";
	}
}
