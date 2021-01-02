package com.education.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.education.bean.Lesson;
import com.education.utils.DataSource;

public class LessonDao {
    private Connection connection = DataSource.getConnection();

    public List<Lesson> LessonQuery() {
        List<Lesson> list = new ArrayList<>();
        String sql = "select * from lesson";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int l_id = rs.getInt("l_id");
                String l_name = rs.getString("l_name");
                String l_time = rs.getString("l_time");
                String t_name = rs.getString("t_name");
                String l_describe = rs.getString("l_describe");
                Lesson lesson = new Lesson(l_id, l_name, l_time, t_name, l_describe);
                list.add(lesson);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addLesson(Lesson lesson) {
        String sql = "insert into lesson (l_name , l_time , t_name , l_describe) values (?  , ? , ? , ?) ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, lesson.getL_name());
            ps.setString(2, lesson.getL_time());
            ps.setString(3, lesson.getT_name());
            ps.setString(4, lesson.getL_describe());

            int ret = ps.executeUpdate();
            if (ret > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateLesson(Lesson lesson) {
        String sql = "update lesson set l_name = ? , l_time = ? ,t_name=?, l_describe = ? where l_id=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, lesson.getL_name());
			ps.setString(2, lesson.getL_time());
			ps.setString(3, lesson.getT_name());
			ps.setString(4, lesson.getL_describe());
            ps.setInt(5, lesson.getL_id());
            int ret = ps.executeUpdate();
            if (ret > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteLesson(int id) {
        String sql = "delete from lesson where l_id = ?";
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

    public List<Lesson> LessonQueryByName(String name) {
        List<Lesson> list = new ArrayList<>();
        String sql = "select * from lesson where l_name = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                int l_id = rs.getInt("l_id");
                String l_name=rs.getString("l_name");
                String l_time = rs.getString("l_time");
                String t_name=rs.getString("t_name");
                String l_describe = rs.getString("l_describe");
                Lesson lesson = new Lesson(l_id, l_name, l_time, t_name, l_describe);
                list.add(lesson);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Lesson LessonQureyById(int id) {
        String sql = "select * from lesson where l_id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int l_id = rs.getInt("l_id");
                String l_name = rs.getString("l_name");
                String l_time = rs.getString("l_time");
                String t_name=rs.getString("t_name");
                String l_describe = rs.getString("l_describe");
                Lesson lesson = new Lesson(l_id, l_name, l_time, t_name,l_describe);
                return lesson;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
