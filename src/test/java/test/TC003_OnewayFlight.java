package test;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.FlightBooking;
import pages.Login;

public class TC003_OnewayFlight extends ProjectSpecificationMethods{
	
	@Test
	public void Test1() throws InterruptedException, IOException {
	
		FlightBooking obj = new FlightBooking(driver);
		//obj.logincall();
		
		obj.onewaytrip();
		obj.destination();
		obj.depaturedate();
        obj.searchFlight();
        obj.con();
        obj.Bookingdetail("Mahi","Guru","7708741751","manjula@gmail.com");
        obj.payment("123456789456","ghyr","10","28","123");
        

}
}
