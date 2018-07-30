package com.cg.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.demo.data.Department;
import com.cg.demo.data.Employee;
import com.cg.demo.data.EmployeeDetails;
import com.cg.demo.service.DemoInventoryService;


@RestController
public class DemoInventoryController {

	@Autowired
	DemoInventoryService inventoryService;

	
	@RequestMapping(value = "/insertData", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getInsertData(@RequestBody Employee employee) {
		return inventoryService.insertData(employee);
	}
	
	@RequestMapping(value = "/deleteData", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void getDeleteData(@RequestBody Employee employee) {
		
		inventoryService.deleteData(employee);
	}

	@RequestMapping(value = "/getDataFromTwoTable", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeDetails getData(@RequestBody Department dept) {
		return inventoryService.getData(dept);
	}
	
	@RequestMapping(value = "/getData", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getData(@RequestBody Employee employee) {
		return inventoryService.getDetails(employee);
	}
	
	@GetMapping(value = "/getAllData", produces ={"Application/json"})
	public ResponseEntity<List<Employee>> getAllData() {
		return new ResponseEntity<List<Employee>>(inventoryService.getAllDetails(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateData", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateData(@RequestBody Employee employee) {
		
		return new ResponseEntity<Employee>(inventoryService.updateData(employee), HttpStatus.OK);
	}
	/*
	 * 
	@RequestMapping(value = "/getData", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getData(@RequestBody Employee emp) {
		
		return inventoryService.getDetails(emp);
	}
	@RequestMapping(value = "/getData", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getData(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(inventoryService.getDetails(employee), HttpStatus.OK);
	}
	 * 
	@Autowired
	ResortHelper resortHelper;
	
	@RequestMapping(value = "/getData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Resort getData() {
		return resortHelper.getResortDetail();
	}
	*/
}
