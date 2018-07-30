package com.cg.demo.dao;

import java.util.List;

import com.cg.demo.data.Department;
import com.cg.demo.data.Employee;
import com.cg.demo.data.EmployeeDetails;

public interface DemoInventoryDAO {
//inventoryDAO
	public Employee getDetails(Employee emp);
	public List<Employee> getAllDetails();
	public Employee updateData(Employee  emp);
	public EmployeeDetails getData(Department dept);
	public Employee insertData(Employee emp);
	public void deleteData(Employee emp);
}
