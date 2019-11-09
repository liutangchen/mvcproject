package cn.ybzy.mvcproject.dao;

import java.util.List;

import cn.ybzy.mvcproject.model.User;

/**
 * ������users���ݱ��й�ϵ�Ĳ�������
 * 
 * @author liutangchen
 *
 */
public interface UserDao {
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
	public int updateUserById(int id);

	/**
	 * �����û���Ż�ȡһ���û����ݣ���װ����User��һ������
	 * 
	 * @param id
	 * @return
	 */
	public User get(int id);

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
	public int getCountByName(String username);
}
