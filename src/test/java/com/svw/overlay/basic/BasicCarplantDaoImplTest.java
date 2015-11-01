package com.svw.overlay.basic;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.svw.overlay.basic.base.BaseTest;
import com.svw.overlay.basic.dao.BasicCarplantDao;

public class BasicCarplantDaoImplTest extends BaseTest {

	private BasicCarplantDao basicCarplantDao;
	
	@Before
	public void set(){
		basicCarplantDao = getCtx().getBean("basicCarplantDao", BasicCarplantDao.class);
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		jdbcTemplate.update("delete from basic_carplant");
		jdbcTemplate.update("insert into basic_carplant(id,code,name,address,longtitude,latitude,remarks)"
				+ "values(1,'cpa1','cpa1','上海安亭','12','12','test')");
	}
	
	@Test
	public void createBasicCarplantTest(){
		long c = basicCarplantDao.createBasicCarplant("cpa2", "cap2", "上海安亭", 12, 12, "test");
	    assertEquals(1,c);
	}
	
	@Test
	public void updateBasicCarplantTest(){
		long c = basicCarplantDao.updateBasicCarplant(1L, "cap3", "cap3", "南昌", 20, 20, "test");
		assertEquals(1,c);
	}
	
	@Test
	public void deleteBasicCarplantByIdTest(){
		long c = basicCarplantDao.deleteBasicCarplantById(1L);
		assertEquals(1,c);
	}
	
	@Test
	public void queryBasicCarplantByIdTest(){
		Map<String,Object> map = basicCarplantDao.queryBasicCarplantById(1L);
		assertNotNull(map);
	}
	
	@Test
	public void queryBasicCarplantListTest(){
		Collection<Map<String,Object>> list = basicCarplantDao.queryBasicCarplantList("c", "c");
		assertEquals(1,list.size());
	}
	
	
}
