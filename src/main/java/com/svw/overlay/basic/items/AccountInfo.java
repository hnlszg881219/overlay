package com.svw.overlay.basic.items;

import java.util.Date;
/**
 * �˻���Ϣ
 * 
 * @author fangjun
 * 
 * create time 2015-11-01
 *
 */
public class AccountInfo {
	
	private Long id ;
	//�û���
	private String username;
	//����
	private String password;
	//����ʱ�� 
	private Date createTime;
	//����ʱ��
	private Date updateTime;
	// ״̬
	private int status;
	//��ע
	private String remarks;

	
	public AccountInfo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

}
