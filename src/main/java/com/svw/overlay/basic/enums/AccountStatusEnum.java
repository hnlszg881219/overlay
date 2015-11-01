package com.svw.overlay.basic.enums;

public enum AccountStatusEnum {
	  LOCKED(-1), CLOSED(0), OPENED(1);
      //成员变量
      private int value;

	private AccountStatusEnum(int value) {
		this.value = value;
	}

	public Long getLongValue(){
		return Long.valueOf(value);
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
    
      
}
