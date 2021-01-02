package com.education.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;

import com.education.bean.Student;
import com.education.bean.Teacher;
import com.education.dao.StudentDao;
import com.education.service.StudentService;
import com.education.service.impl.StudentServiceImpl;

@WebServlet(urlPatterns = {"/CheckAllStudent", "/stuCheckAllStudent", "/teaCheckAllStudent", "/AddStudent",
        "/teaAddStudent", "/StudentRegister", "/StudentLogin", "/StudentUpdate", "/teaStudentUpdate", "/StudentToUpdate",
        "/teaStudentToUpdate", "/StudentDelete", "/teaStudentDelete", "/StudentQueryName", "/StudentQuery",
        "/stuStudentQueryName","/teaStudentQueryName","/StudentLogOut","/StudentRegisterServlet","/StudentLoginServlet"})
public class StudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/educationsystem/CheckAllStudent")) {
            CheckAllStudent(request, response);
        } else if (uri.equals("/educationsystem/stuCheckAllStudent")) {
            stuCheckAllStudent(request, response);
        } else if (uri.equals("/educationsystem/teaCheckAllStudent")) {
            teaCheckAllStudent(request, response);
        } else if (uri.equals("/educationsystem/AddStudent")) {
            AddStudent(request, response);
        } else if (uri.equals("/educationsystem/teaAddStudent")) {
            teaAddStudent(request, response);
        } else if (uri.equals("/educationsystem/StudentRegister")) {
            StudentRegister(request, response);
        } else if (uri.equals("/educationsystem/StudentLogin")) {
            StudentLogin(request, response);
        } else if (uri.equals("/educationsystem/StudentUpdate")) {
            StudentUpdate(request, response);
        } else if (uri.equals("/educationsystem/teaStudentUpdate")) {
            teaStudentUpdate(request, response);
        } else if (uri.equals("/educationsystem/StudentToUpdate")) {
            StudentToUpdate(request, response);
        } else if (uri.equals("/educationsystem/teaStudentToUpdate")) {
            teaStudentToUpdate(request, response);
        } else if (uri.equals("/educationsystem/StudentDelete")) {
            StudentDelete(request, response);
        } else if (uri.equals("/educationsystem/teaStudentDelete")) {
            teaStudentDelete(request, response);
        } else if (uri.equals("/educationsystem/StudentQueryName")) {
            StudentQueryName(request, response);
        } else if (uri.equals("/educationsystem/StudentQuery")) {
            StudentQuery(request, response);
        } else if (uri.equals("/educationsystem/stuStudentQueryName")) {
            stuStudentQueryName(request, response);
        } else if (uri.equals("/educationsystem/teaStudentQueryName")) {
            teaStudentQueryName(request, response);
        } else if (uri.equals("/educationsystem/StudentLogOut")) {
            StudentLogOut(request, response);
        } else if (uri.equals("/educationsystem/StudentRegisterServlet")) {
            StudentRegisterServlet(request, response);
        } else if (uri.equals("/educationsystem/StudentLoginServlet")) {
            StudentLoginServlet(request, response);
        }
    }

    //管理员端显示所有学生信息
    protected void CheckAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> list = studentService.CheckAllStudent();
        request.getSession().setAttribute("StudentList", list);
        request.getRequestDispatcher("StudentTables.jsp").forward(request, response);
    }

    //学生端显示所有信息
    protected void stuCheckAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> list = studentService.CheckAllStudent();
        request.getSession().setAttribute("StudentList", list);
        request.getRequestDispatcher("stuStudentTables.jsp").forward(request, response);
    }

    //教师端显示所有信息
    protected void teaCheckAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> list = studentService.CheckAllStudent();
        request.getSession().setAttribute("StudentList", list);
        request.getRequestDispatcher("tStudentTables.jsp").forward(request, response);
    }

    protected void AddStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_name = request.getParameter("s_name");
        String s_sex = request.getParameter("s_sex");
        String s_bright = request.getParameter("s_bright");
        String s_email = request.getParameter("s_email");
        String s_phone = request.getParameter("s_phone");
        String s_password = request.getParameter("s_password");

        Student student = new Student();
        student.setS_name(s_name);
        student.setS_sex(s_sex);
        student.setS_bright(s_bright);
        student.setS_email(s_email);
        student.setS_phone(s_phone);
        student.setS_password(s_password);
        boolean isOk = studentService.addStudent(student);
        System.out.println(isOk);
        if (isOk) {
            request.getRequestDispatcher("/CheckAllStudent").forward(request, response);
        } else {
            request.getRequestDispatcher("/addStudent.jsp").forward(request, response);
            ;
        }
    }

    protected void teaAddStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_name = request.getParameter("s_name");
        String s_sex = request.getParameter("s_sex");
        String s_bright = request.getParameter("s_bright");
        String s_email = request.getParameter("s_email");
        String s_phone = request.getParameter("s_phone");
        String s_password = request.getParameter("s_password");

        Student student = new Student();
        student.setS_name(s_name);
        student.setS_sex(s_sex);
        student.setS_bright(s_bright);
        student.setS_email(s_email);
        student.setS_phone(s_phone);
        student.setS_password(s_password);
        boolean isOk = studentService.addStudent(student);
        System.out.println(isOk);
        if (isOk) {
            request.getRequestDispatcher("/teaCheckAllStudent").forward(request, response);
        } else {
            request.getRequestDispatcher("/taddStudent.jsp").forward(request, response);
            ;
        }
    }

    //注册时的添加学生用户信息
    protected void StudentRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String s_name = request.getParameter("name");
        String s_sex = request.getParameter("sex");
        String s_bright = request.getParameter("bright");
        String s_email = request.getParameter("email");
        String s_phone = request.getParameter("phone");
        String s_password = request.getParameter("password");

        Student student = new Student();
        student.setS_name(s_name);
        student.setS_sex(s_sex);
        student.setS_bright(s_bright);
        student.setS_email(s_email);
        student.setS_phone(s_phone);
        student.setS_password(s_password);


        // 3、通过调用业务层的代码来进行用户的注册
        boolean register_student = new StudentDao().addStudent(student);
        // 4、根据结果进行页面跳转
        if (register_student) {// 成功注册用户
            request.getRequestDispatcher("/stumanagerLogin.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/Studentjsp/stumanagerRegister.jsp").forward(request, response);
        }
    }

    //学生端登录时检验用户
    protected void StudentLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、接收请求的用户名和密码 根据key来获取
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        // 2、将用户名和密码封装到Manager的对象中
        Student student = new Student();
        student.setS_name(name);
        student.setS_password(password);
        // 3、通过调用业务层的代码来进行用户的登录校验
        Student login_student = studentService.studentLogin(student);
        // 4、根据结果进行页面跳转
        if (login_student != null) {// 有查询到该用户，成功
            HttpSession session = request.getSession();
            session.setAttribute("username", name);
            request.getSession().setAttribute("login_student", login_student);
            request.getRequestDispatcher("/StudentQuery").forward(request, response);
        } else {
            request.getRequestDispatcher("/stumanagerLogin.jsp").forward(request, response);
        }
    }

    protected void StudentUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id1 = request.getParameter("s_id");
        int s_id = Integer.parseInt(id1);
        String s_name = request.getParameter("s_name");
        String s_sex = request.getParameter("s_sex");
        String s_bright = request.getParameter("s_bright");
        String s_email = request.getParameter("s_email");
        String s_phone = request.getParameter("s_phone");
        String s_password = request.getParameter("s_password");

        Student student = new Student(s_id, s_name, s_sex, s_bright, s_email, s_phone, s_password);
        boolean isOk = studentService.updateStudent(student);
        if (isOk) {
            request.getRequestDispatcher("/CheckAllStudent").forward(request, response);
            ;
        } else {
            request.getRequestDispatcher("/StudentToUpdate?e_id=" + s_id).forward(request, response);
        }
    }

    protected void teaStudentUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id1 = request.getParameter("s_id");
        int s_id = Integer.parseInt(id1);
        String s_name = request.getParameter("s_name");
        String s_sex = request.getParameter("s_sex");
        String s_bright = request.getParameter("s_bright");
        String s_email = request.getParameter("s_email");
        String s_phone = request.getParameter("s_phone");
        String s_password = request.getParameter("s_password");

        Student student = new Student(s_id, s_name, s_sex, s_bright, s_email, s_phone, s_password);
        boolean isOk = studentService.updateStudent(student);
        if (isOk) {
            request.getRequestDispatcher("/teaCheckAllStudent").forward(request, response);
            ;
        } else {
            request.getRequestDispatcher("/teaStudentToUpdate?e_id=" + s_id).forward(request, response);
        }
    }

    protected void StudentToUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("s_id");
        int s_id = Integer.parseInt(id);
        Student student = studentService.checkStudentById(s_id);

        request.setAttribute("UpdateStudent", student);

        request.getRequestDispatcher("/updateStudent.jsp").forward(request, response);
    }

    protected void teaStudentToUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("s_id");
        int s_id = Integer.parseInt(id);
        Student student = studentService.checkStudentById(s_id);

        request.setAttribute("UpdateStudent", student);

        request.getRequestDispatcher("/tupdateStudent.jsp").forward(request, response);
    }

    protected void StudentDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int flag = JOptionPane.showConfirmDialog(null, "您确定删除该学生信息?", "提示", JOptionPane.YES_NO_OPTION);
        if (flag == JOptionPane.YES_OPTION) {
            String id = request.getParameter("s_id");
            int s_id = Integer.parseInt(id);
            studentService.deleteStudent(s_id);
            request.getRequestDispatcher("/CheckAllStudent").forward(request, response);
        } else {
            request.getRequestDispatcher("/CheckAllStudent").forward(request, response);
        }
    }

    protected void teaStudentDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int flag = JOptionPane.showConfirmDialog(null, "您确定删除该学生信息?", "提示", JOptionPane.YES_NO_OPTION);
        if (flag == JOptionPane.YES_OPTION) {
            String id = request.getParameter("s_id");
            int s_id = Integer.parseInt(id);
            studentService.deleteStudent(s_id);
            request.getRequestDispatcher("/teaCheckAllStudent").forward(request, response);
        } else {
            request.getRequestDispatcher("/teaCheckAllStudent").forward(request, response);
        }

    }

    protected void StudentQueryName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> list = new ArrayList<>();
        String s_name = request.getParameter("s_name");
        list = studentService.checkStudentByName(s_name);
        request.setAttribute("StudentQueryName", s_name);
        request.getSession().setAttribute("StudentList", list);
        request.getRequestDispatcher("/StudentTables.jsp").forward(request, response);
    }

    //验证登录时所需
    protected void StudentQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// 定义一个页码变量
//		int pageindex = 1;
//		String pageNo = request.getParameter("pageNo");
//		if (pageNo != null) {
//			// 进行数据转换
//			pageindex = Integer.parseInt(pageNo);
//		}
//		PageModel page = new PageModel(pageindex, ManagerDao.queryManagerCount());
//		// 通过调用业务层的代码来操作数据库得到集合数据
//		List<StudentManager> list = studentmanagerService.queryStudentManagerByPage(page);
//		// 1、将数据保存在某个作用域（容器） 保存在session（会话作用域）
//		// 保存pagemodel的数据到作用域中
//		request.setAttribute("pageInfo", page);
//		request.getSession().setAttribute("StudentManagerList", list);
        // 2、跳转页面
        request.getRequestDispatcher("/stuStudentTables.jsp").forward(request, response);
    }
    //学生端通过名字查询
    protected void stuStudentQueryName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> list = new ArrayList<>();
        String s_name = request.getParameter("s_name");
        list = studentService.checkStudentByName(s_name);
        request.setAttribute("stuStudentQueryName", s_name);
        request.getSession().setAttribute("StudentList", list);
        request.getRequestDispatcher("/stuStudentTables.jsp").forward(request, response);
    }

    protected void teaStudentQueryName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> list = new ArrayList<>();
        String s_name = request.getParameter("s_name");
        list = studentService.checkStudentByName(s_name);
        request.setAttribute("teaStudentQueryName", s_name);
        request.getSession().setAttribute("StudentList", list);
        request.getRequestDispatcher("/tStudentTables.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void StudentLogOut(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        request.getRequestDispatcher("/page-login.jsp").forward(request,response);
    }

    protected void StudentRegisterServlet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 1、接收请求的用户名和密码 根据key来获取
        String name = request.getParameter("name");

        PrintWriter pw = response.getWriter();
        if (studentService.queryStudentByName(name)) {
            pw.write("1");
        } else if (name == null || name.matches(".*\\d+.*")) {
            pw.write("2");
        } else {
            pw.write("3");
        }
        pw.flush();
        pw.close();
    }

    protected  void StudentLoginServlet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 1、接收请求的用户名和密码 根据key来获取
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        // 2、将用户名和密码封装到teacher的对象中
        Student student= new Student();
        student.setS_name(name);
        student.setS_password(password);

        PrintWriter pw = response.getWriter();
        if (!studentService.queryStudentByName(name)) {
            pw.write("1"); //用户不存在
        } else if (studentService.studentLogin(student) == null) {
            pw.write("2"); //用户名或密码错误
        } else {
            pw.write("3"); //验证成功
        }
        pw.flush();
        pw.close();
    }

}
