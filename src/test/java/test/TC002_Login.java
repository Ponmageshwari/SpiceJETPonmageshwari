package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.Login;

public class TC002_Login extends ProjectSpecificationMethods{
	@BeforeTest
	public void setup() {
		
		sheetname ="Login";
	}
	@Test(dataProvider = "getData")

	public void Test1(String user,String pass) {
		
		Login obj = new Login(driver);
		obj.clicklogin();
		obj.phonenum(user);
		obj.pass(pass);
		obj.submit();

}
}
