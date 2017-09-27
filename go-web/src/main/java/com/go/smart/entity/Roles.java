package com.go.smart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.go.tool.Pager;

/**
 * @Title: Roles.java
 * @Package com.go.smart.entity
 * @Description: 角色类
 * @author 作者：b
 * @date 创建时间：2017年8月22日 下午9:22:23
 */
@Entity
@Table(name = "p_roles")
public class Roles extends Pager<Roles> implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "in_roles")
	@GenericGenerator(name = "in_roles", strategy = "increment")
	@Column(name = "id", unique = true)
	private Integer id;
	@Column
	private String name; // 角色名称（英文）
	@Column
	private String description;// 简介（中文）

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
