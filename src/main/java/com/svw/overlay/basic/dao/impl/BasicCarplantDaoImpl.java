package com.svw.overlay.basic.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.svw.overlay.basic.dao.BasicCarplantDao;
import com.svw.overlay.basic.items.BasicCarplant;
import com.svw.overlay.basic.mappers.BasicCarplantRowMapper;

@Repository("basicCarplantDao")
public class BasicCarplantDaoImpl implements BasicCarplantDao {

    private JdbcTemplate jdbcTemplate;
    
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public long createBasicCarplant(String code, String name, String address,
			long longtitude, long latitude, String remarks) {
		String sql = "insert into basic_carplant(code, name, address,"
				+ "longtitude, latitude, remarks)"
				+ "values(?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, new Object[]{code,name,address
				,longtitude, latitude, remarks});
	}

	@Override
	public long updateBasicCarplant(String id, String code, String name,
			String address, long longtitude, long latitude, String remarks) {
		String sql = "update basic_carplant set code=?, name=?, address=?,"
				+ "longtitude=?, latitude=?, remarks=?"
				+ " where id=?";
		return jdbcTemplate.update(sql, new Object[]{code,name,address
				,longtitude, latitude, remarks, id});
	}

	@Override
	public BasicCarplant queryBasicCarplantById(long id) {
		String sql = "select id, code, name, address, "
				+ "longtitude, latitude, remarks"
				+ " from basic_carplant where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{id},
				new BasicCarplantRowMapper());
	}

	@Override
	public long deleteBasicCarplantById(long id) {
		String sql = "delete from basic_carplant where id=?";
		return jdbcTemplate.update(sql, new Object[]{id});
	}

	@Override
	public Collection<BasicCarplant> queryBasicCarplantList(String code,
			String name) {
		String sql = "select id, code, name, address, "
				+ "longtitude, latitude, remarks"
				+ " from basic_carplant where 1=1";
		List<Object> list = new ArrayList<Object>();
		if(code!=null && code.length()>0){
			sql+=" and code like %?%";
			list.add(code);
		}
		
        if(name!=null && name.length()>0){
        	sql+=" and name like %?%";
        	list.add(name);
		}
        
		return jdbcTemplate.query(sql, list.toArray(),
				new BasicCarplantRowMapper());
	}

}
