package com.education.bean;
//javaʵ���ࣺ�������ݿ������������
public class Manager {
	//˽�л�������
	private int e_id;
	private String e_name;
	private String e_password;
	//���л���get��set����
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
	//���������вι��졢�޲ι�����
	public Manager(int e_id, String e_name, String e_password) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
		this.e_password = e_password;
	}

	public Manager() {
		super();
	}

	//toString��������Ҫ�����ڹ۲��ʵ�����������
	@Override
	public String toString() {
		return "Manager [e_id=" + e_id + ", e_name=" + e_name + ", e_password=" + e_password + "]";
	}

}
