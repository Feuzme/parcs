package fr.feuzme.spring.services;

import java.util.List;

public interface GenericService<T> {
	public List<T> findAll();
	public T findById(Integer id);
	public T save(T entity);
	public T update(T entity);
	public void delete(T entity);
}
