package com.svw.overlay.basic.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.svw.overlay.basic.items.BasicCarplant;

public class BasicCarplantValidator implements Validator {

	/*
	 * This Validator validates *just BasicCarplant instances
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return BasicCarplant.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {
         ValidationUtils.rejectIfEmptyOrWhitespace(e, "name", "名称不能为空!");
         ValidationUtils.rejectIfEmptyOrWhitespace(e, "code", "代码不能为空!");
         BasicCarplant bc = (BasicCarplant)obj;
         if(bc.getLongtitude()<-180 || bc.getLongtitude()>180){
        	 e.reject("longtitude", "经度的值错误!");
         }
         if(bc.getLatitude()<-90 || bc.getLatitude()>90){
        	 e.reject("latitude", "纬度的值错误!");
         }
	}

}
