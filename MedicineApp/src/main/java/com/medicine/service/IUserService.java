package com.medicine.service;

import com.medicine.model.User;

public interface IUserService {
public String register(User user);
public String changePassword(String userId,String password);
int login(String userId,String password);
}
