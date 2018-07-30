package com.cg.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cg.demo.data.Department;
import com.cg.demo.data.Employee;
import com.cg.demo.data.EmployeeDetails;

@Repository
public class DemoInventoryDAOImpl implements DemoInventoryDAO{

	private static final String SELECT_ONE_QUERY = "select EmployeeId, FirstName, LastName from organization.employee e where e.EmployeeId= ?";
	private static final String SELECT_ALL_QUERY = "select * from organization.employee ";
	private static final String UPDATE_QUERY = "update organization.employee emp set emp.FirstName = ?, emp.LastName = ? where emp.EmployeeId = ? ";
	private static final String SELECT_QUERY = "select e.EmployeeId, e.FirstName, e.LastName, d.deptId, d.deptName from organization.employee e natural join organization.department d where d.deptId = ? ";
	private static final String DELETE_QUERY = "delete from organization.employee where EmployeeId = ?";
	private static final String INSERT_QUERY = "insert into employee(EmployeeId, FirstName, LastName) values(?,?,?)";
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final Logger logger = Logger.getLogger(DemoInventoryDAOImpl.class);
	
	public Employee insertData(Employee emp) {
		logger.info("\n Inserting Data...");
	    jdbcTemplate.update(INSERT_QUERY, emp.getEmployeeId(), emp.getFirstName(), emp.getLastName());
	    emp.setMessage("Data inserted successfully");
	    logger.info(emp + emp.getMessage());
	  
	    logger.info("Data inserted...");
	    return emp;
	}
	
	public void deleteData(Employee emp) {
	    jdbcTemplate.update(DELETE_QUERY, emp.getEmployeeId());
	}
	
	public EmployeeDetails getData(Department dept) {
		logger.info("\n Getting Data...");
		EmployeeDetails employee = null;
		employee = jdbcTemplate.queryForObject(SELECT_QUERY, new Object[] { dept.getDeptId()},
				new BeanPropertyRowMapper<EmployeeDetails>(EmployeeDetails.class));
		logger.info(employee);
		logger.info("Got Data...");
		return employee;
	}

	public Employee getDetails(Employee emp) {
		Employee employee = null;
		employee = jdbcTemplate.queryForObject(SELECT_ONE_QUERY, new Object[] { emp.getEmployeeId()},
				new BeanPropertyRowMapper<Employee>(Employee.class));
		return employee;
	}
	
	public List<Employee> getAllDetails() {
		logger.info("\n Getting all details...");
		List<Employee> empList = new ArrayList<Employee>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_ALL_QUERY);

		for (Map<String, Object> row : rows) {
			Employee emp = new Employee();
			emp.setEmployeeId((Integer) row.get("employeeId"));
			emp.setFirstName((String) row.get("firstName"));
			emp.setLastName((String) row.get("lastName"));
			
			empList.add(emp);
		}
		logger.info(empList);
		logger.info("Got all details...");
		return empList;
	}
	
	public Employee updateData(Employee  emp) {
		int response = 0;
		response = jdbcTemplate.update(UPDATE_QUERY, emp.getFirstName(), emp.getLastName(), emp.getEmployeeId());
		if (response > 0)
			emp.setMessage("Data updated successfully");
		else
			emp.setMessage("Data update failed!");
		
		return emp;
	}
}

