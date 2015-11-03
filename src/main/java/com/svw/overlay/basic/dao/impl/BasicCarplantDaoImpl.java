package com.svw.overlay.basic.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.svw.overlay.basic.dao.BasicCarplantDao;

@Repository("basicCarplantDao")
public class BasicCarplantDaoImpl implements BasicCarplantDao {

	private NamedParameterJdbcTemplate  namedParameterJdbcTemplate ;
    
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public long createBasicCarplant(String code, String name, String address,
			long longtitude, long latitude, String remarks) {
		String sql = "insert into basic_carplant(code, name, address,"
				+ "longtitude, latitude, remarks)"
				+ "values(:code, :name, :address, :longtitude, :latitude, :remarks)";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", code);
		map.put("name", name);
		map.put("address", address);
		map.put("longtitude", longtitude);
		map.put("latitude", latitude);
		map.put("remarks", remarks);
		return namedParameterJdbcTemplate.update(sql, map);
	}

	@Override
	public long updateBasicCarplant(long id, String code, String name,
			String address, long longtitude, long latitude, String remarks) {
		String sql = "update basic_carplant set code= :code, name= :name, address= :address,"
				+ "longtitude= :longtitude, latitude= :latitude, remarks= :remarks"
				+ " where id= :id";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", code);
		map.put("name", name);
		map.put("address", address);
		map.put("longtitude", longtitude);
		map.put("latitude", latitude);
		map.put("remarks", remarks);
		map.put("id", id);
		return namedParameterJdbcTemplate.update(sql, map);
	}

	@Override
	public Map<String,Object> queryBasicCarplantById(long id) {
		String sql = "select id, code, name, address, "
				+ "longtitude, latitude, remarks"
				+ " from basic_carplant where id= :id";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		return namedParameterJdbcTemplate.queryForMap(sql, map);
	}

	@Override
	public long deleteBasicCarplantById(long id) {
		String sql = "delete from basic_carplant where id= :id";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		return namedParameterJdbcTemplate.update(sql, map);
	}

	@Override
	public Collection<Map<String,Object>> queryBasicCarplantList(String code,
			String name) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", code);
		map.put("name", name);
		
		String sql = "select id, code, name, address, "
				+ "longtitude, latitude, remarks"
				+ " from basic_carplant where 1=1";
		
		if(code!=null && code.length()>0){
			sql+=" and code like '%"+code+"%'";
		}
        if(name!=null && name.length()>0){
        	sql+=" and name like '%"+name+"%'";
		}
        
		return namedParameterJdbcTemplate.queryForList(sql,map);
	}

}
