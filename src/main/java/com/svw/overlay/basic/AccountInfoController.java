package com.svw.overlay.basic;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svw.overlay.basic.dao.AccountInfoDao;
import com.svw.overlay.basic.enums.AccountStatusEnum;
import com.svw.overlay.basic.items.AccountInfo;

@RequestMapping("/services/account")
@Controller
public class AccountInfoController {
	
	private AccountInfoDao accountInfoDao;

	@Autowired
	public void setAccountInfoDao(AccountInfoDao accountInfoDao) {
		this.accountInfoDao = accountInfoDao;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	/**
	 * 创建用户信息
	 * 
	 * @param ussername
	 *         用户名
	 * @param password
	 *         密码
	 * @param status
	 *         用户状态
	 * @param remarks
	 *         备注
	 * @return
	 *       返回成功条数
	 */
	public Map<String,Object> createAccountInfo(@RequestParam("username") String username,
		@RequestParam("password") String password,
		@RequestParam(value="status", defaultValue="-1") AccountStatusEnum status,
		@RequestParam(value="remarks",required=false,defaultValue="") String remarks){
		
		//对密码进行md5摘要
		password = DigestUtils.md5Hex(password);
		
		long c = accountInfoDao.createAccountInfo(
				username, password, status.getLongValue(), remarks);
		
		Map<String,Object> map = new HashMap<String,Object>();
		if(c>0){
			map.put("success", true);
			map.put("count", c);
			map.put("msg", "用户创建成功!");
		}else{
			map.put("success", false);
			map.put("count", c);
			map.put("msg", "用户创建失败!");
		}
		return map;
	}
	
	@RequestMapping(value="/updatePwd",method = RequestMethod.POST)
	@ResponseBody
	/**
	 * 更新密码
	 * 
	 * @param oldPassword
	 *        旧密码
	 * @param newPassword
	 *        新密码
	 * @param session
	 * 
	 * @return
	 *       是否更新成功
	 */
	public Map<String,Object> updatePassword(@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword,HttpSession session){
		AccountInfo accountInfo = (AccountInfo) session.getAttribute("accountInfo");
		Map<String,Object> map = new HashMap<String,Object>();
		if(accountInfo==null){
			map.put("success", false);
			map.put("count", 0);
			map.put("msg", "用户没有登陆,请先登录,再进行操作!");
			return map;
		}
		//对密码进行md5摘要
		oldPassword = DigestUtils.md5Hex(oldPassword);
		newPassword = DigestUtils.md5Hex(newPassword);
		
		long c = accountInfoDao.updatePassword(accountInfo.getId(),
				oldPassword, newPassword, new Date());
		if(c>0){
			map.put("success", true);
			map.put("count", c);
			map.put("msg", "更新密码成功!");
		}else{
			map.put("success", false);
			map.put("count", c);
			map.put("msg", "更新密码失败!");
		}
		return map;
	}
	
	@RequestMapping(value="/updateStatus/{id}",method = RequestMethod.POST)
	@ResponseBody
	/**
	 * 更新状态
	 * 
	 * @param id
	 * 
	 * @param status
	 *        状态
	 * @return
	 *     是否更新成功
	 */
	public Map<String,Object> updateStatus(@PathVariable("id") Long id,
			@RequestParam("status") AccountStatusEnum status){
		long c = accountInfoDao.updateStatus(id, status.getLongValue(), new Date());
		Map<String,Object> map = new HashMap<String,Object>();
		if(c>0){
			map.put("success", true);
			map.put("count", c);
			map.put("msg", "更新状态成功!");
		}else{
			map.put("success", false);
			map.put("count", c);
			map.put("msg", "更新状态失败!");
		}
		return map;
	}
	
	@RequestMapping(value="/updateRemarks/{id}",method = RequestMethod.POST)
	@ResponseBody
	/**
	 * 更新备注
	 * 
	 * @param id
	 * 
	 * @param remarks
	 *        备注
	 * @return
	 *       是否更新成功
	 */
	public Map<String,Object> updateRemarks(@PathVariable("id") Long id,
			@RequestParam("remarks") String remarks){
		long c = accountInfoDao.updateRemarks(id, remarks, new Date());
		Map<String,Object> map = new HashMap<String,Object>();
		if(c>0){
			map.put("success", true);
			map.put("count", c);
			map.put("msg", "更新备注成功!");
		}else{
			map.put("success", false);
			map.put("count", c);
			map.put("msg", "更新备注失败!");
		}
		return map;
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@ResponseBody
	/**
	 * 通过id查询账户信息
	 * 
	 * @param id
	 * 
	 * @return
	 *       账户信息 
	 */
	public Map<String,Object> queryAccountInfoById(@PathVariable("id") Long id){
		Map<String,Object> accountInfo = accountInfoDao.queryAccountInfoById(id);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("accountInfo", accountInfo);
		return map;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	/**
	 * 查询用户信息
	 * 
	 * @param username
	 *         用户名
	 * @param status
	 *         状态 
	 * @return
	 *         用户信息
	 */
	public Map<String,Object> queryAccountInfoList(@RequestParam("username") String username,
			@RequestParam("status") AccountStatusEnum status){
		List<Map<String,Object>> list = accountInfoDao.queryAccountInfoList(username, 
				status!=null?status.getLongValue():null);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("accountInfoList", list);
		return map;
	}

}
