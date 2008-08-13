package org.cevahir.alumni.dao;

import org.cevahir.alumni.model.User;

public interface UserDao extends GenericDao<User> {
	
	public boolean checkLogin(String login, String password);
	
    public User getUser(String login);
	
}
