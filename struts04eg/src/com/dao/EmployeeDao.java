package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bean.Employee;
import com.utils.JdbcUtils;

public class EmployeeDao implements IPublicDao<Employee>{

	@Override
	public void save(Employee t) {
		String sql = "insert into employee(empName, workDate) values(?, ?)";
		try {
			JdbcUtils.getQuerrRunner().update(sql, t.getEmpName(), t.getWorkDate());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Employee t) {
		String sql = "update employee set empName = ?, workDate = ? where id = ?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, t.getEmpName(), t.getWorkDate(), t.getId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void del(int id) {
		String sql = "delete from employee where id = ?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Employee findById(int id) {
		String sql = "select * from employee where id = ?";
		try {
			return JdbcUtils.getQuerrRunner().query(
					sql, 
					new BeanHandler<Employee>(Employee.class), 
					id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Employee> findAll() {
		String sql = "select * from employee";
		try {
			return JdbcUtils.getQuerrRunner().query(
					sql, 
					new BeanListHandler<Employee>(Employee.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	

}
