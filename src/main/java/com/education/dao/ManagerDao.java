package com.education.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.education.bean.Manager;
import com.education.utils.DataSource;

public class ManagerDao {
	// 获取数据库链接对象
	public static Connection connection = DataSource.getConnection();

	// 根据id查询管理员数据
	public Manager queryManagerById(int id) {
		// 1、定义sql语句 占位符?表示一个动态参数入参
		String sql = "select * from manager where e_id=?";
		try {
			// 2、通过链接对象来获取sql的语句对象
			PreparedStatement ps = connection.prepareStatement(sql);
			// 注入参数 使用set方法注入 第一个参数表示的是第几个占位符
			ps.setInt(1, id);
			// 3、执行SQL 通过executeQuery方法执行查询语句,返回结果集对象
			ResultSet rs = ps.executeQuery();
			// 4、遍历结果集，从结果集中获取数据
			while (rs.next()) {// 判断是否有下一条数据，如果有则获取
				// 使用get方法来根据字段名来获取数据
				int e_id = rs.getInt("e_id");
				String e_name = rs.getString("e_name");
				String e_password = rs.getString("e_password");
				// 封装到对象中
				Manager manager = new Manager(e_id, e_name, e_password);
				// 返回manager
				return manager;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 返回空
		return null;
	}

	// 管理员登录时根据用户名密码查询管理员数据
	public Manager managerLogin(Manager manager) {
		// 1、定义sql语句 占位符?表示一个动态参数入参
		String sql = "select * from manager where e_name=? and e_password=?";
		try {
			// 2、通过链接对象来获取sql的语句对象
			PreparedStatement ps = connection.prepareStatement(sql);
			// 注入参数 使用set方法注入 第一个参数表示的是第几个占位符
			ps.setString(1, manager.getE_name());
			ps.setString(2, manager.getE_password());
			// 3、执行SQL 通过executeQuery方法执行查询语句,返回结果集对象
			ResultSet rs = ps.executeQuery();
			// 4、遍历结果集，从结果集中获取数据
			while (rs.next()) {// 判断是否有下一条数据，如果有则获取
				// 使用get方法来根据字段名来获取数据
				int e_id = rs.getInt("e_id");
				String e_name = rs.getString("e_name");
				String e_password = rs.getString("e_password");
				// 封装到对象中
				Manager managerLogin = new Manager(e_id, e_name, e_password);
				// 返回manager
				return managerLogin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 返回空
		return null;
	}

	// 查询展示所有的管理员数据
	public List<Manager> queryManager() {
		List<Manager> list = new ArrayList<>();
		// 1、定义sql语句 占位符?表示一个动态参数入参
		String sql = "select * from manager";
		try {
			// 2、通过链接对象来获取sql的语句对象
			PreparedStatement ps = connection.prepareStatement(sql);
			// 3、执行SQL 通过executeQuery方法执行查询语句,返回结果集对象
			ResultSet rs = ps.executeQuery();
			// 4、遍历结果集，从结果集中获取数据
			while (rs.next()) {// 判断是否有下一条数据，如果有则获取
				// 使用get方法来根据字段名来获取数据
				int e_id = rs.getInt("e_id");
				String e_name = rs.getString("e_name");
				String e_password = rs.getString("e_password");
				// 封装到对象中
				Manager manager = new Manager(e_id, e_name, e_password);
				// 把对象添加到集合中
				list.add(manager);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 返回集合对象
		return list;
	}

	// 添加管理员数据
	public boolean insertManager(Manager manager) {
		// 1、定义sql语句 占位符?表示一个动态参数入参
		String sql = "insert into manager(e_name,e_password) values(?,?)";
		try {
			// 2、通过链接对象来获取sql的语句对象
			PreparedStatement ps = connection.prepareStatement(sql);
			// 3、注入参数 使用set方法注入 第一个参数表示的是第几个占位符
			ps.setString(1, manager.getE_name());
			ps.setString(2, manager.getE_password());
			// 4、执行SQL 添加、删除、修改都可以使用executeUpdate执行
			int ret = ps.executeUpdate();
			if (ret > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 修改管理员数据
	public boolean updateManager(Manager manager) {
		// 1、定义sql语句 占位符?表示一个动态参数入参
		String sql = "update manager set e_name=?,e_password=? where e_id=?";
		try {
			// 2、通过链接对象来获取sql的语句对象
			PreparedStatement ps = connection.prepareStatement(sql);
			// 3、注入参数 使用set方法注入 第一个参数表示的是第几个占位符
			ps.setString(1, manager.getE_name());
			ps.setString(2, manager.getE_password());
			ps.setInt(3, manager.getE_id());
			// 4、执行SQL 添加、删除、修改都可以使用executeUpdate执行
			int ret = ps.executeUpdate();
			if (ret > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 删除管理员数据
	public boolean deleteManager(int id) {
		// 1、定义sql语句 占位符?表示一个动态参数入参
		String sql = "delete from manager where e_id=?";
		try {
			// 2、通过链接对象来获取sql的语句对象
			PreparedStatement ps = connection.prepareStatement(sql);
			// 3、注入参数 使用set方法注入 第一个参数表示的是第几个占位符
			ps.setInt(1, id);
			// 4、执行SQL 添加、删除、修改都可以使用executeUpdate执行
			int ret = ps.executeUpdate();
			if (ret > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
