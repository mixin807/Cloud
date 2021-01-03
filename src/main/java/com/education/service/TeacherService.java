package com.education.service;

import java.util.List;

import com.education.bean.Teacher;

public interface TeacherService {

	public Teacher teacherLogin(Teacher teacher);

	public List<Teacher> TeacherQuery();
	
	public boolean addTeacher(Teacher teacher);
	
	public boolean updateTeacher(Teacher teacher);
	
	public boolean deleteTeacher(int id);
	
	public List<Teacher> queryTeacherName(String name);

	public boolean queryTeacherByName(String name);

	public Teacher queryTeacherById(int id);
}
