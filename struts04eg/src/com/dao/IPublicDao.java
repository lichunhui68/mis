package com.dao;

import java.util.List;

public interface IPublicDao<T> {
	public void save(T t);
	public void update(T t);
	public void del(int id);
	
	public T findById(int id);
	public List<T> findAll();
		

}
