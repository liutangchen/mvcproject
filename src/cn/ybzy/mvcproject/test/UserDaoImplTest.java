package cn.ybzy.mvcproject.test;


import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import cn.ybzy.mvcproject.dao.UserDao;
import cn.ybzy.mvcproject.dao.UserDaoImpl;
import cn.ybzy.mvcproject.model.User;
import cn.ybzy.mvcproject.utils.JdbcUtils;

class UserDaoImplTest {
	UserDao userDao = new UserDaoImpl();
	
	@Test
	void testGetInt() {
		Connection conn = JdbcUtils.getConnection();
		User user = null;
		try {
			conn.setAutoCommit(false);
			user = userDao.get(conn, 1);
			conn.commit();
		}catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			JdbcUtils.closeConn(conn);
		}
		System.out.println(user);
	}

}
