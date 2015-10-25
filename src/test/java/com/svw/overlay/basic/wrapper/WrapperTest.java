package com.svw.overlay.basic.wrapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

import com.svw.overlay.basic.items.Company;
import com.svw.overlay.basic.items.Employee;

public class WrapperTest {
	
	@Test
	public void CompanyTest(){
		BeanWrapper company = new BeanWrapperImpl(new Company());
		//setting the company name...
		company.setPropertyValue("name", "Some Company Inc.");
		// ... can also be done like this:
		PropertyValue value = new PropertyValue("name","Some Company Inc.");
		company.setPropertyValue(value);
		
		// ok, let's create the director and tie it to the company:
		BeanWrapper jim = new BeanWrapperImpl(new Employee());
	    jim.setPropertyValue("name", "Jim Stravinsky");
	    jim.setPropertyValue("salary", 10000);
	    company.setPropertyValue("managingDirector",jim.getWrappedInstance());
	    
	    //retriveving the salary of the managingDirector through the company
	    Float salary = (Float) company.getPropertyValue("managingDirector.salary");
	    
	    assertEquals(10000,salary,0.0001);
		
	}

}
