package cn.ybzy.mvcproject.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mn = req.getServletPath();
		mn = mn.substring(1);
		mn = mn.substring(0,mn.length()-4);
		try {
			Method method = this.getClass().getDeclaredMethod(mn, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("query1111");
	}
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
