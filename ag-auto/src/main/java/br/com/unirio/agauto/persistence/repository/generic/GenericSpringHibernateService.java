package br.com.unirio.agauto.persistence.repository.generic;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class GenericSpringHibernateService<T extends Serializable, TPk extends Serializable> {

	private static final Logger	LOGGER	= LoggerFactory.getLogger(GenericSpringHibernateService.class);

	private Class<T>						clazz;

	@PersistenceContext
	private EntityManager				em;

	protected void setClazz(final Class<T> clazzToSet) {
		clazz = clazzToSet;
	}

	@Transactional(readOnly = true)
	public T findOne(final TPk entityId) {
		assert (entityId != null);
		return ((T) getEntityManager().find(clazz, entityId));
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findAll(int offset, int limit) {
		return getEntityManager().createQuery("from " + clazz.getName()).setFirstResult(offset).setMaxResults(limit).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findAll(String orderBy) {
		return getEntityManager().createQuery("from " + clazz.getName() + " ORDER BY " + orderBy).getResultList();
	}

	@Transactional
	public void save(final T entity) {
		assert (entity != null);
		getEntityManager().persist(entity);
	}

	@Transactional
	public void merge(final T entity) {
		assert (entity != null);
		getEntityManager().merge(entity);
	}

	@Transactional
	public void delete(final T entity) {
		assert (entity != null);
		getEntityManager().remove(entity);
	}

	@Transactional
	public void flush() {
		getEntityManager().flush();
	}

	@Transactional
	public void detach(final T entity) {
		getEntityManager().detach(entity);
	}

	@Transactional
	public void deleteById(final TPk entityId) {
		final T entity = findOne(entityId);
		assert (entity != null);
		delete(entity);
	}

	public int executeUpdate(final Query query) {
		return query.executeUpdate();
	}

	/**
	 * Executa um update de acordo com a query.
	 * 
	 * @param namedQuery
	 * @param parameters
	 * @return
	 */
	public int executeUpdate(final String namedQuery, final Map<String, Object> parameters) {
		return executeUpdate(createNamedQuery(namedQuery, parameters));
	}

	protected int executeSqlQueryUpdate(final String query) {
		return getEntityManager().createNativeQuery(query).executeUpdate();
	}

	/**
	 * Retorna um objeto atraves de uma named query.
	 * 
	 * @param namedQuery
	 * @param parameters
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	protected T getByNamedQuery(final String namedQuery, final Map<String, Object> parameters) {
		try {
			return (T) this.createNamedQuery(namedQuery, parameters).getSingleResult();
		}
		catch (NoResultException ex) {
			return null;
		}
	}

	/**
	 * Retorna um objeto atraves de uma named query.
	 * 
	 * @param namedQuery
	 * @param parameters
	 * @param maxResult
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	protected T getByNamedQuery(final String namedQuery, final Map<String, Object> parameters, int maxResult) {
		try {
			return (T) this.createNamedQuery(namedQuery, parameters).setMaxResults(maxResult).getSingleResult();
		}
		catch (NoResultException ex) {
			return null;
		}
	}

	/**
	 * Retorna um objeto atraves de uma query nativa.
	 * 
	 * @param sqlQuery
	 * @param parameters
	 * @return
	 */
	@Transactional(readOnly = true)
	protected Object getBySqlQuery(final String sqlQuery, final Map<String, Object> parameters) {
		try {
			return this.createNativeQuery(sqlQuery, parameters).getSingleResult();
		}
		catch (NoResultException ex) {
			return null;
		}
	}

	/**
	 * Retorna um objeto atraves de uma query HQL.
	 * 
	 * @param query
	 * @param parameters
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	protected T getByQuery(final String query, final Map<String, Object> parameters) {
		try {
			return (T) this.createQuery(query, parameters).getSingleResult();
		}
		catch (NoResultException ex) {
			return null;
		}
	}

	/**
	 * Retorna uma lista de objetos atraves de uma named query.
	 * 
	 * @param namedQuery
	 * @param parameters
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	protected List<T> getListByNamedQuery(final String namedQuery, final Map<String, Object> parameters) {
		return (List<T>) this.createNamedQuery(namedQuery, parameters).getResultList();
	}

	/**
	 * Retunrs an object list usign a namedquery, you also must define a offset and a limit
	 * 
	 * @param namedQuery
	 * @param parameters
	 * @param offset
	 * @param maxResult
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	protected List<T> getListByNamedQuery(final String namedQuery, final Map<String, Object> parameters, int offset, int maxResult) {
		return (List<T>) this.createNamedQuery(namedQuery, parameters).setFirstResult(offset).setMaxResults(maxResult).getResultList();
	}

	/**
	 * Retorna uma lista de objetos atraves de uma query nativa.
	 * 
	 * @param sqlQuery
	 * @param parameters
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	protected List<T> getListBySqlQuery(final String sqlQuery, final Map<String, Object> parameters) {
		return (List<T>) this.createNativeQuery(sqlQuery, parameters).getResultList();
	}

	/**
	 * Retorna uma lista de objetos atraves de uma query HQL.
	 * 
	 * @param query
	 * @param parameters
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	protected List<T> getListByQuery(final String query, final Map<String, Object> parameters) {
		return (List<T>) this.createQuery(query, parameters).getResultList();
	}

	/**
	 * 
	 * @param query
	 * @param parameters
	 * @return
	 */
	private Query setQueryParameters(final Query query, final Map<String, Object> map) {
		for (String key : map.keySet()) {
			query.setParameter(key, map.get(key));
		}
		return query;
	}

	/**
	 * 
	 * @param namedQuery
	 * @param parameters
	 * @return
	 */
	protected Query createNamedQuery(final String namedQuery, final Map<String, Object> parameters) {
		EntityManager em = getEntityManager();
		Query sessionQuery = em.createNamedQuery(namedQuery);
		return setQueryParameters(sessionQuery, parameters);
	}

	/**
	 * 
	 * @param query
	 * @param parameters
	 * @return
	 */
	private Query createNativeQuery(final String query, final Map<String, Object> parameters) {
		EntityManager em = getEntityManager();
		Query sessionQuery = em.createNativeQuery(query);
		return setQueryParameters(sessionQuery, parameters);
	}

	/**
	 * 
	 * @param query
	 * @param parameters
	 * @return
	 */
	private Query createQuery(final String query, final Map<String, Object> parameters) {
		EntityManager em = getEntityManager();
		Query sessionQuery = em.createQuery(query);
		return setQueryParameters(sessionQuery, parameters);
	}

	@Transactional(readOnly = true)
	protected int countNative(final String query, final Map<String, Object> parameters) {
		return ((Long) createQuery(query, parameters).getSingleResult()).intValue();
	}

	@Transactional(readOnly = true)
	protected int count(final String namedQuery, final Map<String, Object> parameters) {
		return ((Long) this.createNamedQuery(namedQuery, parameters).getSingleResult()).intValue();
	}

	private EntityManager getEntityManager() {
		return em;
	}

	public void close() {
		LOGGER.info("Closing DB connections");
		em.clear();
		em.close();
	}
}
