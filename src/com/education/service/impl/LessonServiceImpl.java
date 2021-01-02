package com.education.service.impl;

import java.util.List;

import com.education.bean.Lesson;
import com.education.dao.LessonDao;
import com.education.service.LessonService;

public class LessonServiceImpl implements LessonService{
	private LessonDao lessonDao = new LessonDao();
	
	@Override
	public List<Lesson> LessonQuery() {
		return lessonDao.LessonQuery();
	}

	@Override
	public boolean addLesson(Lesson lesson) {
		return lessonDao.addLesson(lesson);
	}

	@Override
	public boolean updateLesson(Lesson lesson) {
		return lessonDao.updateLesson(lesson);
	}

	@Override
	public boolean deleteLesson(int id) {
		return lessonDao.deleteLesson(id);
	}

	@Override
	public List<Lesson> LessonQueryByName(String name) {
		return lessonDao.LessonQueryByName(name);
	}

	@Override
	public Lesson LessonQureyById(int id) {
		return lessonDao.LessonQureyById(id);
	}
}
