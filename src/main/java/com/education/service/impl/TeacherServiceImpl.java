package com.education.service.impl;

import com.education.bean.Teacher;
import com.education.dao.TeacherDao;
import com.education.service.TeacherService;

import java.util.List;


public class TeacherServiceImpl implements TeacherService{
	private TeacherDao teacherDao = new TeacherDao();

	@Override
	public Teacher teacherLogin(Teacher teacher) {
		return teacherDao.teacherLogin(teacher);
	}

	@Override
	public List<Teacher> TeacherQuery() {
		return teacherDao.TeacherQuery();
	}

	@Override
	public boolean addTeacher(Teacher teacher) {
		return teacherDao.addTeacher(teacher);
	}

	@Override
	public boolean updateTeacher(Teacher college) {
		return teacherDao.updateTeacher(college);
	}

	@Override
	public boolean deleteTeacher(int id) {
		return teacherDao.deleteTeacher(id);
	}

	@Override
	public List<Teacher> queryTeacherName(String name) {
		return teacherDao.queryTeacherName(name);
	}

	@Override
	public boolean queryTeacherByName(String name) {
		return teacherDao.queryTeacherByName(name);
	}

	@Override
	public Teacher queryTeacherById(int id) {
		return teacherDao.queryTeacherById(id);
	}

}
