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
	 * �����û���Ϣ
	 * 
	 * @param ussername
	 *         �û���
	 * @param password
	 *         ����
	 * @param status
	 *         �û�״̬
	 * @param remarks
	 *         ��ע
	 * @return
	 *       ���سɹ�����
	 */
	public Map<String,Object> createAccountInfo(@RequestParam("username") String username,
		@RequestParam("password") String password,
		@RequestParam(value="status", defaultValue="-1") AccountStatusEnum status,
		@RequestParam(value="remarks",required=false,defaultValue="") String remarks){
		
		//���������md5ժҪ
		password = DigestUtils.md5Hex(password);
		
		long c = accountInfoDao.createAccountInfo(
				username, password, status.getLongValue(), remarks);
		
		Map<String,Object> map = new HashMap<String,Object>();
		if(c>0){
			map.put("success", true);
			map.put("count", c);
			map.put("msg", "�û������ɹ�!");
		}else{
			map.put("success", false);
			map.put("count", c);
			map.put("msg", "�û�����ʧ��!");
		}
		return map;
	}
	
	@RequestMapping(value="/updatePwd",method = RequestMethod.POST)
	@ResponseBody
	/**
	 * ��������
	 * 
	 * @param oldPassword
	 *        ������
	 * @param newPassword
	 *        ������
	 * @param session
	 * 
	 * @return
	 *       �Ƿ���³ɹ�
	 */
	public Map<String,Object> updatePassword(@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword,HttpSession session){
		AccountInfo accountInfo = (AccountInfo) session.getAttribute("accountInfo");
		Map<String,Object> map = new HashMap<String,Object>();
		if(accountInfo==null){
			map.put("success", false);
			map.put("count", 0);
			map.put("msg", "�û�û�е�½,���ȵ�¼,�ٽ��в���!");
			return map;
		}
		//���������md5ժҪ
		oldPassword = DigestUtils.md5Hex(oldPassword);
		newPassword = DigestUtils.md5Hex(newPassword);
		
		long c = accountInfoDao.updatePassword(accountInfo.getId(),
				oldPassword, newPassword, new Date());
		if(c>0){
			map.put("success", true);
			map.put("count", c);
			map.put("msg", "��������ɹ�!");
		}else{
			map.put("success", false);
			map.put("count", c);
			map.put("msg", "��������ʧ��!");
		}
		return map;
	}
	
	@RequestMapping(value="/updateStatus/{id}",method = RequestMethod.POST)
	@ResponseBody
	/**
	 * ����״̬
	 * 
	 * @param id
	 * 
	 * @param status
	 *        ״̬
	 * @return
	 *     �Ƿ���³ɹ�
	 */
	public Map<String,Object> updateStatus(@PathVariable("id") Long id,
			@RequestParam("status") AccountStatusEnum status){
		long c = accountInfoDao.updateStatus(id, status.getLongValue(), new Date());
		Map<String,Object> map = new HashMap<String,Object>();
		if(c>0){
			map.put("success", true);
			map.put("count", c);
			map.put("msg", "����״̬�ɹ�!");
		}else{
			map.put("success", false);
			map.put("count", c);
			map.put("msg", "����״̬ʧ��!");
		}
		return map;
	}
	
	@RequestMapping(value="/updateRemarks/{id}",method = RequestMethod.POST)
	@ResponseBody
	/**
	 * ���±�ע
	 * 
	 * @param id
	 * 
	 * @param remarks
	 *        ��ע
	 * @return
	 *       �Ƿ���³ɹ�
	 */
	public Map<String,Object> updateRemarks(@PathVariable("id") Long id,
			@RequestParam("remarks") String remarks){
		long c = accountInfoDao.updateRemarks(id, remarks, new Date());
		Map<String,Object> map = new HashMap<String,Object>();
		if(c>0){
			map.put("success", true);
			map.put("count", c);
			map.put("msg", "���±�ע�ɹ�!");
		}else{
			map.put("success", false);
			map.put("count", c);
			map.put("msg", "���±�עʧ��!");
		}
		return map;
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@ResponseBody
	/**
	 * ͨ��id��ѯ�˻���Ϣ
	 * 
	 * @param id
	 * 
	 * @return
	 *       �˻���Ϣ 
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
	 * ��ѯ�û���Ϣ
	 * 
	 * @param username
	 *         �û���
	 * @param status
	 *         ״̬ 
	 * @return
	 *         �û���Ϣ
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
