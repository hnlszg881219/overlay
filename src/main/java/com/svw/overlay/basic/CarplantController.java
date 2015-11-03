package com.svw.overlay.basic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svw.overlay.basic.dao.BasicCarplantDao;

@Controller
@RequestMapping("/services/carplant")
public class CarplantController {
	
	private BasicCarplantDao basicCarplantDao;
	
	@Autowired
	public void setBasicCarplantDao(BasicCarplantDao basicCarplantDao) {
		this.basicCarplantDao = basicCarplantDao;
	}

	
	/**
	 * ��������������Ϣ
	 * 
	 * @param code
	 *         ����
	 * @param name
	 *         ����
	 * @param address
	 *         ��ַ
	 * @param longtitude
	 *         ����
	 * @param latitude
	 *         γ��
	 * @param remarks
	 *         ��ע
	 * @return
	 *       �����ɹ���
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody long createBasicCarplant(@RequestParam("code") String code,
			@RequestParam("name") String name, @RequestParam("address") String address,
			@RequestParam(value="longtitude", required=false, defaultValue="0") long longtitude,
			@RequestParam(value="latitude", required=false, defaultValue="0") long latitude,
			@RequestParam(value="remarks", required=false, defaultValue="") String remarks){
		
		return basicCarplantDao.createBasicCarplant(code, name, address,
				longtitude, latitude, remarks);
	}
	
	
	/**
	 * ���¹���������Ϣ
	 * 
	 * @param id
	 *         
	 * @param code
	 *        ��������
	 * @param name
	 *        ��������
	 * @param address
	 *        ��ַ
	 * @param longtitude
	 *        ����
	 * @param latitude
	 *        γ��
	 * @param remarks
	 *        ��ע
	 * @return
	 *       ��������
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.POST)
	public @ResponseBody long updateBasicCarplant(@PathVariable("id") long id,
			@RequestParam("code") String code,
			@RequestParam("name") String name, @RequestParam("address") String address,
			@RequestParam(value="longtitude", required=false, defaultValue="0") long longtitude,
			@RequestParam(value="latitude", required=false, defaultValue="0") long latitude,
			@RequestParam(value="remarks", required=false, defaultValue="") String remarks){
	  return basicCarplantDao.updateBasicCarplant(id, code, name, address,
			  longtitude, latitude, remarks);
		
	}
	
	
	/**
	 * ͨ��id��ѯ������Ϣ
	 * 
	 * @param id
	 * 
	 * @return
	 *       ������Ϣ
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<Map<String,Object>> queryBasicCarplantById(@PathVariable("id") long id){
		try {
			return new ResponseEntity<Map<String, Object>>(
					basicCarplantDao.queryBasicCarplantById(id), HttpStatus.OK);
		} catch (DataAccessException e) {
			return new ResponseEntity<Map<String, Object>>(
					new HashMap<String, Object>(), HttpStatus.OK);
		}
    }
	
	
	/**
	 * ͨ��idɾ��������Ϣ
	 * @param id
	 * 
	 * @return
	 *        ɾ������
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public @ResponseBody long deleteBasicCarplantById(@PathVariable("id") long id){
		return basicCarplantDao.deleteBasicCarplantById(id);
	}
	
	
	/**
	 * ��ѯ������Ϣ
	 * 
	 * @param code
	 *         ��������
	 * @param name
	 *         ��������
	 * @return
	 *      ������Ϣ�б�
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<Map<String,Object>> queryBasicCarplantList(
			@RequestParam(value="code",required=false) String code,
			@RequestParam(value="name",required=false) String name){
		return basicCarplantDao.queryBasicCarplantList(code, name);
	}
	

}
