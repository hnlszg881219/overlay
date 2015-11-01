package com.svw.overlay.basic.dao;

import java.util.Collection;
import java.util.Map;

public interface BasicCarplantDao {
	
    long createBasicCarplant(String code,
			String name, String address,
			long longtitude, long latitude, String remarks);
	
    long updateBasicCarplant(long id,String code,
			String name, String address, long longtitude,
			long latitude, String remarks);
    
    Map<String,Object> queryBasicCarplantById(long id);
		
    long deleteBasicCarplantById(long id);
    
    Collection<Map<String,Object>> queryBasicCarplantList(String code, String name);

}
