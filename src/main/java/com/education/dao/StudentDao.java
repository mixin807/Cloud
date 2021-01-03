package com.education.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.education.bean.Student;
import com.education.utils.DataSource;


public class StudentDao {
    public static Connection connection = DataSource.getConnection();

    //��ѯչʾ����ѧ����Ϣ
    public List<Student> CheckAllStudent() {
        List<Student> list = new ArrayList<>();
        String sql = "select * from student";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int s_id = rs.getInt("s_id");
                String s_name = rs.getString("s_name");
                String s_sex = rs.getString("s_sex");
                String s_bright = rs.getString("s_bright");
                String s_email = rs.getString("s_email");
                String s_phone = rs.getString("s_phone");
                String s_password = rs.getString("s_password");

                Student student = new Student(s_id, s_name, s_sex, s_bright
                        , s_email, s_phone, s_password);
                list.add(student);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //���ѧ������
    public boolean addStudent(Student student) {
        String sql = "insert into student(s_name , s_sex , s_bright , s_email , s_phone,s_password) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getS_name());
            ps.setString(2, student.getS_sex());
            ps.setString(3, student.getS_bright());
            ps.setString(4, student.getS_email());
            ps.setString(5, student.getS_phone());
            ps.setString(6,student.getS_password());
            int num = ps.executeUpdate();
            if (num > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //�޸�ѧ������
    public boolean updateStudent(Student student) {
        String sql = "update student set s_name = ? , s_sex = ? , s_bright = ? , s_email = ? , s_phone = ?,s_password=? WHERE s_id = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, student.getS_name());
            ps.setString(2, student.getS_sex());
            ps.setString(3, student.getS_bright());
            ps.setString(4, student.getS_email());
            ps.setString(5, student.getS_phone());
            ps.setString(6, student.getS_password());
            ps.setInt(7, student.getS_id());
            int num = ps.executeUpdate();
            if (num > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //ɾ��ѧ������
    public boolean deleteStudent(int id) {
        String sql = "delete from student where s_id = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int num = ps.executeUpdate();
            if (num > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //ͨ��ѧ��id�ҵ�ѧ��
    public Student checkStudentById(int id) {
        String sql = "select * from student where s_id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int s_id = rs.getInt("s_id");
                String s_name = rs.getString("s_name");
                String s_sex = rs.getString("s_sex");
                String s_bright = rs.getString("s_bright");
                String s_email = rs.getString("s_email");
                String s_phone = rs.getString("s_phone");
                String s_password = rs.getString("s_password");

                Student student = new Student(s_id, s_name, s_sex, s_bright
                        , s_email, s_phone, s_password);
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //ͨ��ѧ�����ֲ�ѯչʾѧ����Ϣ
    public List<Student> checkStudentByName(String name) {
        List<Student> list = new ArrayList<>();
        String sql = "select * from student where s_name = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                int s_id = rs.getInt("s_id");
                String s_name=rs.getString("s_name");
                String s_sex = rs.getString("s_sex");
                String s_bright=rs.getString("s_bright");
                String s_email = rs.getString("s_email");
                String s_phone=rs.getString("s_phone");
                String s_password=rs.getString("s_password");
                Student student = new Student(s_id, s_name,s_sex, s_bright, s_email, s_phone,s_password);
                list.add(student);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //ͨ�����ֲ�ѯ�Ƿ��и�ѧ��
    public boolean queryStudentByName(String name){
        // 1������sql��� ռλ��?��ʾһ����̬�������
        String sql = "select * from student where s_name=?";
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

    // ��½ѧ�����û�ʱ�����û��������ѯ����Ա����
    public Student studentLogin(Student student) {
        // 1������sql��� ռλ��?��ʾһ����̬�������
        String sql = "select * from student where s_name=? and s_password=?";
        try {
            // 2��ͨ�����Ӷ�������ȡsql��������
            PreparedStatement ps = connection.prepareStatement(sql);
            // ע����� ʹ��set����ע�� ��һ��������ʾ���ǵڼ���ռλ��
            ps.setString(1, student.getS_name());
            ps.setString(2, student.getS_password());
            // 3��ִ��SQL ͨ��executeQuery����ִ�в�ѯ���,���ؽ��������
            ResultSet rs = ps.executeQuery();
            // 4��������������ӽ�����л�ȡ����
            while (rs.next()) {// �ж��Ƿ�����һ�����ݣ���������ȡ
                // ʹ��get�����������ֶ�������ȡ����
                int s_id = rs.getInt("s_id");
                String s_name = rs.getString("s_name");
                String s_password = rs.getString("s_password");
                // ��װ��������
                Student studentLogin = new Student();
                // ����manager
                return studentLogin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ���ؿ�
        return null;
    }

}
