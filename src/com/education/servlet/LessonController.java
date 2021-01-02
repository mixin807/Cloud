package com.education.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.support.jconsole.DruidSqlDetailFrame;
import com.education.bean.Lesson;
import com.education.service.LessonService;
import com.education.service.impl.LessonServiceImpl;

@WebServlet(urlPatterns = {"/LessonQuery" , "/stuLessonQuery","/teaLessonQuery","/LessonInsert" , "/teaLessonInsert",
		"/LessonUpdate", "/LessonToUpdate" , "/teaLessonUpdate", "/teaLessonToUpdate" ,"/LessonDelete" ,
		"/teaLessonDelete","/LessonQueryName","/stuLessonQueryName","/teaLessonQueryName"})
public class LessonController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private LessonService lessonService = new LessonServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.equals("/educationsystem/LessonQuery")) {
			LessonQuery(request , response);
		}else if(uri.equals("/educationsystem/stuLessonQuery")) {
			stuLessonQuery(request , response);
		}else if(uri.equals("/educationsystem/teaLessonQuery")) {
			teaLessonQuery(request , response);
		}else if(uri.equals("/educationsystem/LessonInsert")) {
			LessonInsert(request , response);
		}else if(uri.equals("/educationsystem/teaLessonInsert")) {
			teaLessonInsert(request , response);
		}else if(uri.equals("/educationsystem/LessonUpdate")) {
			LessonUpdate(request , response);
		}else if(uri.equals("/educationsystem/LessonToUpdate")) {
			LessonToUpdate(request , response);
		}else if(uri.equals("/educationsystem/teaLessonUpdate")) {
			teaLessonUpdate(request , response);
		}else if(uri.equals("/educationsystem/teaLessonToUpdate")) {
			teaLessonToUpdate(request , response);
		}else if(uri.equals("/educationsystem/LessonDelete")) {
			LessonDelete(request , response);
		}else if(uri.equals("/educationsystem/teaLessonDelete")) {
			teaLessonDelete(request , response);
		}else if(uri.equals("/educationsystem/LessonQueryName")) {
			LessonQueryName(request , response);
		}else if(uri.equals("/educationsystem/stuLessonQueryName")) {
			stuLessonQueryName(request , response);
		}else if(uri.equals("/educationsystem/teaLessonQueryName")) {
			teaLessonQueryName(request , response);
		}
	}

	private void LessonQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Lesson> list = lessonService.LessonQuery();
		request.getSession().setAttribute("LessonList", list);
		request.getRequestDispatcher("/LessonTables.jsp").forward(request, response);
	}

	private void stuLessonQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Lesson> list = lessonService.LessonQuery();
		request.getSession().setAttribute("LessonList", list);
		request.getRequestDispatcher("/stuLessonTables.jsp").forward(request, response);
	}

	private void teaLessonQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Lesson> list = lessonService.LessonQuery();
		request.getSession().setAttribute("LessonList", list);
		request.getRequestDispatcher("/tLessonTables.jsp").forward(request, response);
	}

	private void LessonInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String l_name = request.getParameter("l_name");
		String l_time = request.getParameter("l_time");
		String t_name= request.getParameter("t_name");
		String l_describe = request.getParameter("l_describe");
		Lesson lesson = new Lesson();
		lesson.setL_name(l_name);
		lesson.setL_time(l_time);
		lesson.setT_name(t_name);
		lesson.setL_describe(l_describe);
		boolean isOk = lessonService.addLesson(lesson);
		if(isOk) {
			request.getRequestDispatcher("/LessonQuery").forward(request, response);
		}else {
			request.getRequestDispatcher("/addLesson.jsp").forward(request, response);
		}
	}

	private void teaLessonInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String l_name = request.getParameter("l_name");
		String l_time = request.getParameter("l_time");
		String t_name= request.getParameter("t_name");
		String l_describe = request.getParameter("l_describe");
		Lesson lesson = new Lesson();
		lesson.setL_name(l_name);
		lesson.setL_time(l_time);
		lesson.setT_name(t_name);
		lesson.setL_describe(l_describe);
		boolean isOk = lessonService.addLesson(lesson);
		if(isOk) {
			request.getRequestDispatcher("/LessonQuery").forward(request, response);
		}else {
			request.getRequestDispatcher("/taddLesson.jsp").forward(request, response);
		}
	}

	private void LessonUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1 = request.getParameter("l_id");
		int l_id = Integer.parseInt(id1);
		String l_name = request.getParameter("l_name");
		String l_time = request.getParameter("l_time");
		String t_name=request.getParameter("t_name");
		String l_describe = request.getParameter("l_describe");
		Lesson lesson = new Lesson(l_id , l_name , l_time , t_name, l_describe );
		boolean isOk = lessonService.updateLesson(lesson);
		if(isOk) {
			request.getRequestDispatcher("/LessonQuery").forward(request, response);
		}else {
			request.getRequestDispatcher("/LessonToUpdate?l_id = ?" + l_id).forward(request, response);
		}
	}

	private void LessonToUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("l_id");
		int l_id = Integer.parseInt(id);
		Lesson lesson = lessonService.LessonQureyById(l_id);
		request.setAttribute("UpdateLesson", lesson);
		request.getRequestDispatcher("/updateLesson.jsp").forward(request, response);
	}

	private void teaLessonUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1 = request.getParameter("l_id");
		int l_id = Integer.parseInt(id1);
		String l_name = request.getParameter("l_name");
		String l_time = request.getParameter("l_time");
		String t_name=request.getParameter("t_name");
		String l_describe = request.getParameter("l_describe");
		Lesson lesson = new Lesson(l_id , l_name , l_time , t_name, l_describe );
		boolean isOk = lessonService.updateLesson(lesson);
		if(isOk) {
			request.getRequestDispatcher("/teaLessonQuery").forward(request, response);
		}else {
			request.getRequestDispatcher("/teaLessonToUpdate?l_id = ?" + l_id).forward(request, response);
		}
	}

	private void teaLessonToUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("l_id");
		int l_id = Integer.parseInt(id);
		Lesson lesson = lessonService.LessonQureyById(l_id);
		request.setAttribute("UpdateLesson", lesson);
		request.getRequestDispatcher("/tupdateLesson.jsp").forward(request, response);
	}

	private void LessonDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("l_id");
		int l_id = Integer.parseInt(id);
		lessonService.deleteLesson(l_id);
		request.getRequestDispatcher("LessonQuery").forward(request, response);
	}

	private void teaLessonDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("l_id");
		int l_id = Integer.parseInt(id);
		lessonService.deleteLesson(l_id);
		request.getRequestDispatcher("teaLessonQuery").forward(request, response);
	}

	private void LessonQueryName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Lesson> list = new ArrayList<>();
		String l_name = request.getParameter("l_name");
		list = lessonService.LessonQueryByName(l_name);
		request.setAttribute("LessonQueryName", l_name);
		request.getSession().setAttribute("LessonList", list);
		request.getRequestDispatcher("/LessonTables.jsp").forward(request, response);
	}

	private void stuLessonQueryName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Lesson> list = new ArrayList<>();
		String l_name = request.getParameter("l_name");
		list = lessonService.LessonQueryByName(l_name);
		request.setAttribute("stuLessonQueryName", l_name);
		request.getSession().setAttribute("LessonList", list);
		request.getRequestDispatcher("/stuLessonTables.jsp").forward(request, response);
	}

	private void teaLessonQueryName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Lesson> list = new ArrayList<>();
		String l_name = request.getParameter("l_name");
		list = lessonService.LessonQueryByName(l_name);
		request.setAttribute("teaLessonQueryName", l_name);
		request.getSession().setAttribute("LessonList", list);
		request.getRequestDispatcher("/tLessonTables.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request , response);
	}
}
