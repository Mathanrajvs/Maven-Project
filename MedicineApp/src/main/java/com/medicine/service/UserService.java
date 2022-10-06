package com.medicine.service;

import com.medicine.dao.IUserDao;
import com.medicine.dao.UserDao;
import com.medicine.model.User;

public class UserService implements IUserService {
IUserDao userDao=new UserDao();
	@Override
	public String register(User user) {
		return userDao.addUser(user);
	}

	@Override
	public String changePassword(String userId,String password) {
		return userDao.changePassword(userId,password);
	}

	@Override
	public int login(String userId, String password) {
		return userDao.login(userId, password);
	}


}
