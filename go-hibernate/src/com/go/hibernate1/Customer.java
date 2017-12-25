package com.go.hibernate1;

/**
 * @Title: Customer.java
 * @Package com.go.hibernate1
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月16日 下午6:18:36
 * @version V1.0
 */
public class Customer implements Comparable<Customer> {
	private Integer id;
	private String name;
	private Integer age;
	private String sex;
	private String city;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", city=" + city + "]";
	}

	@Override
	public int compareTo(Customer arg0) {
		int i = this.getId() - arg0.getId();
		return i;
	}
 
}
