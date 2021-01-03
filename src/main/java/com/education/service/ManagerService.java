package com.education.service;

import java.util.List;

import com.education.bean.Manager;

public interface ManagerService {
	// 管理员登录方法
	public Manager managerLogin(Manager manager);

	// 查询所有的管理员数据
	public List<Manager> queryManager();

	// 添加数据的方法
	public boolean insertManager(Manager manager);

	// 修改数据的方法
	public boolean updateManager(Manager manager);

	// 删除数据的方法
	public boolean deleteManager(int id);

	// 根据id查询数据的方法
	public Manager queryManagerById(int id);

}
