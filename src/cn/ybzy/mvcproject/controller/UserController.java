package cn.ybzy.mvcproject.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ybzy.mvcproject.model.User;
import cn.ybzy.mvcproject.service.FactoryService;
import cn.ybzy.mvcproject.service.UserService;

public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	UserService userService = FactoryService.getUserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ����һ���������ܴ�����ɾ�Ĳ����еĹ���
		// �����ַ���
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String mn = req.getServletPath();
		mn = mn.substring(1);
		mn = mn.substring(0, mn.length() - 4);
		try {
			Method method = this.getClass().getDeclaredMethod(mn, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		String username = req.getParameter("username");
		long cout = userService.getCountByName(username);
		if (cout > 0) {
			req.setAttribute("reminder","�û����Ѵ��ڣ�");
			req.getRequestDispatcher("/add.jsp").forward(req,resp);
			return;
		}
		user.setUsername(username);
		user.setPasword(req.getParameter("pasword"));
		user.setAddress(req.getParameter("address"));
		user.setPhoneNo(req.getParameter("phoneNo"));
		user.setRegDate(new Date());
		int rows = userService.save(user);
		if (rows > 0) {
			resp.sendRedirect(req.getContextPath() + "/index.jsp");
		} else {
			resp.sendRedirect(req.getContextPath() + "/error.jsp");
		}
	}

	/**
	 * ʵ����ҳҳ���ģ����ѯ
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String address = req.getParameter("address");
		String phoneNo = req.getParameter("phoneNo");
		username = username.replaceAll("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~��@#��%����&*��������+|{}������������������������]", "");
		address = address.replaceAll("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~��@#��%����&*��������+|{}������������������������]", "");
		phoneNo = phoneNo.replaceAll("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~��@#��%����&*��������+|{}������������������������]", "");
		List<User> list = userService.query(username, address, phoneNo);
		System.out.println(list);
		req.setAttribute("userList", list); // �ѽ�����ŵ�req�����Կռ�
		req.getRequestDispatcher("/index.jsp").forward(req, resp); // ������req��respע��jspҳ��
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		int rows = userService.deleteUserById(id);
		if (rows > 0) {
			resp.sendRedirect(req.getContextPath() + "/index.jsp");
		} else {
			resp.sendRedirect(req.getContextPath() + "/error.jsp");
		}
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		User user = userService.get(id);
		req.setAttribute("user", user);
		req.getRequestDispatcher("/update.jsp").forward(req, resp);
	}
	
	private void updatedo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		//ͨ��id,�õ����ݿ���ԭ��user��Ϣ
		User user = userService.get(id);
		String yUsername = user.getUsername();
		String xUsername = req.getParameter("username");
		long cout = userService.getCountByName(xUsername);
		if (!xUsername.equals(yUsername) && cout > 0) {   //�����������������ֲ�һ�������������ݿ����ҵ�ͬ����¼��֤�������г�ͻ
			req.setAttribute("note", xUsername + ",��������Ѿ���ռ��,�뻻һ������!");
			req.getRequestDispatcher("/update.udo?id=" + id).forward(req, resp);
			return;
		}
		user.setUsername(xUsername);
		user.setPasword(req.getParameter("pasword"));
		user.setAddress(req.getParameter("address"));
		user.setPhoneNo(req.getParameter("phoneNo"));
		int rows = userService.updateUserById(user);
		if (rows > 0) {
			resp.sendRedirect(req.getContextPath() + "/index.jsp");
		} else {
			resp.sendRedirect(req.getContextPath() + "/error.jsp");
		}
	}
}
