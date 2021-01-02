package com.education.bean;
//java实体类：根据数据库的设计来定义的
public class Manager {
	//私有化的属性
	private int e_id;
	private String e_name;
	private String e_password;
	//公有化的get、set方法
	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public String getE_password() {
		return e_password;
	}

	public void setE_password(String e_password) {
		this.e_password = e_password;
	}
	//构造器：有参构造、无参构造器
	public Manager(int e_id, String e_name, String e_password) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
		this.e_password = e_password;
	}

	public Manager() {
		super();
	}

	//toString方法：主要是用于观察该实例对象的数据
	@Override
	public String toString() {
		return "Manager [e_id=" + e_id + ", e_name=" + e_name + ", e_password=" + e_password + "]";
	}

}
