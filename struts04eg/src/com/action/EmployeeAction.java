package com.action;

import java.util.List;

import com.bean.Employee;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.service.EmployeeService;
import com.service.IPublicService;

public class EmployeeAction implements ModelDriven<Employee>{
	
	private Employee employee = new Employee();;
	private String path;
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public Employee getModel() {
		return employee;
	}
	
	private IPublicService<Employee> empservice = new EmployeeService();
	
	public String save() {
		try {
			empservice.save(employee);
			path = "list_Employee";
			return "sok";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String list() {
		try {
			List<Employee> list = empservice.findAll();
			ActionContext.getContext().put("list", list);
			path = "WEB-INF/list.jsp";
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String viewUpdate() {
		try {
			int id = employee.getId();
			Employee emp = empservice.findById(id);
			ValueStack vs = ActionContext.getContext().getValueStack();
			vs.push(emp);
			path = "WEB-INF/update.jsp";
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update() {
		try {
			empservice.update(employee);
			return list();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String del() {
		try {
			int id = employee.getId();
			empservice.del(id);
			return list();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
