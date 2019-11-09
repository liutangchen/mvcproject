package cn.ybzy.mvcproject.test;


import org.junit.jupiter.api.Test;

import cn.ybzy.mvcproject.dao.UserDao;
import cn.ybzy.mvcproject.dao.UserDaoImpl;
import cn.ybzy.mvcproject.model.User;

class UserDaoImplTest {
	UserDao userDao = new UserDaoImpl();
	
	@Test
	void testGetInt() {
		User user = userDao.get(1);
		System.out.println(user);
	}

}
