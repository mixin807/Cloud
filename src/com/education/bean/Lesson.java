package com.education.bean;

public class Lesson {
	private int l_id;
	private String l_name;
	private String l_time;
	private String t_name;
	private String l_describe;

	public int getL_id() {
		return l_id;
	}

	public void setL_id(int l_id) {
		this.l_id = l_id;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getL_time() {
		return l_time;
	}

	public void setL_time(String l_time) {
		this.l_time = l_time;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getL_describe() {
		return l_describe;
	}

	public void setL_describe(String l_describe) {
		this.l_describe = l_describe;
	}

	public Lesson(int l_id, String l_name, String l_time, String t_name, String l_describe) {
		this.l_id = l_id;
		this.l_name = l_name;
		this.l_time = l_time;
		this.t_name = t_name;
		this.l_describe = l_describe;
	}

	public Lesson() {
		super();
	}


}
