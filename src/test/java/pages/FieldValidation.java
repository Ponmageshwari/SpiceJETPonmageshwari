package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class FieldValidation extends ProjectSpecificationMethods{
	
	public FieldValidation(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
 
	public void fieldtitle() {
		
	String Checkin = driver.findElement(By.xpath("//div[text()='check-in']")).getText();
	System.out.println(Checkin);
	
	String flight = driver.findElement(By.xpath("//div[text()='flight status']")).getText();
	System.out.println(flight);
	
	String managebooking = driver.findElement(By.xpath("//div[text()='manage booking']")).getText();
	System.out.println(managebooking);
		
		
	}
}
