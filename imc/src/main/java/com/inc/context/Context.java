package com.inc.context;

import com.inc.model.User;

public class Context {
	public static final ThreadLocal<User> userContext = new ThreadLocal<User>();
	
	public void setUserContext(User user){
		userContext.set(user);
	}
	public User getUserContext(){
		return userContext.get();
	}
	public void removeUser(){
		userContext.remove();
	}
}
