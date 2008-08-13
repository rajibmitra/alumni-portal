package org.cevahir.alumni.dao.impl;

import org.cevahir.alumni.dao.LoginLogDao;
import org.cevahir.alumni.model.LoginLog;

public class LoginLogDaoImpl extends GenericDaoImpl<LoginLog> implements LoginLogDao {

	@Override
	protected Class<LoginLog> getPersistentClass() {
		return LoginLog.class;
	}

}
