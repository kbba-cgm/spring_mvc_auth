package com.spring.app.persistence.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<K extends Serializable, E> {
	@Autowired
	SessionFactory sessionFactory;
	
	private final Class<E> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public E getById(K id) {
		return getSession().get(persistentClass, id);
	}
	
	public Serializable create(E entity) {
		return getSession().save(entity);
	}
	
	public void update(E entity) {
		getSession().update(entity);
	}
	
	public void delete(E entity) {
		getSession().delete(entity);
	}
	
	public void deleteById(K id) {
		getSession().delete(getById(id));
	}
	
}
