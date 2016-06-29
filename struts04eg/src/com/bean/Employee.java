package com.bean;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
	
	private int id;
	private String empName;
	private Date workDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	
	
}
