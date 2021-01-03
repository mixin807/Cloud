package com.education.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.education.bean.Manager;
import com.education.dao.ManagerDao;
import com.education.service.ManagerService;
import com.education.service.impl.ManagerServiceImpl;

@WebServlet(urlPatterns = {"/ManagerLogin","/ManagerRegister", "/ManagerQuery", "/ManagerUpdate",
        "/ManagerInsert", "/ManagerToUpdate", "/ManagerDelete","/ManagerLogOut"})
public class ManagerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // 创建业务层的对象
    ManagerService managerService = new ManagerServiceImpl();

    // 请求对象 响应对象
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取uri来去判断具体访问的操作
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.equals("/educationsystem/ManagerLogin")) {
            ManagerLogin(request, response);
        } else if (uri.equals("/educationsystem/ManagerRegister")) {
            ManagerRegister(request, response);
        } else if (uri.equals("/educationsystem/ManagerQuery")) {
            ManagerQuery(request, response);
        } else if (uri.equals("/educationsystem/ManagerInsert")) {
            ManagerInsert(request, response);
        } else if (uri.equals("/educationsystem/ManagerDelete")) {
            ManagerDelete(request, response);
        } else if (uri.equals("/educationsystem/ManagerToUpdate")) {
            ManagerToUpdate(request, response);
        } else if (uri.equals("/educationsystem/ManagerUpdate")) {
            ManagerUpdate(request, response);
        } else if (uri.equals("/educationsystem/ManagerLogOut")) {
            ManagerLogOut(request, response);
        }
    }

    //修改管理员数据
    protected void ManagerUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1、接收请求的用户名和密码 根据key来获取
        String e_id = request.getParameter("e_id");
        int id = Integer.parseInt(e_id);
        String name = request.getParameter("e_name");
        String password = request.getParameter("e_password");
        // 2、将用户名和密码封装到Manager的对象中
        Manager e_manager = new Manager(id, name, password);
        // 3、通过调用业务层的代码来进行用户的修改
        boolean isok = managerService.updateManager(e_manager);
        // 4、根据结果进行页面跳转
        if (isok) {// 成功
            request.getRequestDispatcher("/ManagerQuery").forward(request, response);
        } else {
            request.getRequestDispatcher("/ManagerToUpdate?e_id=" + id).forward(request, response);
        }
    }

    //通过id找到该管理员-->修改界面
    protected void ManagerToUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1、接收请求的id
        String e_id = request.getParameter("e_id");
        int id = Integer.parseInt(e_id);
        // 2、通过调用业务层的代码来进行用户的查询
        Manager updateManager = managerService.queryManagerById(id);
        // 将数据保存在作用域中
        request.setAttribute("UpdateManager", updateManager);
        // 3、根据结果进行页面跳转
        request.getRequestDispatcher("/updateManager.jsp").forward(request, response);
    }

    //删除管理员数据
    protected void ManagerDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1、接收请求的id
        String e_id = request.getParameter("e_id");
        int id = Integer.parseInt(e_id);
        // 2、通过调用业务层的代码来进行用户的删除
        managerService.deleteManager(id);
        // 3、根据结果进行页面跳转
        request.getRequestDispatcher("/ManagerQuery").forward(request, response);
    }

    //添加管理员
    protected void ManagerInsert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1、接收请求的用户名和密码 根据key来获取
        String name = request.getParameter("e_name");
        String password = request.getParameter("e_password");
        // 2、将用户名和密码封装到Manager的对象中
        Manager manager = new Manager();
        manager.setE_name(name);
        manager.setE_password(password);
        // 3、通过调用业务层的代码来进行用户的添加
        boolean isok = managerService.insertManager(manager);
        // 4、根据结果进行页面跳转
        if (isok) {// 成功
            request.getRequestDispatcher("/ManagerQuery").forward(request, response);
        } else {
            request.getRequestDispatcher("/addManager.jsp").forward(request, response);
        }
    }

    //管理员登录
    protected void ManagerLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1、接收请求的用户名和密码 根据key来获取
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        // 2、将用户名和密码封装到Manager的对象中
        Manager manager = new Manager();
        manager.setE_name(name);
        manager.setE_password(password);
        // 3、通过调用业务层的代码来进行用户的登录校验
        Manager login_manager = managerService.managerLogin(manager);
        // 4、根据结果进行页面跳转
        if (login_manager != null) {// 有查询到该用户，成功
            HttpSession session=request.getSession();
            session.setAttribute("username",name);
            request.getSession().setAttribute("login_manager", login_manager);
            request.getRequestDispatcher("/ManagerQuery").forward(request, response);
        } else {
            request.getRequestDispatcher("/page-login.jsp").forward(request, response);
        }
    }

    //管理员注册
    protected void ManagerRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1、接收请求的用户名和密码 根据key来获取
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        // 2、将用户名和密码封装到Manager的对象中
        Manager manager = new Manager();
        manager.setE_name(name);
        manager.setE_password(password);


        // 3、通过调用业务层的代码来进行用户的注册
        boolean register_manager = new ManagerDao().insertManager(manager);
        // 4、根据结果进行页面跳转
        if (register_manager) {// 成功注册用户
            request.getRequestDispatcher("/page-login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/page-register.jsp").forward(request, response);
        }
    }

    //查询展示管理员
    protected void ManagerQuery(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 通过调用业务层的代码来操作数据库得到集合数据
        List<Manager> list = managerService.queryManager();
        // 1、将数据保存在某个作用域（容器） 保存在session（会话作用域）
        request.getSession().setAttribute("ManagerList", list);
        // 2、跳转页面
        request.getRequestDispatcher("ManagerTables.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    //注销管理员
    public void ManagerLogOut(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        request.getRequestDispatcher("/page-login.jsp").forward(request,response);
    }
}
