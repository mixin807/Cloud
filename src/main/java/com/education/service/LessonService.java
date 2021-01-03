package com.education.service;

import java.sql.ClientInfoStatus;
import java.util.List;

import com.education.bean.Lesson;

public interface LessonService {
	//��ѯ�γ�����
	public List<Lesson> LessonQuery();
	//��ӿγ�����
	public boolean addLesson(Lesson lesson);
	//�޸Ŀγ�����
	public boolean updateLesson(Lesson lesson);
	//ɾ���γ�����
	public boolean deleteLesson(int id);
	//ͨ�����ֲ�ѯ�γ���Ϣ
	public List<Lesson> LessonQueryByName(String name);
	//ͨ��id��ѯ���γ�
	public Lesson LessonQureyById(int id);
}
