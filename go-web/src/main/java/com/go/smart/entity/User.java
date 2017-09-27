package com.go.smart.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.go.tool.Pager;

/**
 * @Title: User.java
 * @Package com.go.smart.entity
 * @Description:用户类
 * @author 作者：b
 * @date 创建时间：2017年8月22日 下午8:51:24
 */
@Entity
@Table(name = "p_user")
public class User extends Pager<User> implements Serializable,Comparable<User>{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "in_user")
	@GenericGenerator(name = "in_user", strategy = "increment")
	@Column(name = "id", unique = true)
	private Integer id; // 用户id
	@Column
	private String username; // 用户名
	@Column
	private String name; // 名称
	@Column
	private String password; // 用户密码
	@Column
	private String salt;// 盐
	@Column
	private Integer empId;// 所属机构
	@Transient
	private Set<Roles> roles;

	@Transient
	private String rolesString; //角色列表,将roles中的权限拼接到一起
	
	@Transient
	private String rolesName; //角色类型
	
	public String getRolesString() {
		return rolesString;
	}

	public void setRolesString(Set<Roles> roles) {
		String rString = "";
		int i=0;
		for (Roles r : roles) {
			rString += r.getName();
			if(i<roles.size()-1) {
				rString +=",";
			}
			i++;
		}
		this.rolesString = rString;
	}

	public String getRolesName() {
		return rolesName;
	}

	public void setRolesName(Set<Roles> roles) {
		this.rolesName = (roles.size()==1?"用户":"超级管理员");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.setRolesString(roles);
		this.setRolesName(roles);
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", password=" + password + ", salt="
				+ salt + ", empId=" + empId + ", roles=" + roles + ", rolesString=" + rolesString + ", rolesName="
				+ rolesName + "]";
	}

	@Override
	public int compareTo(User o) {
		 int i = this.getId() - o.getId();
		 return i;
	}

}
