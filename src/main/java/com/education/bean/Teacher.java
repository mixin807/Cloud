package com.education.bean;

//教师实体类
public class Teacher {
    private int t_id;
    private String t_name;
    private String t_sex;
    private String l_name;
    private String t_phone;
    private String t_password;

    public String getT_password() {
        return t_password;
    }

    public void setT_password(String t_password) {
        this.t_password = t_password;
    }

    public String getT_sex() {
        return t_sex;
    }

    public void setT_sex(String t_sex) {
        this.t_sex = t_sex;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public void setT_phone(String t_phone) {
        this.t_phone = t_phone;
    }

    public String getT_phone() {
        return t_phone;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

	@Override
	public String toString() {
		return "Teacher{" +
				"t_id=" + t_id +
				", t_name='" + t_name + '\'' +
				", t_sex='" + t_sex + '\'' +
				", l_name='" + l_name + '\'' +
				", t_phone='" + t_phone + '\'' +
				", t_password='" + t_password + '\'' +
				'}';
	}

	public Teacher(int t_id, String t_name, String t_sex, String l_name, String t_phone,String t_password) {
        this.t_id = t_id;
        this.t_name = t_name;
        this.t_sex = t_sex;
        this.l_name = l_name;
        this.t_phone = t_phone;
        this.t_password=t_password;
    }

    public Teacher() {
        super();
    }
}
