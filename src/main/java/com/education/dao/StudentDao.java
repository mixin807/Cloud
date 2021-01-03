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

    //查询展示所有学生信息
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

    //添加学生数据
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

    //修改学生数据
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

    //删除学生数据
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

    //通过学生id找到学生
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

    //通过学生名字查询展示学生信息
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

    //通过名字查询是否有该学生
    public boolean queryStudentByName(String name){
        // 1、定义sql语句 占位符?表示一个动态参数入参
        String sql = "select * from student where s_name=?";
        try {
            // 2、通过链接对象来获取sql的语句对象
            PreparedStatement ps = connection.prepareStatement(sql);
            // 注入参数 使用set方法注入 第一个参数表示的是第几个占位符
            ps.setString(1, name);
            // 3、执行SQL 通过executeQuery方法执行查询语句,返回结果集对象
            ResultSet rs = ps.executeQuery();
            // 4、遍历结果集，从结果集中获取数据
            while (rs.next()) {// 判断是否有下一条数据，如果有则获取
                // 返回true
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 返回false
        return false;
    }

    // 登陆学生端用户时根据用户名密码查询管理员数据
    public Student studentLogin(Student student) {
        // 1、定义sql语句 占位符?表示一个动态参数入参
        String sql = "select * from student where s_name=? and s_password=?";
        try {
            // 2、通过链接对象来获取sql的语句对象
            PreparedStatement ps = connection.prepareStatement(sql);
            // 注入参数 使用set方法注入 第一个参数表示的是第几个占位符
            ps.setString(1, student.getS_name());
            ps.setString(2, student.getS_password());
            // 3、执行SQL 通过executeQuery方法执行查询语句,返回结果集对象
            ResultSet rs = ps.executeQuery();
            // 4、遍历结果集，从结果集中获取数据
            while (rs.next()) {// 判断是否有下一条数据，如果有则获取
                // 使用get方法来根据字段名来获取数据
                int s_id = rs.getInt("s_id");
                String s_name = rs.getString("s_name");
                String s_password = rs.getString("s_password");
                // 封装到对象中
                Student studentLogin = new Student();
                // 返回manager
                return studentLogin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 返回空
        return null;
    }

}
