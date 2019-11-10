package cn.ybzy.mvcproject.service;

import java.util.List;

import cn.ybzy.mvcproject.model.User;

public interface UserService {
	/**
	 * ʵ�ֲ���һ�����û���Ϣ����
	 * 
	 * @param user
	 * @return
	 */
	public int save(User user);

	/**
	 * �����û����ɾ����Ӧ�û�����
	 * 
	 * @param id
	 * @return
	 */
	public int deleteUserById(int id);

	/**
	 * �����û�id�޸��û���Ϣ����
	 * 
	 * @param id
	 * @return
	 */
	public int updateUserById(User user);

	/**
	 * �����û���Ż�ȡһ���û����ݣ���װ����User��һ������
	 * 
	 * @param id
	 * @return
	 */
	public User get(int id);

	/**
	 * ֧�������
	 * 
	 * @param conn
	 * @param id
	 * @return
	 */
	public User getTransation(int id);

	/**
	 * ��ȡ�����û�����
	 * 
	 * @return
	 */
	public List<User> getListAll();

	/**
	 * ��ѯָ���û������û��ж�����
	 * 
	 * @param username
	 * @return
	 */
	public long getCountByName(String username);

	/**
	 * �����û�ģ����ѯ�ķ���
	 * 
	 * @param username
	 * @param address
	 * @param phoneNo
	 * @return
	 */
	public List<User> query(String username, String address, String phoneNo);
}
