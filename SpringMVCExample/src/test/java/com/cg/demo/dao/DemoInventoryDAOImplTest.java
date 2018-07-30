package com.cg.demo.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.extension.listener.AnnotationEnabler;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PowerMockListener;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import static org.powermock.api.easymock.PowerMock.resetAll;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.demo.config.DaoTestConfig;
import com.cg.demo.dao.DemoInventoryDAOImpl;
import com.cg.demo.data.Department;
import com.cg.demo.data.Employee;
import com.cg.demo.data.EmployeeDetails;


@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
//@PowerMockIgnore({ "javax.management.*" })
@ContextConfiguration(classes = DaoTestConfig.class)
@PowerMockListener(AnnotationEnabler.class)
public class DemoInventoryDAOImplTest {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DemoInventoryDAOImpl inventoryDAO;
	
	@Before
	public void setUp() throws Exception {
		resetAll(jdbcTemplate);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetAllDetails() {
		
		List<Map<String, Object>> empList = new ArrayList();
		Map<String, Object> m = new HashMap<String, Object>() ;
		
		int employeeId = 456;
		String firstName = "Babitha";
		String lastName = "Nadar";
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		
		m.put("employeeId", 456);
		m.put("firstName", "Babitha");
		m.put("lastName", "Nadar");
		
		empList.add(m);
		
		EasyMock.expect(jdbcTemplate.queryForList(EasyMock.anyString())).andReturn(empList);
		PowerMock.replayAll();
		
		List<Employee> eList = inventoryDAO.getAllDetails();
		Assert.assertEquals(1, eList.size());
		Assert.assertNotNull(eList);
	}
	
	@Test
	public void testInsertData() {
		int employeeId = 123;
		String firstName = "Manali";
		String lastName = "Kadam";
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		
		Integer flag = 1;
		
		EasyMock.expect(jdbcTemplate.update(EasyMock.anyString(), EasyMock.anyString(), EasyMock.anyString(), EasyMock.anyString())).andReturn(flag);
		PowerMock.replayAll();
		
		Employee eResult = inventoryDAO.insertData(employee);
		Assert.assertNotNull(eResult);
	
	}
	
	@Test
	public void testGetData()
	{
		int employeeId = 789;
		String firstName = "Jyoti";
		String lastName = "Mane";
		String deptName = "Disney";
		int deptId = 13;
		
		Department dept = new Department();
		dept.setDeptId(deptId);
		
		EmployeeDetails empDetail = new EmployeeDetails();
		empDetail.setDeptId(deptId);
		empDetail.setDeptName(deptName);
		empDetail.setEmployeeId(employeeId);
		empDetail.setFirstName(firstName);
		empDetail.setLastName(lastName);
		
		List<EmployeeDetails> empDetailList = new ArrayList<EmployeeDetails>();
		empDetailList.add(empDetail);
		EasyMock.expect(jdbcTemplate.queryForObject(EasyMock.anyString(), new Object[] {EasyMock.anyString()}, EasyMock.<BeanPropertyRowMapper<EmployeeDetails>> anyObject())).andReturn(empDetail);
		//EasyMock.expect(jdbcTemplate.queryForObject(EasyMock.anyString(), new Object[] {EasyMock.anyString()}, new BeanPropertyRowMapper<EmployeeDetails>())).andReturn(empDetail);
		//EasyMock.expect(jdbcTemplate.queryForObject(EasyMock.anyString(), new Object[] {EasyMock.anyString()}, EasyMock.anyObject(BeanPropertyRowMapper.class))).andReturn(empDetail);
		PowerMock.replayAll();
		
		EmployeeDetails eResult = inventoryDAO.getData(dept);
		Assert.assertNotNull(eResult);
		
	}
} 