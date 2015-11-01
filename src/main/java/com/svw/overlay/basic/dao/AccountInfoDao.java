package com.svw.overlay.basic.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AccountInfoDao {
	
	int createAccountInfo(String username,String password,Long status,String remarks);
	
	int updatePassword(Long id,String oldPassword,String newPassword,Date updateTime);
	
	int updateStatus(Long id,Long status,Date updateTime);
	
	int updateRemarks(Long id,String remarks,Date updateTime);
	
	int deleteAccountInfoById(Long id);
	
	Map<String,Object> queryAccountInfoById(Long id);
	
	List<Map<String,Object>> queryAccountInfoList(String username,Long status);

}
