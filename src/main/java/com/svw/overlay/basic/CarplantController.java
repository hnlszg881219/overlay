package com.svw.overlay.basic;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svw.overlay.basic.dao.BasicCarplantDao;

@RequestMapping("/services/carplant")
@Controller
public class CarplantController {
	
	private BasicCarplantDao basicCarplantDao;
	
	@Autowired
	public void setBasicCarplantDao(BasicCarplantDao basicCarplantDao) {
		this.basicCarplantDao = basicCarplantDao;
	}

	@RequestMapping(value="/carplant",method = RequestMethod.PUT)
	@ResponseBody
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
	public long createBasicCarplant(@RequestParam("code") String code,
			@RequestParam("name") String name, @RequestParam("address") String address,
			@RequestParam(value="longtitude", required=false, defaultValue="0") long longtitude,
			@RequestParam(value="latitude", required=false, defaultValue="0") long latitude,
			@RequestParam(value="remarks", required=false) String remarks){
		
		return basicCarplantDao.createBasicCarplant(code, name, address,
				longtitude, latitude, remarks);
	}
	
	@RequestMapping(value="/carplant/{id}",method = RequestMethod.POST)
	@ResponseBody
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
	public long updateBasicCarplant(@PathVariable("id") long id,
			@RequestParam("code") String code,
			@RequestParam("name") String name, @RequestParam("address") String address,
			@RequestParam(value="longtitude", required=false, defaultValue="0") long longtitude,
			@RequestParam(value="latitude", required=false, defaultValue="0") long latitude,
			@RequestParam(value="remarks", required=false) String remarks){
	  return basicCarplantDao.updateBasicCarplant(id, code, name, address,
			  longtitude, latitude, remarks);
		
	}
	
	@RequestMapping(value="/carplant/{id}",method = RequestMethod.GET)
	@ResponseBody
	/**
	 * ͨ��id��ѯ������Ϣ
	 * 
	 * @param id
	 * 
	 * @return
	 *       ������Ϣ
	 */
    public Map<String,Object> queryBasicCarplantById(@PathVariable("id") long id){
		return basicCarplantDao.queryBasicCarplantById(id);
    }
	
	@RequestMapping(value="/carplant/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	/**
	 * ͨ��idɾ��������Ϣ
	 * @param id
	 * 
	 * @return
	 *        ɾ������
	 */
	public long deleteBasicCarplantById(@PathVariable("id") long id){
		return basicCarplantDao.deleteBasicCarplantById(id);
		
	}
	
	@RequestMapping(value="/carplantList",method = RequestMethod.GET)
	@ResponseBody
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
	public Collection<Map<String,Object>> queryBasicCarplantList(
			@RequestParam("code") String code,
			@RequestParam("name") String name){
		return basicCarplantDao.queryBasicCarplantList(code, name);
	}
	

}
