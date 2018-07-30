package com.cg.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.demo.dao.DemoInventoryDAO;
import com.cg.demo.data.Department;
import com.cg.demo.data.Employee;
import com.cg.demo.data.EmployeeDetails;

@Service
@Transactional
public class DemoInventoryServiceImpl implements DemoInventoryService{

	@Autowired
	DemoInventoryDAO inventoryDAO;
	
	public Employee getDetails(Employee emp) {
		
		return inventoryDAO.getDetails(emp);
	}

	public List<Employee> getAllDetails() {
		
		return inventoryDAO.getAllDetails();
	}

	public Employee updateData(Employee emp) {
		
		return inventoryDAO.updateData(emp);
	}

	public EmployeeDetails getData(Department dept) {
		return inventoryDAO.getData(dept);
	}

	public Employee insertData(Employee emp) {
		
		return inventoryDAO.insertData(emp);
	}

	public void deleteData(Employee emp) {
		
		inventoryDAO.deleteData(emp);
	}

	

}
