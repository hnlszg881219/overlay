package com.svw.overlay.basic.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.svw.overlay.basic.dao.AccountInfoDao;

@Repository("accountInfoDao")
public class AccountInfoDaoImpl implements AccountInfoDao {

    private NamedParameterJdbcTemplate  namedParameterJdbcTemplate ;
    
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public int createAccountInfo(String username, String password, Long status,
			String remarks) {
		String sql = "insert into account_reg(username,password,status,remarks,create_time)"
				+ "values(:username, :password, :status, :remarks, :createTime)";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("username", username);
		map.put("password", password);
		map.put("status", status);
		map.put("remarks", remarks);
		map.put("createTime", new Date());
		return namedParameterJdbcTemplate.update(sql, map);
	}

	@Override
	public int updatePassword(Long id, String oldPassword, String newPassword,Date updateTime) {
		String sql = "update account_reg"
				+ " set password = :newPassword,"
				+ " update_time = :updateTime"
				+ " where id= :id "
				+ "and password= :oldPassword";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("oldPassword", oldPassword);
		map.put("newPassword", newPassword);
		map.put("updateTime", updateTime);
		map.put("id", id);
		return namedParameterJdbcTemplate.update(sql,map);
	}

	@Override
	public int updateStatus(Long id,Long status,Date updateTime) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", status);
		map.put("updateTime", updateTime);
		map.put("id", id);
		String sql = "update account_reg"
				+ " set status = :status,"
				+ " update_time = :updateTime"
				+ " where id= :id";
		return namedParameterJdbcTemplate.update(sql, map);
	}

	@Override
	public int updateRemarks(Long id,String remarks,Date updateTime) {
		String sql = "update account_reg"
				+ " set remarks = :remarks,"
				+ " update_time = :updateTime"
				+ " where id = :id";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("remarks", remarks);
		map.put("updateTime", updateTime);
		map.put("id", id);
		return namedParameterJdbcTemplate.update(sql, map);
	}

	@Override
	public int deleteAccountInfoById(Long id) {
		String sql = "delete from account_reg where id = :id";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		return namedParameterJdbcTemplate.update(sql, map);
	}

	@Override
	public Map<String, Object> queryAccountInfoById(Long id) {
		String sql = "select id,username,status,create_time createTime,"
				+ "update_time updateTime,remarks"
				+ " from account_reg where id = :id";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		return namedParameterJdbcTemplate.queryForMap(sql, map);
	}

	@Override
	public List<Map<String, Object>> queryAccountInfoList(String username,
			Long status) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("username", username);
		map.put("status", status);
		
		StringBuffer sql = new StringBuffer(
				"select id,username,status,create_time createTime,"
				+ "update_time updateTime,remarks"
				+ " from account_reg where 1 = 1");
		
		if(username!=null && !username.isEmpty()){
			sql.append(" and username like '%"+username+"%'");
		}
		if(status!=null){
			sql.append(" and status = :status");
		}
		
		return namedParameterJdbcTemplate.queryForList(sql.toString(), map);
	}

}
