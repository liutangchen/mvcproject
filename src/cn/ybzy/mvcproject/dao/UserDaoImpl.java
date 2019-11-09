package cn.ybzy.mvcproject.dao;

import java.sql.Connection;
import java.util.List;

import cn.ybzy.mvcproject.model.User;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public int save(User user) {
		String sql = "INSERT INTO users(username,pasword,phone_no,address,reg_date) VALUES(?,?,?,?,?);";
		return super.update(sql, user.getUsername(),user.getPasword(),user.getPhoneNo(),user.getAddress(),user.getRegDate());
	}

	@Override
	public int deleteUserById(int id) {
		String sql = "DELETE FROM users where id = ?;";
		return super.update(sql, id);
	}

	@Override
	public int updateUserById(User user) {
		String sql = "UPDATE users set username = ?,pasword = ?,phone_no = ?,address = ? where id = ?;";
		return super.update(sql, user.getUsername(),user.getPasword(),user.getPhoneNo(),user.getAddress(),user.getId());
	}

	@Override
	public User get(int id) {
		String sql = "SELECT\r\n" + "users.id,\r\n" + "users.username,\r\n" + "users.pasword,\r\n"
				+ "users.phone_no AS phoneNo,\r\n" + "users.address,\r\n" + "users.reg_date AS regDate\r\n" + "FROM\r\n"
				+ "users\r\n" + "WHERE\r\n" + "id = ?;\r\n" + "";
		return super.get(sql, id);
	}

	@Override
	public User get(Connection conn, int id) {
		String sql = "SELECT\r\n" + "users.id,\r\n" + "users.username,\r\n" + "users.pasword,\r\n"
				+ "users.phone_no AS phoneNo,\r\n" + "users.address,\r\n" + "users.reg_date AS regDate\r\n" + "FROM\r\n"
				+ "users\r\n" + "WHERE\r\n" + "id = ?;\r\n" + "";
		return super.get(conn, sql, id);
	}

	@Override
	public List<User> getListAll() {
		String sql = "SELECT\r\n" + 
				"users.id,\r\n" + 
				"users.username,\r\n" + 
				"users.pasword,\r\n" + 
				"users.phone_no AS phoneNo,\r\n" + 
				"users.address,\r\n" + 
				"users.reg_date AS regDate\r\n" + 
				"FROM\r\n" + 
				"users\r\n" + 
				"";
		return super.getList(sql);
	}

	@Override
	public int getCountByName(String username) {
		String sql = "SELECT COUNT(id) FROM users where username = ?;";
		return (int) super.getValue(sql, username);
	}

}
