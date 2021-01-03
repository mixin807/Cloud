package com.education.service;

import java.util.List;

import com.education.bean.Manager;

public interface ManagerService {
	// ����Ա��¼����
	public Manager managerLogin(Manager manager);

	// ��ѯ���еĹ���Ա����
	public List<Manager> queryManager();

	// ������ݵķ���
	public boolean insertManager(Manager manager);

	// �޸����ݵķ���
	public boolean updateManager(Manager manager);

	// ɾ�����ݵķ���
	public boolean deleteManager(int id);

	// ����id��ѯ���ݵķ���
	public Manager queryManagerById(int id);

}
