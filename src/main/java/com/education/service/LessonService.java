package com.education.service;

import java.sql.ClientInfoStatus;
import java.util.List;

import com.education.bean.Lesson;

public interface LessonService {
	public List<Lesson> LessonQuery();
	
	public boolean addLesson(Lesson lesson);
	
	public boolean updateLesson(Lesson lesson);
	
	public boolean deleteLesson(int id);
	
	public List<Lesson> LessonQueryByName(String name);
	
	public Lesson LessonQureyById(int id);
}
