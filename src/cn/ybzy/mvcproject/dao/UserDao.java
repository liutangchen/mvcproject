package cn.ybzy.mvcproject.dao;

import java.util.List;

import cn.ybzy.mvcproject.model.User;

/**
 * 定义与users数据表有关系的操作方法
 * 
 * @author liutangchen
 *
 */
public interface UserDao {
	/**
	 * 实现插入一条新用户信息数据
	 * 
	 * @param user
	 * @return
	 */
	public int save(User user);

	/**
	 * 根据用户编号删除对应用户数据
	 * 
	 * @param id
	 * @return
	 */
	public int deleteUserById(int id);

	/**
	 * 根据用户id修改用户信息数据
	 * 
	 * @param id
	 * @return
	 */
	public int updateUserById(int id);

	/**
	 * 根据用户编号获取一条用户数据，封装成类User的一个对象
	 * 
	 * @param id
	 * @return
	 */
	public User get(int id);

	/**
	 * 获取所有用户数据
	 * 
	 * @return
	 */
	public List<User> getListAll();

	/**
	 * 查询指定用户名的用户有多少条
	 * 
	 * @param username
	 * @return
	 */
	public int getCountByName(String username);
}
