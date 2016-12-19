package com.inc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inc.dao.UserDao;
import com.inc.model.User;
import com.inc.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;
	
	@Override
	public User getUser(String name, String password) {
		return userDao.getUser(name, password);
	}
}
