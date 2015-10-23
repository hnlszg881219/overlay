package com.svw.overlay.basic;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svw.overlay.basic.items.BasicCarplant;

@RequestMapping("/carplant")
@Controller
public class CarplantController {
	
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
		return 0;
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
	public long updateBasicCarplant(@PathVariable("id") String id,
			@RequestParam("code") String code,
			@RequestParam("name") String name, @RequestParam("address") String address,
			@RequestParam(value="longtitude", required=false, defaultValue="0") long longtitude,
			@RequestParam(value="latitude", required=false, defaultValue="0") long latitude,
			@RequestParam(value="remarks", required=false) String remarks){
	  return 0;
		
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
    public BasicCarplant queryBasicCarplantById(@PathVariable("id") String id){
		BasicCarplant bc = new BasicCarplant();
		bc.setCode("afsas");
		return bc;
    	
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
	public long deleteBasicCarplantById(@PathVariable("id") String id){
		return 0;
		
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
	public Collection<BasicCarplant> queryBasicCarplantList(
			@RequestParam("code") String code,
			@RequestParam("name") String name){
		return null;
		
	}
	

}
