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
	 * 创建工厂基本信息
	 * 
	 * @param code
	 *         代码
	 * @param name
	 *         名称
	 * @param address
	 *         地址
	 * @param longtitude
	 *         经度
	 * @param latitude
	 *         纬度
	 * @param remarks
	 *         备注
	 * @return
	 *       创建成功数
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
	 * 更新工厂基本信息
	 * 
	 * @param id
	 *         
	 * @param code
	 *        工厂代码
	 * @param name
	 *        工厂名称
	 * @param address
	 *        地址
	 * @param longtitude
	 *        经度
	 * @param latitude
	 *        纬度
	 * @param remarks
	 *        备注
	 * @return
	 *       更新条数
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
	 * 通过id查询工厂信息
	 * 
	 * @param id
	 * 
	 * @return
	 *       工厂信息
	 */
    public BasicCarplant queryBasicCarplantById(@PathVariable("id") String id){
		BasicCarplant bc = new BasicCarplant();
		bc.setCode("afsas");
		return bc;
    	
    }
	
	@RequestMapping(value="/carplant/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	/**
	 * 通过id删除工厂信息
	 * @param id
	 * 
	 * @return
	 *        删除条数
	 */
	public long deleteBasicCarplantById(@PathVariable("id") String id){
		return 0;
		
	}
	
	@RequestMapping(value="/carplantList",method = RequestMethod.GET)
	@ResponseBody
	/**
	 * 查询工厂信息
	 * 
	 * @param code
	 *         工厂代码
	 * @param name
	 *         工厂名称
	 * @return
	 *      工厂信息列表
	 */
	public Collection<BasicCarplant> queryBasicCarplantList(
			@RequestParam("code") String code,
			@RequestParam("name") String name){
		return null;
		
	}
	

}
