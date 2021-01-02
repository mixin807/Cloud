package com.education.service;

import java.util.List;

import com.education.bean.Student;

public interface StudentService {

	public Student studentLogin(Student student);

	public List<Student> CheckAllStudent();
	
	public boolean addStudent(Student student);
	
	public boolean updateStudent(Student student);
	
	public boolean deleteStudent(int id);

	public boolean queryStudentByName(String name);
	
	public Student checkStudentById(int id);
	
	public List<Student> checkStudentByName(String name);
}
