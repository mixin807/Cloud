package com.education.servlet;

import com.education.bean.*;
import com.education.dao.ManagerDao;
import com.education.dao.StudentDao;
import com.education.dao.TeacherDao;
import com.education.service.TeacherService;
import com.education.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/TeacherQuery", "/teaTeacherQuery", "/stuTeacherQuery", "/AddTeacher",
        "/TeacherRegister", "/TeacherLogin", "/TeacherDelete", "/TeacherUpdate", "/TeacherToUpdate",
        "/TeacherQueryName", "/stuTeacherQueryName", "/teaTeacherQueryName", "/TeacherLogOut",
        "/TeacherRegisterServlet","/TeacherLoginServlet"})
public class TeacherController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private TeacherService teacherService = new TeacherServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/educationsystem/TeacherQuery")) {
            TeacherQuery(request, response);
        } else if (uri.equals("/educationsystem/teaTeacherQuery")) {
            teaTeacherQuery(request, response);
        } else if (uri.equals("/educationsystem/stuTeacherQuery")) {
            stuTeacherQuery(request, response);
        } else if (uri.equals("/educationsystem/AddTeacher")) {
            AddTeacher(request, response);
        } else if (uri.equals("/educationsystem/TeacherRegister")) {
            TeacherRegister(request, response);
        } else if (uri.equals("/educationsystem/TeacherLogin")) {
            TeacherLogin(request, response);
        } else if (uri.equals("/educationsystem/TeacherDelete")) {
            TeacherDelete(request, response);
        } else if (uri.equals("/educationsystem/TeacherUpdate")) {
            TeacherUpdate(request, response);
        } else if (uri.equals("/educationsystem/TeacherToUpdate")) {
            TeacherToUpdate(request, response);
        } else if (uri.equals("/educationsystem/TeacherQueryName")) {
            TeacherQueryName(request, response);
        } else if (uri.equals("/educationsystem/stuTeacherQueryName")) {
            stuTeacherQueryName(request, response);
        } else if (uri.equals("/educationsystem/teaTeacherQueryName")) {
            teaTeacherQueryName(request, response);
        } else if (uri.equals("/educationsystem/TeacherLogOut")) {
            TeacherLogOut(request, response);
        }else if (uri.equals("/educationsystem/TeacherRegisterServlet")) {
			TeacherRegisterServlet(request, response);
		}else if (uri.equals("/educationsystem/TeacherLoginServlet")) {
            TeacherLoginServlet(request, response);
        }
    }

    protected void TeacherQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teacher> list = new ArrayList<>();
        list = teacherService.TeacherQuery();
        request.getSession().setAttribute("TeacherList", list); //用户界面展示所有教师的数据
        request.getRequestDispatcher("/TeacherTables.jsp").forward(request, response);
    }

    //登陆时查询数据并跳转页面
    protected void teaTeacherQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teacher> list = new ArrayList<>();
        list = teacherService.TeacherQuery();
        request.getSession().setAttribute("TeacherList", list);
        request.getRequestDispatcher("/tTeacherTables.jsp").forward(request, response);
    }

    protected void stuTeacherQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teacher> list = new ArrayList<>();
        list = teacherService.TeacherQuery();
        request.getSession().setAttribute("TeacherList", list);
        request.getRequestDispatcher("/stuTeacherTables.jsp").forward(request, response);
    }

    protected void AddTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String t_name = request.getParameter("t_name");
        String t_sex = request.getParameter("t_sex");
        String l_name = request.getParameter("l_name");
        String t_phone = request.getParameter("t_phone");
        String t_password = request.getParameter("t_password");

        Teacher teacher = new Teacher();
        teacher.setT_name(t_name);
        teacher.setT_sex(t_sex);
        teacher.setL_name(l_name);
        teacher.setT_phone(t_phone);
        teacher.setT_password(t_password);
        boolean isOk = teacherService.addTeacher(teacher);
        if (isOk) {
            request.getRequestDispatcher("/TeacherQuery").forward(request, response);
        } else {
            request.getRequestDispatcher("/addTeacher.jsp").forward(request, response);
        }
    }

    //注册时的添加教师用户信息
    protected void TeacherRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_name = request.getParameter("name");
        String s_sex = request.getParameter("sex");
        String l_name = request.getParameter("l_name");
        String s_phone = request.getParameter("phone");
        String s_password = request.getParameter("password");

        Teacher teacher = new Teacher();
        teacher.setT_name(s_name);
        teacher.setT_sex(s_sex);
        teacher.setL_name(l_name);
        teacher.setT_phone(s_phone);
        teacher.setT_password(s_password);


        // 3、通过调用业务层的代码来进行用户的注册
        boolean register_teacher = new TeacherDao().addTeacher(teacher);
        // 4、根据结果进行页面跳转
        if (register_teacher) {// 成功注册用户
            request.getRequestDispatcher("/teacherLogin.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/teacherRegister.jsp").forward(request, response);
        }
    }

    //教师端登录时检验用户
    protected void TeacherLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、接收请求的用户名和密码 根据key来获取
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        // 2、将用户名和密码封装到teacher的对象中
        Teacher teacher = new Teacher();
        teacher.setT_name(name);
        teacher.setT_password(password);
        // 3、通过调用业务层的代码来进行用户的登录校验
        Teacher login_teacher = teacherService.teacherLogin(teacher);
        // 4、根据结果进行页面跳转
        if (login_teacher != null) {// 有查询到该用户，成功
            request.getSession().setAttribute("username", name);
            request.getSession().setAttribute("login_teacher", login_teacher); //用于前端接收数据显示登录者的用户名
            request.getRequestDispatcher("/teaTeacherQuery").forward(request, response);
        } else {
            request.getRequestDispatcher("/teacherLogin.jsp").forward(request, response);
        }
    }

    protected void TeacherDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("t_id");
        int t_id = Integer.parseInt(id);
        teacherService.deleteTeacher(t_id);
        request.getRequestDispatcher("/TeacherQuery").forward(request, response);
    }

    protected void TeacherUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("t_id");
        int t_id = Integer.parseInt(id);
        String t_name = request.getParameter("t_name");
        String t_sex = request.getParameter("t_sex");
        String l_name = request.getParameter("l_name");
        String t_phone = request.getParameter("t_phone");
        String t_password = request.getParameter("t_password");
        Teacher teacher = new Teacher(t_id, t_name, t_sex, l_name, t_phone, t_password);
        boolean isOk = teacherService.updateTeacher(teacher);
        if (isOk) {
            request.getRequestDispatcher("/TeacherQuery").forward(request, response);
        } else {
            request.getRequestDispatcher("/TeacherToUpdate?t_id = " + t_id).forward(request, response);
        }
    }

    protected void TeacherToUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("t_id");
        int t_id = Integer.parseInt(id);
        Teacher teacher = teacherService.queryTeacherById(t_id);
        request.setAttribute("UpdateTeacher", teacher);
        request.getRequestDispatcher("/updateTeacher.jsp").forward(request, response);
    }

    protected void TeacherQueryName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teacher> list = new ArrayList<>();
        String t_name = request.getParameter("t_name");
        list = teacherService.queryTeacherName(t_name);
        request.setAttribute("TeacherQueryName", t_name);
        request.getSession().setAttribute("TeacherList", list);

        // 4、跳转页面
        request.getRequestDispatcher("TeacherTables.jsp").forward(request, response);
    }

    protected void stuTeacherQueryName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teacher> list = new ArrayList<>();
        String t_name = request.getParameter("t_name");
        list = teacherService.queryTeacherName(t_name);
        request.setAttribute("stuTeacherQueryName", t_name);
        request.getSession().setAttribute("TeacherList", list);
        request.getRequestDispatcher("/stuTeacherTables.jsp").forward(request, response);
    }

    protected void teaTeacherQueryName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teacher> list = new ArrayList<>();
        String t_name = request.getParameter("t_name");
        list = teacherService.queryTeacherName(t_name);
        request.setAttribute("teaTeacherQueryName", t_name);
        request.getSession().setAttribute("TeacherList", list);
        request.getRequestDispatcher("/teaTeacherTables.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void TeacherLogOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/page-login.jsp").forward(request, response);
    }

	protected void TeacherRegisterServlet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");

		// 1、接收请求的用户名和密码 根据key来获取
		String name = request.getParameter("name");

		PrintWriter pw = response.getWriter();
		if (teacherService.queryTeacherByName(name)) {
			pw.write("1");
		} else if (name == null || name.matches(".*\\d+.*")) {
			pw.write("2");
		} else {
			pw.write("3");
		}
		pw.flush();
		pw.close();
	}

	//用于登录时验证用户是否合法以及是否已存在
	protected  void TeacherLoginServlet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 1、接收请求的用户名和密码 根据key来获取
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        // 2、将用户名和密码封装到teacher的对象中
        Teacher teacher = new Teacher();
        teacher.setT_name(name);
        teacher.setT_password(password);

        PrintWriter pw = response.getWriter();
        if (!teacherService.queryTeacherByName(name)) {
            pw.write("1"); //用户不存在
        } else if (teacherService.teacherLogin(teacher) == null) {
            pw.write("2"); //用户名或密码错误
        } else {
            pw.write("3"); //验证成功
        }
        pw.flush();
        pw.close();
    }
}
