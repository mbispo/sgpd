package br.jus.tjms.sgpd.repository;

import java.io.Serializable;
import java.util.List;

/**
 * @version 1.0
 * @created 11-dez-2015 18:15:45
 */
public interface Repository extends Serializable {

	/**
	 * 
	 * @param entity
	 */
	public void create(Object entity);

	/**
	 * 
	 * @param id
	 */
	public Object restore(Object id);

	/**
	 * 
	 * @param entity
	 */
	public void update(Object entity);

	/**
	 * 
	 * @param entity
	 */
	public void delete(Object entity);

	/**
	 * 
	 * @param id
	 */
	public Object find(Object id);


	public List<Object> findAll();

	/**
	 * 
	 * @param example
	 */
	public List<Object> findByExample(Object example);

}