package org.cevahir.alumni.dao.impl;

import java.util.List;

import org.apache.tapestry5.ioc.internal.util.Defense;
import org.cevahir.alumni.dao.GenericDao;
import org.cevahir.alumni.model.Model;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class GenericDaoImpl<I extends Model> extends HibernateDaoSupport implements GenericDao<I> {
	
	protected abstract Class<I> getPersistentClass();

	protected Session getCurrentSession() {
		return getHibernateTemplate().getSessionFactory().getCurrentSession();
	}
	
	public List<I> findByCriteria(Criterion... c) {
		return findByCriteria(0, 0, c);
	}
	
	@SuppressWarnings("unchecked")
	public List<I> findByCriteria(int offset, int limit, Criterion ... c){
		Criteria crit = getCurrentSession().createCriteria(getPersistentClass());
		for (Criterion _c: c) crit.add(_c);
		
		if (limit > 0)
            crit.setMaxResults(limit);

        if (offset > 0)
            crit.setFirstResult(offset);

		return crit.list();
	}

	public List<I> findAll() {
		return findByCriteria();
	}

	@SuppressWarnings("unchecked")
	public I findById(Integer id, boolean lock) {
        Defense.notNull(id, "id");

        if (lock)
            return (I) getCurrentSession().load(getPersistentClass(), id, LockMode.UPGRADE);
        else
            return (I) getCurrentSession().load(getPersistentClass(), id);
	}

	public void save(I entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	public void remove(I entity) {
		getCurrentSession().delete(entity);
	}
}
