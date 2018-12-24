package com.tdh.urlInterceptor.model;

import java.io.Serializable;

public class Student implements Serializable {

	/**
	 * @Fields serialVersionUID : (版本号)
	 */
	private static final long serialVersionUID = -2129908418898802442L;


	private Long uid;

	private String name;

	private Integer age;

	private Integer classid;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getClassid() {
		return classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}
}
