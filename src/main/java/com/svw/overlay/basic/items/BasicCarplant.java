package com.svw.overlay.basic.items;

public class BasicCarplant {
	
	private Long id;
	
	//����
	private String code;
	
	//����
	private String name;
	
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
	

}
