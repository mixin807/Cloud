package com.education.service;

import java.util.List;

import com.education.bean.Student;

public interface StudentService {

	//学生登录
	public Student studentLogin(Student student);

	//查询展示所有学生
	public List<Student> CheckAllStudent();

	//添加学生数据
	public boolean addStudent(Student student);

	//修改学生数据
	public boolean updateStudent(Student student);

	//删除学生数据
	public boolean deleteStudent(int id);

	//通过名字查找是否有该学生
	public boolean queryStudentByName(String name);

	//通过id查询学生
	public Student checkStudentById(int id);

	//通过名字查询学生数据
	public List<Student> checkStudentByName(String name);
}
