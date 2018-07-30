package com.cg.demo.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import com.cg.demo.dao.DemoInventoryDAOImpl;
import com.cg.demo.data.Employee;
import com.cg.demo.service.DemoInventoryServiceImpl;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DemoInventoryDAOImpl.class)
public class DemoServiceTest {

	@InjectMocks
	DemoInventoryServiceImpl demoSer; 	
	
	@Mock
	DemoInventoryDAOImpl demoDAO;
	
	@Mock
	Employee employee;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
		demoSer = null;
	}
	
	@Test
	public void testGetAllDetails() {
	
		List<Employee> empList = new ArrayList<Employee>();
		Employee e1 = new Employee(123,"Babitha","Nadar");
		empList.add(e1);
		
		Mockito.when(demoDAO.getAllDetails()).thenReturn(empList);
		
		List<Employee> result = demoSer.getAllDetails();
		Assert.assertEquals(result, empList);
		Mockito.verify(demoDAO).getAllDetails();
	}
	
	@Test
	public void testGetDetails() {
		Employee e1 = new Employee();
		e1.setEmployeeId(456);
		Employee e2 = new Employee(456, "Jyoti", "Mane");
		Mockito.when(demoDAO.getDetails(e1)).thenReturn(e2);
		
		Employee result = demoSer.getDetails(e1);
		Assert.assertEquals(result, e2);
		Mockito.verify(demoDAO).getDetails(e1);
	}
	
	@Test
	public void testInsertData(){
		Employee e1 =new Employee(789, "Manali", "Kadam");
		Employee e2 = new Employee(789,"Manali", "Kadam");
		e2.setMessage("Data Inserted");
		Mockito.when(demoDAO.insertData(e1)).thenReturn(e2);
		
		Employee result = demoSer.insertData(e1);
		Assert.assertEquals(result, e2);
		Mockito.verify(demoDAO).insertData(e1);
	}

}
