package com.ce.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDao<T> extends HibernateDaoSupport implements IBaseDao<T>{
	
	@Resource(name="sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	private Class<T> clz;
	
	@SuppressWarnings("unchecked")
	public Class<T> getClz() {
		if(clz==null) {
			
			clz = ((Class<T>)
					(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}

	@Override
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void delete(int id) {
		this.getHibernateTemplate().delete(this.load(id));
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public T load(int id) {

		return this.getHibernateTemplate().get(getClz(), id);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(String hql, Object[] args) {
		Query u = this.getSession().createQuery(hql);
		for(int i=0;i<args.length;i++) {
			u.setParameter(0, args[0]);
		}
		List<T> list = u.list();
		return list;
	}

	@Override
	public List<T> list(String hql) {
		return this.list(hql,null);
	}

	@Override
	public List<T> list(String hql, Object arg) {
		return this.list(hql,new Object[]{arg});
	}
}
