package cn.ybzy.mvcproject.test;


import java.sql.Connection;

import org.junit.jupiter.api.Test;

import cn.ybzy.mvcproject.utils.JdbcUtils;

class JdbcUtilsTest {

	@Test
	void testGetConnection() {
		Connection conn = JdbcUtils.getConnection();
		System.out.println(conn);
	}

}
