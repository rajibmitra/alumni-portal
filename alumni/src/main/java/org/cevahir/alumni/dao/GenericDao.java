package org.cevahir.alumni.dao;

import java.util.List;

import org.cevahir.alumni.model.Model;
import org.hibernate.criterion.Criterion;

public interface GenericDao<I extends Model> {
    
	public I findById(Integer id, boolean lock);
	
	public List<I> findAll();
	
	public List<I> findByCriteria(Criterion ... c);
	
	public List<I> findByCriteria(int offset, int limit, Criterion ... c);
	
	public void save(I entity);
	
	public void remove(I entity);

}
