package com.inc.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.inc.dao.UserDao;
import com.inc.model.LocalAuth;
import com.inc.model.User;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {
	
	@Resource(name = "sessionFactory")
	private SessionFactory sf; 
	
	@Override
	public User getUser(String name, String password) {
		String hql = "from LocalAuth where username = :name and password = :password";
		LocalAuth auth = (LocalAuth) sf.getCurrentSession().createQuery(hql).setParameter("name", name).setParameter("password", password).uniqueResult();
		return auth.getUser();
	}
}
