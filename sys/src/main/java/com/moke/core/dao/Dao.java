package com.moke.core.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

public interface Dao {

	public List getObjects(Class clazz);

	public Object getObject(Class clazz, Serializable id);

	public void saveObject(Object o);

	public void removeObject(Class clazz, Serializable id);

	public void updateObject(Object o);

	public void replicateObject(Object object);

	public void replicateObjects(Collection objects);

	public List findByCriteria(DetachedCriteria criteria);

	public List findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults);

	public PaginationSupport findPage(final String hql, final int currentPage, final int pageSize, final boolean reCount);

	public PaginationSupport findPage(final String hql, final Map map, final int currentPage, final int pageSize,
			final boolean reCount);

	public PaginationSupport findPageBySql(final String hql, final int currentPage, final int pageSize,
			final boolean reCount);

	public PaginationSupport findPageBySql(final String sql, final Map map, final int currentPage, final int pageSize,
			final boolean reCount);

	public PaginationSupport findPageByCriteria(final DetachedCriteria detachedCriteria, final Order order,
			final int currentPage, final int pageSize, final boolean reCount);

	public <T> List<T> find(String hql);

	public <T> List<T> find(final String hql, final Map<T,T> map);

	public <T> List<T> find(String hql, Object value);

	public <T> List<T> find(String hql, Object[] values);
	
}
