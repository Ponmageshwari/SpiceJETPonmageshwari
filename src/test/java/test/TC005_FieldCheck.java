package test;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.FieldValidation;

public class TC005_FieldCheck extends ProjectSpecificationMethods{
	
	@Test
	public void Test1() throws InterruptedException { 
		
		FieldValidation obj = new FieldValidation(driver);
		obj.fieldtitle();
	}

}
