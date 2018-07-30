package com.cg.demo.config;

import org.powermock.api.easymock.PowerMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;



@Configuration				//doubt in data and import
@ComponentScan(basePackages = { "com.cg.demo.dao" })
public class DaoTestConfig {
	//DemoInventoryDAO
	/*@Bean
	public DemoInventoryDAOImpl inventoryDAO(){
		return PowerMock.createMock(DemoInventoryDAOImpl.class);
	}*/

	/*@Bean
	public DemoInventoryDAO inventoryDAO(){
		return PowerMock.createMock(DemoInventoryDAO.class);
	}*/
	
	//DemoInventoryDAO
	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		return PowerMock.createMock(JdbcTemplate.class);
	}

}
