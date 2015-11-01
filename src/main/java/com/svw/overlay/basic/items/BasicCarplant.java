package com.svw.overlay.basic.items;

public class BasicCarplant {
	
	private Long id;
	
	//����
	private String code;
	
	//����
	private String name;
	
	//��ַ
	private String address;
	
	//����
	private float longtitude;
	
	//γ��
	private float latitude;
	
	//��ע
	private String remakes;
	
	
	public BasicCarplant() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(float longtitude) {
		this.longtitude = longtitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public String getRemakes() {
		return remakes;
	}

	public void setRemakes(String remakes) {
		this.remakes = remakes;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}
		
		if(!(obj instanceof BasicCarplant)){
			return false;
		}
		
		if(!((BasicCarplant)obj).getCode().equals(this.getCode())){
			return false;
		}
		
		return true;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "����:"+this.getCode()+" ���ƣ�"+this.getName()
				+" ��ַ:"+this.getAddress()+" ����:"+this.getLongtitude()+
				" γ��:"+this.getLatitude();
	}
	
	

}
