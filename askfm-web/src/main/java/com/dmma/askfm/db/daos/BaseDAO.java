package com.dmma.askfm.db.daos;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;


public class BaseDAO <T,  ID extends Serializable>{

	// --- Constants ---
	protected final Logger log;
	protected final Class<T> persistentClass;

	// --- Variables ---
	protected SessionFactory sessionFactory;

	// --- Methods ---
	public BaseDAO(Class<T> persistentClass, Logger log) {
		this.persistentClass = persistentClass;
		this.log = log;
	}
	
	@SuppressWarnings("unchecked")
	public T findById(ID id) {
		Session sesion = sessionFactory.openSession();
		try{
			return (T) sesion.get(persistentClass, id);
		}finally{
			sesion.close();
		}		
	}

	public void saveOrUpdate(T entity) {
		Session sesion = sessionFactory.openSession();
		Transaction tx = sesion.getTransaction();
		try{
			tx.begin();
			sesion.saveOrUpdate(entity);
			tx.commit();
		}catch (RuntimeException e) {
			log.error(e.getMessage(), e);
			tx.rollback();
		}finally{
			sesion.close();
		}		
	}

	
	
	public void delete(T entity) {
		Session sesion = sessionFactory.openSession();
		Transaction tx = sesion.getTransaction();
		try{
			tx.begin();
			sesion.delete(entity);
			tx.commit();
		}catch (RuntimeException e) {
			log.error(e.getMessage(), e);
			tx.rollback();
		}finally{
			sesion.close();
		}	
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Session sesion = sessionFactory.openSession();
		try{
			return sesion.createCriteria(persistentClass)
            .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		}finally{
			sesion.close();
		}
    }
	
	@SuppressWarnings("unchecked")
    public List<ID> findAllIDs() {
		Session sesion = sessionFactory.openSession();
		try{
			 return sesion.createCriteria(persistentClass).setResultTransformer(Criteria.PROJECTION)
             .setProjection(Projections.id()).list();
		}finally{
			sesion.close();
		}
	}
	
	// --- Spring Setters ---
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
