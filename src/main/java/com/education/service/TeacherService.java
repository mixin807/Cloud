package com.education.service;

import java.util.List;

import com.education.bean.Teacher;

public interface TeacherService {

	//教师登录
	public Teacher teacherLogin(Teacher teacher);
	//查询展示所有教师数据
	public List<Teacher> TeacherQuery();
	//添加教师数据
	public boolean addTeacher(Teacher teacher);
	//修改教师数据
	public boolean updateTeacher(Teacher teacher);
	//删除教师数据
	public boolean deleteTeacher(int id);
	//通过名字查询教师数据
	public List<Teacher> queryTeacherName(String name);
	//通过名字查询是否有该教师
	public boolean queryTeacherByName(String name);
	//通过id查找到教师
	public Teacher queryTeacherById(int id);
}
