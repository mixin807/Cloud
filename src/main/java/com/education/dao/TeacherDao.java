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

    //查询展示所有教师数据
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

    //添加学生数据
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

    //修改教师数据
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

    //删除教师数据
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

    //通过名字查询展示教师
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

    //通过名字查询是否有该教师
    public boolean queryTeacherByName(String name){
        // 1、定义sql语句 占位符?表示一个动态参数入参
        String sql = "select * from teacher where t_name=?";
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

    //通过id查找教师
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

    // 登陆教师端用户时根据用户名密码查询数据
    public Teacher teacherLogin(Teacher teacher) {
        // 1、定义sql语句 占位符?表示一个动态参数入参
        String sql = "select * from teacher where t_name=? and t_password=?";
        try {
            // 2、通过链接对象来获取sql的语句对象
            PreparedStatement ps = connection.prepareStatement(sql);
            // 注入参数 使用set方法注入 第一个参数表示的是第几个占位符
            ps.setString(1, teacher.getT_name());
            ps.setString(2, teacher.getT_password());
            // 3、执行SQL 通过executeQuery方法执行查询语句,返回结果集对象
            ResultSet rs = ps.executeQuery();
            // 4、遍历结果集，从结果集中获取数据
            while (rs.next()) {// 判断是否有下一条数据，如果有则获取
                // 使用get方法来根据字段名来获取数据
                int t_id = rs.getInt("t_id");
                String t_name = rs.getString("t_name");
                String t_password = rs.getString("t_password");
                // 封装到对象中
                Teacher teacherLogin = new Teacher();
                // 返回manager
                return teacherLogin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 返回空
        return null;
    }
}
