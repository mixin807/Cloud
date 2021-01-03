package com.education.bean;

import java.util.Date;

public class Student {
    private int s_id;
    private String s_name;
    private String s_sex;
    private String s_bright;
    private String s_email;
    private String s_phone;
    private String s_password;

    public String getS_password() {
        return s_password;
    }

    public void setS_password(String s_password) {
        this.s_password = s_password;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public String getS_bright() {
        return s_bright;
    }

    public void setS_bright(String s_bright) {
        this.s_bright = s_bright;
    }

    public String getS_email() {
        return s_email;
    }

    public void setS_email(String s_email) {
        this.s_email = s_email;
    }

    public String getS_phone() {
        return s_phone;
    }

    public void setS_phone(String s_phone) {
        this.s_phone = s_phone;
    }

    public Student(int s_id, String s_name, String s_sex, String s_bright, String s_email, String s_phone,String s_password) {
        super();
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_sex = s_sex;
        this.s_bright = s_bright;
        this.s_email = s_email;
        this.s_phone = s_phone;
        this.s_password=s_password;
    }

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student [s_id=" + s_id + ", s_name=" + s_name + ", s_sex=" + s_sex + ", s_bright=" + s_bright
                + ", s_email=" + s_email + ", s_phone=" + s_phone + ",s_password=" + s_password + "]";
    }

}
