package test;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.Roundtrip;

public class TC004_RoundTrip extends ProjectSpecificationMethods{
	
	@Test
	public void Test1() throws InterruptedException, IOException {
		
		Roundtrip obj = new Roundtrip(driver);
		obj.round();
		obj.depaturedate();
		obj.continuebooking();
		obj.Bookingdetail("Mahi","Guru","7708741751","manjula@gmail.com");
		obj.payment("123456789456","ghyr","10","28","123");

}
}
