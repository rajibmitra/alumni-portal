package org.cevahir.alumni.dao.impl;

import org.cevahir.alumni.dao.UserDao;
import org.cevahir.alumni.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.springframework.dao.DataAccessException;

public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	@Override
	protected Class<User> getPersistentClass() {
		return User.class;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean checkLogin(String login, String password) {
		if (null == login || null == password) {
			throw new IllegalArgumentException(
					"Login and password are mandatory. Null values are forbidden.");
		}
		try {
			logger.info("Check user with login: " + login
					+ " and password : [PROTECTED]");
			// create a new criteria
			Criteria crit = getCurrentSession().createCriteria(User.class);
			crit.add(Expression.ilike("username", login));
			crit.add(Expression.eq("password", password));

			User user = (User) crit.uniqueResult();
			return (user != null);
		} catch (DataAccessException e) {
			// Critical errors : database unreachable, etc.
			logger.error("Exception - DataAccessException occurs : "
					+ e.getMessage() + " on complete checkLogin().");
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public User getUser(String login) {
		if (null == login) {
			throw new IllegalArgumentException(
					"Login is mandatory. Null value is forbidden.");
		}
		try {
			logger.info("get User with login: " + login);
			// create a new criteria
			Criteria crit = getCurrentSession().createCriteria(User.class);
			crit.add(Expression.eq("username", login));

			User user = (User) crit.uniqueResult();
			return user;
		} catch (DataAccessException e) {
			// Critical errors : database unreachable, etc.
			logger.error("Exception - DataAccessException occurs : "
					+ e.getMessage() + " on complete getUser().");
			return null;
		}
	}

}
