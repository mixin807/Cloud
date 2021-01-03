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
    // ����ҵ���Ķ���
    ManagerService managerService = new ManagerServiceImpl();

    // ������� ��Ӧ����
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ��ȡuri��ȥ�жϾ�����ʵĲ���
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

    //�޸Ĺ���Ա����
    protected void ManagerUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1������������û��������� ����key����ȡ
        String e_id = request.getParameter("e_id");
        int id = Integer.parseInt(e_id);
        String name = request.getParameter("e_name");
        String password = request.getParameter("e_password");
        // 2�����û����������װ��Manager�Ķ�����
        Manager e_manager = new Manager(id, name, password);
        // 3��ͨ������ҵ���Ĵ����������û����޸�
        boolean isok = managerService.updateManager(e_manager);
        // 4�����ݽ������ҳ����ת
        if (isok) {// �ɹ�
            request.getRequestDispatcher("/ManagerQuery").forward(request, response);
        } else {
            request.getRequestDispatcher("/ManagerToUpdate?e_id=" + id).forward(request, response);
        }
    }

    //ͨ��id�ҵ��ù���Ա-->�޸Ľ���
    protected void ManagerToUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1�����������id
        String e_id = request.getParameter("e_id");
        int id = Integer.parseInt(e_id);
        // 2��ͨ������ҵ���Ĵ����������û��Ĳ�ѯ
        Manager updateManager = managerService.queryManagerById(id);
        // �����ݱ�������������
        request.setAttribute("UpdateManager", updateManager);
        // 3�����ݽ������ҳ����ת
        request.getRequestDispatcher("/updateManager.jsp").forward(request, response);
    }

    //ɾ������Ա����
    protected void ManagerDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1�����������id
        String e_id = request.getParameter("e_id");
        int id = Integer.parseInt(e_id);
        // 2��ͨ������ҵ���Ĵ����������û���ɾ��
        managerService.deleteManager(id);
        // 3�����ݽ������ҳ����ת
        request.getRequestDispatcher("/ManagerQuery").forward(request, response);
    }

    //��ӹ���Ա
    protected void ManagerInsert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1������������û��������� ����key����ȡ
        String name = request.getParameter("e_name");
        String password = request.getParameter("e_password");
        // 2�����û����������װ��Manager�Ķ�����
        Manager manager = new Manager();
        manager.setE_name(name);
        manager.setE_password(password);
        // 3��ͨ������ҵ���Ĵ����������û������
        boolean isok = managerService.insertManager(manager);
        // 4�����ݽ������ҳ����ת
        if (isok) {// �ɹ�
            request.getRequestDispatcher("/ManagerQuery").forward(request, response);
        } else {
            request.getRequestDispatcher("/addManager.jsp").forward(request, response);
        }
    }

    //����Ա��¼
    protected void ManagerLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1������������û��������� ����key����ȡ
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        // 2�����û����������װ��Manager�Ķ�����
        Manager manager = new Manager();
        manager.setE_name(name);
        manager.setE_password(password);
        // 3��ͨ������ҵ���Ĵ����������û��ĵ�¼У��
        Manager login_manager = managerService.managerLogin(manager);
        // 4�����ݽ������ҳ����ת
        if (login_manager != null) {// �в�ѯ�����û����ɹ�
            HttpSession session=request.getSession();
            session.setAttribute("username",name);
            request.getSession().setAttribute("login_manager", login_manager);
            request.getRequestDispatcher("/ManagerQuery").forward(request, response);
        } else {
            request.getRequestDispatcher("/page-login.jsp").forward(request, response);
        }
    }

    //����Աע��
    protected void ManagerRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1������������û��������� ����key����ȡ
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        // 2�����û����������װ��Manager�Ķ�����
        Manager manager = new Manager();
        manager.setE_name(name);
        manager.setE_password(password);


        // 3��ͨ������ҵ���Ĵ����������û���ע��
        boolean register_manager = new ManagerDao().insertManager(manager);
        // 4�����ݽ������ҳ����ת
        if (register_manager) {// �ɹ�ע���û�
            request.getRequestDispatcher("/page-login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/page-register.jsp").forward(request, response);
        }
    }

    //��ѯչʾ����Ա
    protected void ManagerQuery(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ͨ������ҵ���Ĵ������������ݿ�õ���������
        List<Manager> list = managerService.queryManager();
        // 1�������ݱ�����ĳ�������������� ������session���Ự������
        request.getSession().setAttribute("ManagerList", list);
        // 2����תҳ��
        request.getRequestDispatcher("ManagerTables.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    //ע������Ա
    public void ManagerLogOut(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        request.getRequestDispatcher("/page-login.jsp").forward(request,response);
    }
}
