package org.cevahir.alumni.dao.impl;

import org.cevahir.alumni.dao.MailDao;
import org.cevahir.alumni.model.Mail;

public class MailDaoImpl extends GenericDaoImpl<Mail> implements MailDao {

	@Override
	protected Class<Mail> getPersistentClass() {
		return Mail.class;
	}

}
