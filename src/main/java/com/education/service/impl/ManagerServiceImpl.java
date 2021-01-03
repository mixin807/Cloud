package com.education.service.impl;

import java.util.List;

import com.education.bean.Manager;
import com.education.dao.ManagerDao;
import com.education.service.ManagerService;

//是E_managerService的实现类
public class ManagerServiceImpl implements ManagerService {

	//创建dao层的对象调用数据库的操作方法
	ManagerDao dao = new ManagerDao();
	
	@Override
	public Manager managerLogin(Manager manager) {
		return dao.managerLogin(manager);
	}

	@Override
	public List<Manager> queryManager() {
		return dao.queryManager();
	}

	@Override
	public boolean insertManager(Manager manager) {
		return dao.insertManager(manager);
	}

	@Override
	public boolean updateManager(Manager manager) {
		return dao.updateManager(manager);
	}

	@Override
	public boolean deleteManager(int id) {
		return dao.deleteManager(id);
	}

	@Override
	public Manager queryManagerById(int id) {
		return dao.queryManagerById(id);
	}

}
