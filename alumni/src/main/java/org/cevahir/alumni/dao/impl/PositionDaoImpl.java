package org.cevahir.alumni.dao.impl;

import org.cevahir.alumni.dao.PositionDao;
import org.cevahir.alumni.model.Position;

public class PositionDaoImpl extends GenericDaoImpl<Position> implements PositionDao {

	@Override
	protected Class<Position> getPersistentClass() {
		return Position.class;
	}

}
