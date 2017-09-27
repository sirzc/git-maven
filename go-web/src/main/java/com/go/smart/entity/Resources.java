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
 * @Title: Resource.java
 * @Package com.go.smart.entity
 * @Description: 资源类
 * @author 作者：b
 * @date 创建时间：2017年8月22日 下午9:32:19
 */
@Entity
@Table(name = "p_resource")
public class Resources extends Pager<Resources> implements Serializable ,Comparable<Resources> {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "in_resource")
	@GenericGenerator(name = "in_resource", strategy = "increment")
	@Column(name = "id", unique = true)
	private Integer id;
	@Column
	private Integer pId;//所属父类
	@Column
	private String name;//资源名称
	@Column
	private String opurl;//资源路径
	@Column
	private boolean open;//打开状态
	@Column
	private String description;//资源描述
	@Column
	private boolean resourceType;//资源类型（菜单、按钮）
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getOpurl() {
		return opurl;
	}
	public void setOpurl(String opurl) {
		this.opurl = opurl;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isResourceType() {
		return resourceType;
	}
	public void setResourceType(boolean resourceType) {
		this.resourceType = resourceType;
	}
	
	@Override
	public String toString() {
		return "Resource [id=" + id + ", pId=" + pId + ", name=" + name + ", opurl=" + opurl + ", open=" + open
				+ ", description=" + description + ", resourceType=" + resourceType + "]";
	}
	
	@Override
	public int compareTo(Resources o) {
		 int i = this.getId() - o.getId();
		 return i;
	}
}
