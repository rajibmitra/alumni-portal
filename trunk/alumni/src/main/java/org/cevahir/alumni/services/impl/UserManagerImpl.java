package org.cevahir.alumni.services.impl;

import org.cevahir.alumni.dao.UserDao;
import org.cevahir.alumni.model.User;
import org.cevahir.alumni.services.UserManager;

public class UserManagerImpl implements UserManager {
	private UserDao userDao = null;

	/**
	 * setter to allows spring to inject userDao implementation
	 * 
	 * @param userDao
	 *            : object (implementation of UserDao interface) to inject.
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean checkLogin(String login, String password) {
		return userDao.checkLogin(login, password);
	}

	/**
	 * {@inheritDoc}
	 */
	public User getUser(String login) {
		return userDao.getUser(login);
	}

}
