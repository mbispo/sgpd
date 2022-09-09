package br.jus.tjms.sgpd.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.google.common.base.Preconditions;


/**
 * @author marcos
 * @version 1.0
 * @created 03-ago-2015 14:44:38
 */
@SuppressWarnings("unchecked")
public abstract class GenericService<T, PK> {
	
	@PersistenceContext
	EntityManager em;

	public T criar(T object) {
		em.persist(object);
		return object;
	}

	public T salvar(T object) {
		return em.merge(object);
	}

	public void excluir(T object) {
		em.remove(object);		
	}
	
	public List<T> buscarTodos() {
		Session session = (Session) em.getDelegate();
		Criteria crit = session.createCriteria((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		return crit.list();		
	}

	public T buscarPorId(PK id) {
		Preconditions.checkNotNull(id, "id é obrigatório");
		return em.find((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0], id);
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
}