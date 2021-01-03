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
	// ��ȡ���ݿ����Ӷ���
	public static Connection connection = DataSource.getConnection();

	// ����id��ѯ����Ա����
	public Manager queryManagerById(int id) {
		// 1������sql��� ռλ��?��ʾһ����̬�������
		String sql = "select * from manager where e_id=?";
		try {
			// 2��ͨ�����Ӷ�������ȡsql��������
			PreparedStatement ps = connection.prepareStatement(sql);
			// ע����� ʹ��set����ע�� ��һ��������ʾ���ǵڼ���ռλ��
			ps.setInt(1, id);
			// 3��ִ��SQL ͨ��executeQuery����ִ�в�ѯ���,���ؽ��������
			ResultSet rs = ps.executeQuery();
			// 4��������������ӽ�����л�ȡ����
			while (rs.next()) {// �ж��Ƿ�����һ�����ݣ���������ȡ
				// ʹ��get�����������ֶ�������ȡ����
				int e_id = rs.getInt("e_id");
				String e_name = rs.getString("e_name");
				String e_password = rs.getString("e_password");
				// ��װ��������
				Manager manager = new Manager(e_id, e_name, e_password);
				// ����manager
				return manager;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ���ؿ�
		return null;
	}

	// ����Ա��¼ʱ�����û��������ѯ����Ա����
	public Manager managerLogin(Manager manager) {
		// 1������sql��� ռλ��?��ʾһ����̬�������
		String sql = "select * from manager where e_name=? and e_password=?";
		try {
			// 2��ͨ�����Ӷ�������ȡsql��������
			PreparedStatement ps = connection.prepareStatement(sql);
			// ע����� ʹ��set����ע�� ��һ��������ʾ���ǵڼ���ռλ��
			ps.setString(1, manager.getE_name());
			ps.setString(2, manager.getE_password());
			// 3��ִ��SQL ͨ��executeQuery����ִ�в�ѯ���,���ؽ��������
			ResultSet rs = ps.executeQuery();
			// 4��������������ӽ�����л�ȡ����
			while (rs.next()) {// �ж��Ƿ�����һ�����ݣ���������ȡ
				// ʹ��get�����������ֶ�������ȡ����
				int e_id = rs.getInt("e_id");
				String e_name = rs.getString("e_name");
				String e_password = rs.getString("e_password");
				// ��װ��������
				Manager managerLogin = new Manager(e_id, e_name, e_password);
				// ����manager
				return managerLogin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ���ؿ�
		return null;
	}

	// ��ѯչʾ���еĹ���Ա����
	public List<Manager> queryManager() {
		List<Manager> list = new ArrayList<>();
		// 1������sql��� ռλ��?��ʾһ����̬�������
		String sql = "select * from manager";
		try {
			// 2��ͨ�����Ӷ�������ȡsql��������
			PreparedStatement ps = connection.prepareStatement(sql);
			// 3��ִ��SQL ͨ��executeQuery����ִ�в�ѯ���,���ؽ��������
			ResultSet rs = ps.executeQuery();
			// 4��������������ӽ�����л�ȡ����
			while (rs.next()) {// �ж��Ƿ�����һ�����ݣ���������ȡ
				// ʹ��get�����������ֶ�������ȡ����
				int e_id = rs.getInt("e_id");
				String e_name = rs.getString("e_name");
				String e_password = rs.getString("e_password");
				// ��װ��������
				Manager manager = new Manager(e_id, e_name, e_password);
				// �Ѷ�����ӵ�������
				list.add(manager);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ���ؼ��϶���
		return list;
	}

	// ��ӹ���Ա����
	public boolean insertManager(Manager manager) {
		// 1������sql��� ռλ��?��ʾһ����̬�������
		String sql = "insert into manager(e_name,e_password) values(?,?)";
		try {
			// 2��ͨ�����Ӷ�������ȡsql��������
			PreparedStatement ps = connection.prepareStatement(sql);
			// 3��ע����� ʹ��set����ע�� ��һ��������ʾ���ǵڼ���ռλ��
			ps.setString(1, manager.getE_name());
			ps.setString(2, manager.getE_password());
			// 4��ִ��SQL ��ӡ�ɾ�����޸Ķ�����ʹ��executeUpdateִ��
			int ret = ps.executeUpdate();
			if (ret > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// �޸Ĺ���Ա����
	public boolean updateManager(Manager manager) {
		// 1������sql��� ռλ��?��ʾһ����̬�������
		String sql = "update manager set e_name=?,e_password=? where e_id=?";
		try {
			// 2��ͨ�����Ӷ�������ȡsql��������
			PreparedStatement ps = connection.prepareStatement(sql);
			// 3��ע����� ʹ��set����ע�� ��һ��������ʾ���ǵڼ���ռλ��
			ps.setString(1, manager.getE_name());
			ps.setString(2, manager.getE_password());
			ps.setInt(3, manager.getE_id());
			// 4��ִ��SQL ��ӡ�ɾ�����޸Ķ�����ʹ��executeUpdateִ��
			int ret = ps.executeUpdate();
			if (ret > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// ɾ������Ա����
	public boolean deleteManager(int id) {
		// 1������sql��� ռλ��?��ʾһ����̬�������
		String sql = "delete from manager where e_id=?";
		try {
			// 2��ͨ�����Ӷ�������ȡsql��������
			PreparedStatement ps = connection.prepareStatement(sql);
			// 3��ע����� ʹ��set����ע�� ��һ��������ʾ���ǵڼ���ռλ��
			ps.setInt(1, id);
			// 4��ִ��SQL ��ӡ�ɾ�����޸Ķ�����ʹ��executeUpdateִ��
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
