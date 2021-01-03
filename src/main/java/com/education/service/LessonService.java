package com.education.service;

import java.sql.ClientInfoStatus;
import java.util.List;

import com.education.bean.Lesson;

public interface LessonService {
	//查询课程数据
	public List<Lesson> LessonQuery();
	//添加课程数据
	public boolean addLesson(Lesson lesson);
	//修改课程数据
	public boolean updateLesson(Lesson lesson);
	//删除课程数据
	public boolean deleteLesson(int id);
	//通过名字查询课程信息
	public List<Lesson> LessonQueryByName(String name);
	//通过id查询到课程
	public Lesson LessonQureyById(int id);
}
