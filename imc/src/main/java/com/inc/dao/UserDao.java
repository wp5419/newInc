package com.inc.dao;

import com.inc.model.User;

public interface UserDao {
	public User getUser(String name, String password);
}
