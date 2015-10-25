package com.svw.overlay.basic.validators;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.SimpleBeanInfo;

import org.springframework.beans.propertyeditors.CustomNumberEditor;

public class FooBeanInfo extends SimpleBeanInfo {
      
	public PropertyDescriptor[] getPropertyDescriptors(){
		try {
			final PropertyEditor numberPE = new CustomNumberEditor(Integer.class, true);
			PropertyDescriptor ageDescriptor = new PropertyDescriptor("age",Foo.class){

				@Override
				public PropertyEditor createPropertyEditor(Object bean) {
					return numberPE;
				}
				
			};
			return new PropertyDescriptor[]{ageDescriptor};
		    
		} catch (IntrospectionException e) {
			throw new Error(e.toString());
		}
				
	}
}
