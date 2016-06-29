package com.service;

import java.util.List;

import com.bean.Employee;
import com.dao.EmployeeDao;
import com.dao.IPublicDao;

public class EmployeeService implements IPublicService<Employee> {
	
	private IPublicDao<Employee> empDao = new EmployeeDao();

	@Override
	public void save(Employee t) {
		try {
			empDao.save(t);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Employee t) {
		try {
			empDao.update(t);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void del(int id) {
		try {
			empDao.del(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Employee findById(int id) {
		try {
			return empDao.findById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Employee> findAll() {
		try {
			return empDao.findAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
}
