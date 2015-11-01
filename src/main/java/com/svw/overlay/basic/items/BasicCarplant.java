package com.svw.overlay.basic.items;

public class BasicCarplant {
	
	private Long id;
	
	//代码
	private String code;
	
	//名称
	private String name;
	
	//地址
	private String address;
	
	//经度
	private float longtitude;
	
	//纬度
	private float latitude;
	
	//备注
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
		return "代码:"+this.getCode()+" 名称："+this.getName()
				+" 地址:"+this.getAddress()+" 经度:"+this.getLongtitude()+
				" 纬度:"+this.getLatitude();
	}
	
	

}
