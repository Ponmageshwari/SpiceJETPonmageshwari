package test;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.Signup;

public class TC001_signup extends ProjectSpecificationMethods{
	
	@Test
	public void Test1() {
		
		Signup obj = new Signup(driver);
		obj.clicksigup();
		obj.window();
		obj.enterdetails();
		obj.enterfirstname("mahi");
		obj.enterlastname("Guru");
		obj.country();
		obj.dob();
		obj.mobile("9044105359");
		obj.Mailid("abc@gmail.com");
		obj.enterpassword("Ras@77088");
		obj.reenterpassword("Ras@77088");
		obj.checkbox();
		obj.Submit();
		
	}

}
