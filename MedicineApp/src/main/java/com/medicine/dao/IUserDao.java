package com.medicine.dao;

import com.medicine.model.User;

public interface IUserDao {
String addUser(User user);
String changePassword(String userId,String password);
int login(String userId,String password);
}
