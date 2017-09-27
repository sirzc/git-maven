package com.go.smart.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/** 
 * @Title: Resource.java
 * @Package com.go.smart.entity
 * @Description: 资源类
 * @author 作者：b
 * @date 创建时间：2017年8月22日 下午9:32:19
 */
@Entity
@Table(name = "p_resource_roles")
public class Resource_Roles implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "in_resource_roles")
	@GenericGenerator(name = "in_resource_roles", strategy = "increment")
	@Column(name = "id", unique = true)
	private Integer id;
	
	@Column
	private Integer resource_id;
	@Column
	private Integer role_id;

	@ManyToOne(targetEntity = Resources.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "resource_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Resources resource;

	@ManyToOne(targetEntity = Roles.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Roles roles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getResource_id() {
		return resource_id;
	}

	public void setResource_id(Integer resource_id) {
		this.resource_id = resource_id;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Resources getResource() {
		return resource;
	}

	public void setResource(Resources resource) {
		this.resource = resource;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Resource_Roles [id=" + id + ", resource_id=" + resource_id + ", role_id=" + role_id + ", resource="
				+ resource + ", roles=" + roles + "]";
	}
	
	
}
