package com.education.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.education.bean.Teacher;
import com.education.utils.DataSource;


public class TeacherDao {
    private static Connection connection = DataSource.getConnection();

    //��ѯչʾ���н�ʦ����
    public List<Teacher> TeacherQuery() {
        String sql = "select * from teacher";
        List<Teacher> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int t_id = rs.getInt("t_id");
                String t_name = rs.getString("t_name");
                String t_sex = rs.getString("t_sex");
                String l_name = rs.getString("l_name");
                String t_phone = rs.getString("t_phone");
                String t_password=rs.getString("t_password");
                Teacher teacher = new Teacher(t_id, t_name, t_sex, l_name,t_phone,t_password);
                list.add(teacher);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //���ѧ������
    public boolean addTeacher(Teacher teacher) {
        String sql = "insert into teacher (t_name,t_sex,l_name,t_phone,t_password) values (?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, teacher.getT_name());
            ps.setString(2, teacher.getT_sex());
            ps.setString(3, teacher.getL_name());
            ps.setString(4, teacher.getT_phone());
            ps.setString(5, teacher.getT_password());
            int ret = ps.executeUpdate();
            if (ret > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //�޸Ľ�ʦ����
    public boolean updateTeacher(Teacher teacher) {
        String sql = "update teacher set t_name = ?,t_sex=?,l_name=?,t_phone=?,t_password=? where t_id = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
			ps.setString(1, teacher.getT_name());
            ps.setString(2,teacher.getT_sex());
            ps.setString(3,teacher.getL_name());
            ps.setString(4,teacher.getT_phone());
            ps.setString(5,teacher.getT_password());
            ps.setInt(6, teacher.getT_id());
            int ret = ps.executeUpdate();
            if (ret > 0) {
                return true;
            }
        } catch (SQLException e) {
			e.printStackTrace();
        }
        return false;
    }

    //ɾ����ʦ����
    public boolean deleteTeacher(int id) {
        String sql = "delete from teacher where t_id = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int ret = ps.executeUpdate();
            if (ret > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //ͨ�����ֲ�ѯչʾ��ʦ
    public List<Teacher> queryTeacherName(String name) {
        List<Teacher> list = new ArrayList<>();
        String sql = "select * from teacher where t_name = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                int t_id = rs.getInt("t_id");
                String t_name = rs.getString("t_name");
                String t_sex = rs.getString("t_sex");
                String l_name = rs.getString("l_name");
                String t_phone = rs.getString("t_phone");
                String t_password=rs.getString("t_password");
                Teacher teacher = new Teacher(t_id, t_name, t_sex, l_name,t_phone,t_password);
                list.add(teacher);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //ͨ�����ֲ�ѯ�Ƿ��иý�ʦ
    public boolean queryTeacherByName(String name){
        // 1������sql��� ռλ��?��ʾһ����̬�������
        String sql = "select * from teacher where t_name=?";
        try {
            // 2��ͨ�����Ӷ�������ȡsql��������
            PreparedStatement ps = connection.prepareStatement(sql);
            // ע����� ʹ��set����ע�� ��һ��������ʾ���ǵڼ���ռλ��
            ps.setString(1, name);
            // 3��ִ��SQL ͨ��executeQuery����ִ�в�ѯ���,���ؽ��������
            ResultSet rs = ps.executeQuery();
            // 4��������������ӽ�����л�ȡ����
            while (rs.next()) {// �ж��Ƿ�����һ�����ݣ���������ȡ
                // ����true
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ����false
        return false;
    }

    //ͨ��id���ҽ�ʦ
    public Teacher queryTeacherById(int id) {
        String sql = "select * from teacher where t_id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int t_id = rs.getInt("t_id");
                String t_name = rs.getString("t_name");
                String t_sex = rs.getString("t_sex");
                String l_name = rs.getString("l_name");
                String t_phone = rs.getString("t_phone");
                String t_password=rs.getString("t_password");
                Teacher teacher = new Teacher(t_id, t_name, t_sex, l_name,t_phone,t_password);
                return teacher;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ��½��ʦ���û�ʱ�����û��������ѯ����
    public Teacher teacherLogin(Teacher teacher) {
        // 1������sql��� ռλ��?��ʾһ����̬�������
        String sql = "select * from teacher where t_name=? and t_password=?";
        try {
            // 2��ͨ�����Ӷ�������ȡsql��������
            PreparedStatement ps = connection.prepareStatement(sql);
            // ע����� ʹ��set����ע�� ��һ��������ʾ���ǵڼ���ռλ��
            ps.setString(1, teacher.getT_name());
            ps.setString(2, teacher.getT_password());
            // 3��ִ��SQL ͨ��executeQuery����ִ�в�ѯ���,���ؽ��������
            ResultSet rs = ps.executeQuery();
            // 4��������������ӽ�����л�ȡ����
            while (rs.next()) {// �ж��Ƿ�����һ�����ݣ���������ȡ
                // ʹ��get�����������ֶ�������ȡ����
                int t_id = rs.getInt("t_id");
                String t_name = rs.getString("t_name");
                String t_password = rs.getString("t_password");
                // ��װ��������
                Teacher teacherLogin = new Teacher();
                // ����manager
                return teacherLogin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ���ؿ�
        return null;
    }
}
