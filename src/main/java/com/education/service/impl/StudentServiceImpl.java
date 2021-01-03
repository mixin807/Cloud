package com.education.service.impl;

import java.util.List;

import com.education.bean.Student;
import com.education.dao.StudentDao;
import com.education.service.StudentService;

public class StudentServiceImpl implements StudentService{

	private static StudentDao dao = new StudentDao();

	@Override
	public Student studentLogin(Student student) {
		return dao.studentLogin(student);
	}

	@Override
	public List<Student> CheckAllStudent() {
		return dao.CheckAllStudent();
	}

	@Override
	public boolean addStudent(Student student) {
		return dao.addStudent(student);
	}

	@Override
	public boolean updateStudent(Student student) {
		return dao.updateStudent(student);
	}

	@Override
	public boolean deleteStudent(int id) {
		return dao.deleteStudent(id);
	}

	@Override
	public boolean queryStudentByName(String name) {
		return dao.queryStudentByName(name);
	}

	@Override
	public Student checkStudentById(int id) {
		return dao.checkStudentById(id);
	}

	@Override
	public List<Student> checkStudentByName(String name) {
		return dao.checkStudentByName(name);
	}
}
