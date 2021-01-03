package com.education.service;

import java.util.List;

import com.education.bean.Student;

public interface StudentService {

	//ѧ����¼
	public Student studentLogin(Student student);

	//��ѯչʾ����ѧ��
	public List<Student> CheckAllStudent();

	//���ѧ������
	public boolean addStudent(Student student);

	//�޸�ѧ������
	public boolean updateStudent(Student student);

	//ɾ��ѧ������
	public boolean deleteStudent(int id);

	//ͨ�����ֲ����Ƿ��и�ѧ��
	public boolean queryStudentByName(String name);

	//ͨ��id��ѯѧ��
	public Student checkStudentById(int id);

	//ͨ�����ֲ�ѯѧ������
	public List<Student> checkStudentByName(String name);
}
