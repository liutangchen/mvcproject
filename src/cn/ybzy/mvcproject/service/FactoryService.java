package cn.ybzy.mvcproject.service;

public class FactoryService {
	public static UserService getUserService() {
		return new UserServiceImpl();
	}
}
