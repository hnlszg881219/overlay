package com.svw.overlay.basic.base;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseTest {
	
	private ApplicationContext ctx;
	
	private JdbcTemplate  jdbcTemplate;
	
	public ApplicationContext getCtx(){
		return ctx;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Before
	public void setUp() throws Exception{
		ctx = new ClassPathXmlApplicationContext(new String[]{"configs/spring/applicationContext.xml",
				"configs/spring/applicationContext-datasource.xml"});
		
		Properties properties = new Properties();
		properties.load(ctx.getResource("jdbc1.properties").getInputStream());
		DataSource ds = BasicDataSourceFactory.createDataSource(properties);
		jdbcTemplate = new JdbcTemplate(ds);
	}

}
