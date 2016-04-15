package com.moke.core.dao.hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.moke.core.dao.Dao;
import com.moke.core.dao.PaginationSupport;

@Repository
public class BaseDaoHibernate extends HibernateDaoSupport implements Dao {
	protected final Log log = LogFactory.getLog(getClass());

	private boolean cacheQueries = false;
	private String queryCacheRegion;

	protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
		HibernateTemplate hibernateTemplate = super.createHibernateTemplate(sessionFactory);
		if (cacheQueries) {
			hibernateTemplate.setCacheQueries(cacheQueries);
			if (queryCacheRegion != null) {
				hibernateTemplate.setQueryCacheRegion(queryCacheRegion);
			}
		}

		return hibernateTemplate;
	}

	public boolean isCacheQueries() {
		return cacheQueries;
	}

	public void setCacheQueries(boolean cacheQueries) {
		this.cacheQueries = cacheQueries;
	}

	public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}

	public void saveObject(Object o) {
		getHibernateTemplate().saveOrUpdate(o);
	}

	public  Object getObject(Class clazz, Serializable id) {
		Object o = getHibernateTemplate().get(clazz, id);

		if (o == null) {
			throw new ObjectRetrievalFailureException(clazz, id);
		}

		return o;
	}

	public List getObjects(Class clazz) {
		return getHibernateTemplate().loadAll(clazz);
	}

	public void removeObject(Class clazz, Serializable id) {
		getHibernateTemplate().delete(getObject(clazz, id));
	}

	public void updateObject(Object object) {
		getHibernateTemplate().update(object);
	}

	public void replicateObject(final Object object) {
		getHibernateTemplate().replicate(object, ReplicationMode.OVERWRITE);
	}

	public void replicateObjects(final Collection objects) {
		getHibernateTemplate().executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				//				checkWriteOperationAllowed(session);
				for (Iterator iterator = objects.iterator(); iterator.hasNext();) {
					session.replicate(iterator.next(), ReplicationMode.OVERWRITE);
				}
				return null;
			}
		});
	}

	public List findByCriteria(DetachedCriteria criteria) {
		return getHibernateTemplate().findByCriteria(criteria);
	}

	public List findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults) {
		return getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}

	public PaginationSupport findPage(final String hql, final int currentPage, final int pageSize, final boolean reCount) {
		return (PaginationSupport) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				String lowerHql = hql.trim().toLowerCase();
				int fromPos = 0;
				if (!lowerHql.startsWith("from ")) {
					fromPos = StringUtils.indexOf(lowerHql, " from ") + 1;
				}
				int orderPos = StringUtils.lastIndexOf(lowerHql, " order ") + 1;
				if (orderPos == 0) {
					orderPos = hql.length();
				}
				String countHql = "select count(*) " + hql.substring(fromPos, orderPos);
				if (countHql.indexOf("fetch") > 0) {
					countHql = countHql.replaceAll(" fetch ", " ");
				}
				int distinctPos = lowerHql.indexOf(" distinct ");
				int totalCount = 0;
				if (reCount) {
					if (distinctPos >= 0 && distinctPos < fromPos) {
						totalCount = session.createQuery(hql).list().size();
					} else {
						Object tempCount = session.createQuery(countHql).uniqueResult();
						if (tempCount != null) {
							totalCount = ((Long) tempCount).intValue();
						}
					}
				}
				int startRow = (currentPage - 1) * pageSize;
				if (startRow < 0) {
					startRow = 0;
				}
				Query query = session.createQuery(hql);
				query.setFirstResult(startRow);
				query.setMaxResults(pageSize);
				List list = query.list();
				return new PaginationSupport(list, totalCount, startRow, pageSize, reCount);
			}
		});
	}

	public PaginationSupport findPage(final String hql, final Map map, final int currentPage, final int pageSize,
			final boolean reCount) {
		return (PaginationSupport) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				String lowerHql = hql.trim().toLowerCase();
				int fromPos = 0;
				if (!lowerHql.startsWith("from ")) {
					fromPos = StringUtils.indexOf(lowerHql, " from ") + 1;
					String temp = hql.substring(0, fromPos);
					while (StringUtils.countMatches(temp, "(") != StringUtils.countMatches(temp, ")")) {
						fromPos = StringUtils.indexOf(lowerHql, " from ", fromPos) + 1;
						temp = hql.substring(0, fromPos);
					}
				}
				int orderPos = StringUtils.lastIndexOf(lowerHql, " order ") + 1;
				if (orderPos == 0) {
					orderPos = hql.length();
				}
				String countHql = "select count(*) " + hql.substring(fromPos, orderPos);
				if (countHql.indexOf("fetch") > 0) {
					countHql = countHql.replaceAll(" fetch ", " ");
				}
				int distinctPos = lowerHql.indexOf(" distinct ");
				int totalCount = 0;
				if (reCount) {
					if (distinctPos >= 0 && distinctPos < fromPos) {
						totalCount = session.createQuery(hql).setProperties(map).list().size();
					} else {
						Object tempCount = session.createQuery(countHql).setProperties(map).uniqueResult();
						if (tempCount != null) {
							totalCount = ((Long) tempCount).intValue();
						}
					}
				}
				int startRow = (currentPage - 1) * pageSize;
				if (startRow < 0)
					startRow = 0;
				Query query = session.createQuery(hql);
				query.setProperties(map);
				query.setFirstResult(startRow);
				query.setMaxResults(pageSize);
				List list = query.list();
				return new PaginationSupport(list, totalCount, startRow, pageSize, reCount);
			}
		});
	}

	public PaginationSupport findPageByCriteria(final DetachedCriteria detachedCriteria, final Order order,
			final int currentPage, final int pageSize, final boolean reCount) {
		return (PaginationSupport) getHibernateTemplate().executeWithNativeSession(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				if (isCacheQueries()) {
					criteria.setCacheable(true);
					if (getQueryCacheRegion() != null) {
						criteria.setCacheRegion(getQueryCacheRegion());
					}
				}
				int totalCount = 0;
				if (reCount) {
					totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
				}
				int startRow = (currentPage - 1) * pageSize;
				criteria.setProjection(null);

				if (null != order) {
					criteria.addOrder(order);
				}
				criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
				List items = criteria.setFirstResult(startRow).setMaxResults(pageSize).list();
				return new PaginationSupport(items, totalCount, startRow, pageSize, reCount);
			}
		});
	}
	
	public PaginationSupport findPageByCriteria(final DetachedCriteria detachedCriteria, final Object orders,
			final int currentPage, final int pageSize, final boolean reCount) {
		return (PaginationSupport) getHibernateTemplate().executeWithNativeSession(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				if (isCacheQueries()) {
					criteria.setCacheable(true);
					if (getQueryCacheRegion() != null) {
						criteria.setCacheRegion(getQueryCacheRegion());
					}
				}
				int totalCount = 0;
				if (reCount) {
					totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
				}
				int startRow = (currentPage - 1) * pageSize;
				criteria.setProjection(null);
				if(orders instanceof Order){
					criteria.addOrder((Order) orders);
				}
				else if(orders instanceof List){
					for (Iterator iterator = ((List)orders).iterator(); iterator.hasNext();) {
						Order order = (Order) iterator.next();
						if (null != order) {
							criteria.addOrder(order);
						}
					}
				}
				List items = criteria.setFirstResult(startRow).setMaxResults(pageSize).list();
				return new PaginationSupport(items, totalCount, startRow, pageSize, reCount);
			}
		});
	}

	public List find(String hql) {
		return getHibernateTemplate().find(hql);
	}

	public List find(final String hql, final Map map) {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				return session.createQuery(hql).setProperties(map).list();
			}
		});
	}

	public List find(String hql, Object value) {
		return getHibernateTemplate().find(hql, value);
	}

	public List find(String hql, Object[] values) {
		return getHibernateTemplate().find(hql, values);
	}

	public PaginationSupport findPageBySql(final String sql, final int currentPage, final int pageSize,
			final boolean reCount) {
		return (PaginationSupport) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				String count_sql = "select count(*) from ( " + sql + " ) result";

				int totalCount = 0;
				if (reCount) {
					List countList = session.createSQLQuery(count_sql).list();
					if (countList != null && countList.size() > 0) {
						Object obj = countList.get(0);
						if (obj != null) {
							totalCount = Integer.parseInt(obj.toString());
						}
					}
				}
				int startRow = (currentPage - 1) * pageSize;
				if (startRow < 0)
					startRow = 0;
				Query query = session.createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				query.setFirstResult(startRow);
				query.setMaxResults(pageSize);
				List list = query.list();
				return new PaginationSupport(list, totalCount, startRow, pageSize, reCount);
			}
		});
	}

	public PaginationSupport findPageBySql(final String sql, final Map map, final int currentPage, final int pageSize,
			final boolean reCount) {
		return (PaginationSupport) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				String count_sql = "select count(*) from ( " + sql + " ) result";

				int totalCount = 0;
				if (reCount) {
					List countList = session.createSQLQuery(count_sql).setProperties(map).list();
					if (countList != null && countList.size() > 0) {
						Object obj = countList.get(0);
						if (obj != null) {
							totalCount = Integer.parseInt(obj.toString());
						}
					}
				}
				int startRow = (currentPage - 1) * pageSize;
				if (startRow < 0)
					startRow = 0;
				Query query = session.createSQLQuery(sql).setProperties(map).setResultTransformer(
						Transformers.ALIAS_TO_ENTITY_MAP);
				query.setFirstResult(startRow);
				query.setMaxResults(pageSize);
				List list = query.list();
				return new PaginationSupport(list, totalCount, startRow, pageSize, reCount);
			}
		});
	}

	public List find(final String hql, final int firstResult, final int maxResults) {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				return session.createQuery(hql).setFirstResult(firstResult).setMaxResults(maxResults).list();
			}
		});
	}
}
