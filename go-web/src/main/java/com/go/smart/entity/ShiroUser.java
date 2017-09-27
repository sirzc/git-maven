package com.go.smart.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * @Title: ShiroUser.java
 * @Package com.go.smart.entity
 * @Description: 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 * @author 作者：b
 * @date 创建时间：2017年8月26日 上午9:58:49
 */
public class ShiroUser implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private final String loginName;
	private String name;
	private Set<String> urlSet;
	private Set<String> roles;
	
    public ShiroUser(String loginName) {
        this.loginName = loginName;
    }

    public ShiroUser(int id, String loginName, String name, Set<String> urlSet) {
        this.id = id;
        this.loginName = loginName;
        this.name = name;
        this.urlSet = urlSet;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getUrlSet() {
		return urlSet;
	}

	public void setUrlSet(Set<String> urlSet) {
		this.urlSet = urlSet;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public String getLoginName() {
		return loginName;
	}
	
	 /**
     * 本函数输出将作为默认的<shiro:principal/>输出.
     */
    @Override
    public String toString() {
        return loginName;
    }
}
