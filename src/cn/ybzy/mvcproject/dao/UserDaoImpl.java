package cn.ybzy.mvcproject.dao;

import java.util.List;

import cn.ybzy.mvcproject.model.User;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public int save(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUserById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUserById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User get(int id) {
		String sql = "SELECT\r\n" + 
				"users.id,\r\n" + 
				"users.username,\r\n" + 
				"users.pasword,\r\n" + 
				"users.phone_no AS phoneNo,\r\n" + 
				"users.address,\r\n" + 
				"users.reg_date AS regDate\r\n" + 
				"FROM\r\n" + 
				"users\r\n" + 
				"WHERE\r\n" + 
				"id = ?;\r\n" + 
				"";
		return super.get(sql, id);
	}

	@Override
	public List<User> getListAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountByName(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

}
