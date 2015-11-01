package com.svw.overlay.basic.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.svw.overlay.basic.items.AccountInfo;

public class AccountInfoRowMapper implements RowMapper<AccountInfo> {

	@Override
	public AccountInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setId(rs.getLong("id"));
		accountInfo.setPassword(rs.getString("password"));
		accountInfo.setUsername(rs.getString("username"));
		accountInfo.setCreateTime(rs.getDate("createTime"));
		accountInfo.setUpdateTime(rs.getDate("updateTime"));
		accountInfo.setStatus(rs.getInt("status"));
		accountInfo.setRemarks(rs.getString("remarks"));
		return accountInfo;
	}

}
