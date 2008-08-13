package org.cevahir.alumni.dao.impl;

import org.cevahir.alumni.dao.YearDao;
import org.cevahir.alumni.model.Year;

public class YearDaoImpl extends GenericDaoImpl<Year> implements YearDao {

	@Override
	protected Class<Year> getPersistentClass() {
		return Year.class;
	}

}
