package com.svw.overlay.basic.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.svw.overlay.basic.items.BasicCarplant;

public class BasicCarplantRowMapper implements RowMapper<BasicCarplant>{

	@Override
	public BasicCarplant mapRow(ResultSet rs, int rowNum) throws SQLException {
		BasicCarplant basicCarplant = new BasicCarplant();
		basicCarplant.setId(rs.getLong("id"));
		basicCarplant.setCode(rs.getString("code"));
		basicCarplant.setName(rs.getString("name"));
		basicCarplant.setAddress(rs.getString("address"));
		basicCarplant.setLatitude(rs.getFloat("latitude"));
		basicCarplant.setLongtitude(rs.getFloat("longtitude"));
		basicCarplant.setRemakes(rs.getString("remarks"));
		return basicCarplant;
	}

}
