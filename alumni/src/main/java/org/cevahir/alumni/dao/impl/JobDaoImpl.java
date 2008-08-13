package org.cevahir.alumni.dao.impl;

import org.cevahir.alumni.dao.JobDao;
import org.cevahir.alumni.model.Job;

public class JobDaoImpl extends GenericDaoImpl<Job> implements JobDao {

	@Override
	protected Class<Job> getPersistentClass() {
		return Job.class;
	}

}
