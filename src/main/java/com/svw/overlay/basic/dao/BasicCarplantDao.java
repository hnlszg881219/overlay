package com.svw.overlay.basic.dao;

import java.util.Collection;

import com.svw.overlay.basic.items.BasicCarplant;

public interface BasicCarplantDao {
	
    long createBasicCarplant(String code,
			String name, String address,
			long longtitude, long latitude, String remarks);
	
    long updateBasicCarplant(String id,String code,
			String name, String address, long longtitude,
			long latitude, String remarks);
    
    BasicCarplant queryBasicCarplantById(long id);
		
    long deleteBasicCarplantById(long id);
    
    Collection<BasicCarplant> queryBasicCarplantList(String code, String name);

}
