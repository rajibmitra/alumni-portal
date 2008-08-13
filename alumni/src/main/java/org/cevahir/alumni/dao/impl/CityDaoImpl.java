package org.cevahir.alumni.dao.impl;

import org.cevahir.alumni.dao.CityDao;
import org.cevahir.alumni.model.City;

public class CityDaoImpl extends GenericDaoImpl<City> implements CityDao {

	@Override
	protected Class<City> getPersistentClass() {
		return City.class;
	}

}
