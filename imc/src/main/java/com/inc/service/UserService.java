package com.inc.service;

import com.inc.model.User;

public interface UserService {
	public User getUser(String name, String password);
}
