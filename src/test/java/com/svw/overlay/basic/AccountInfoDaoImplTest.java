package com.svw.overlay.basic;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.svw.overlay.basic.base.BaseTest;
import com.svw.overlay.basic.dao.AccountInfoDao;

public class AccountInfoDaoImplTest extends BaseTest{
	
	private AccountInfoDao accountInfoDao;
	
	@Before
	public void set(){
		ApplicationContext ctx = getCtx();
		accountInfoDao = ctx.getBean("accountInfoDao",AccountInfoDao.class);
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		jdbcTemplate.update("delete from account_reg");
		final String password = DigestUtils.md5Hex("test1");
		jdbcTemplate.update("insert into account_reg(id,username,password,status,create_time,remarks)"
				+ "values(1,'test1','"+password+"','1','2015-09-11 11:11:11','test')");
	}

	@Test
	public void createAccountInfoTest(){
		final String password = DigestUtils.md5Hex("test");
		final long c =accountInfoDao.createAccountInfo("test", password, 0L, "test");
	    assertEquals(1,c);
	}
	
	@Test
	public void updatePwdTest(){
		final String oldPassword = DigestUtils.md5Hex("test1");
		final String newPassword = DigestUtils.md5Hex("test");
		final long c = accountInfoDao.updatePassword(1L, oldPassword, newPassword, new Date());
		assertEquals(1,c);
	}
	
	@Test
	public void updateStatusTest(){
		final long c = accountInfoDao.updateStatus(1L, 0L, new Date());
		assertEquals(1,c);
	}
	
	@Test
	public void updateRemarksTest(){
		final long c = accountInfoDao.updateRemarks(1L, "test1", new Date());
		assertEquals(1,c);
	}
	
	@Test
	public void deleteAccountInfoByIdTest(){
		final long c = accountInfoDao.deleteAccountInfoById(1L);
		assertEquals(1,c);
	}
	
	@Test
	public void queryAccountInfoByIdTest(){
		final Map<String,Object> map  = accountInfoDao.queryAccountInfoById(1L);
		assertNotNull(map);
	}
	
	@Test
	public void queryAccountInfoListTest(){
		final List<Map<String,Object>> list = accountInfoDao.queryAccountInfoList("t", 0L);
		assertEquals(0,list.size());
	}
	
	
}
