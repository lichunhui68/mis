package com.service;

import java.util.List;

public interface IPublicService<T> {
	public void save(T t);
	public void update(T t);
	public void del(int id);
	
	public T findById(int id);
	public List<T> findAll();
		

}
