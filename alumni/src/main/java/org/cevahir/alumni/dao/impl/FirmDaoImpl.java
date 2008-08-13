package org.cevahir.alumni.dao.impl;

import org.cevahir.alumni.dao.FirmDao;
import org.cevahir.alumni.model.Firm;

public class FirmDaoImpl extends GenericDaoImpl<Firm> implements FirmDao {

	@Override
	protected Class<Firm> getPersistentClass() {
		return Firm.class;
	}

}
