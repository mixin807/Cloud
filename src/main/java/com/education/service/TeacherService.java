package com.education.service;

import java.util.List;

import com.education.bean.Teacher;

public interface TeacherService {

	//��ʦ��¼
	public Teacher teacherLogin(Teacher teacher);
	//��ѯչʾ���н�ʦ����
	public List<Teacher> TeacherQuery();
	//��ӽ�ʦ����
	public boolean addTeacher(Teacher teacher);
	//�޸Ľ�ʦ����
	public boolean updateTeacher(Teacher teacher);
	//ɾ����ʦ����
	public boolean deleteTeacher(int id);
	//ͨ�����ֲ�ѯ��ʦ����
	public List<Teacher> queryTeacherName(String name);
	//ͨ�����ֲ�ѯ�Ƿ��иý�ʦ
	public boolean queryTeacherByName(String name);
	//ͨ��id���ҵ���ʦ
	public Teacher queryTeacherById(int id);
}
