package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class Signup extends ProjectSpecificationMethods{
	
	@FindBy(xpath = "//div[text()='Signup']")
	WebElement signup;
	
	@FindBy(id = "first_name")
	WebElement firstname;
	
	@FindBy(id = "last_name")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@class=' form-control']")
	WebElement number;
	
	@FindBy(id = "email_id")
	WebElement mail;
	
	@FindBy(xpath = "//input[@id='new-password']")
	WebElement password;
	
	@FindBy(id = "c-password")
	WebElement reenterpass;
	
	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submit;
	
      public Signup(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
      
      public void clicksigup() {
    	  
    	  click(signup);
    	  
    	   }
      
   // Switch to window
		public void window() {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
	
		}
      public void enterdetails() {
    	  
    	WebElement Title =  driver.findElement(By.xpath("//select[@class='form-control form-select ']"));
    	  Select title = new Select(Title);
    	  title.selectByValue("MRS");
      }
      
      public void enterfirstname(String Firstname) {
    	  
    	  sendkeys(firstname, Firstname);
      }
      
      public void enterlastname(String Lastname) {
    	  
    	  sendkeys(lastname, Lastname);
      }
      
      public void country() {
    	  
    	  WebElement Country = driver.findElement(By.xpath("//select[@class='form-control form-select']"));
    	  Select entercountry = new Select(Country);
    	  entercountry.selectByValue("IN");
      }
      
      public void dob() {
    	  driver.findElement(By.id("dobDate")).click();   	 
    	  WebElement month = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
    	  Select entermonth = new Select(month);
    	  entermonth.selectByValue("1");
    	  WebElement year = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
    	  Select enteryear = new Select(year);
    	  enteryear.selectByValue("1999");
    	  driver.findElement(By.xpath("//div[text()='1']")).click();
      }
      
      public void mobile(String Number) {
    	  
    	  sendkeys(number, Number);
      }
      
      public void Mailid(String entermail) {
    	  
    	  sendkeys(mail, entermail);
      }
      
      public void enterpassword(String Password) {
    	  
    	  sendkeys(password, Password);
      }
      
      public void reenterpassword(String Confirmpass) {
    	  
    	  sendkeys(reenterpass, Confirmpass);
      }
      
      public void checkbox() {
    	  
    	 driver.findElement(By.xpath("//input[@id='defaultCheck1']"));
      }
      
      public void Submit() {
    	  
    	  WebElement ele = driver.findElement(By.xpath("//input[@id='defaultCheck1']"));
  		JavascriptExecutor js = (JavascriptExecutor)driver;
  		js.executeScript("arguments[0].scrollIntoView();", ele);
  		Actions actions = new Actions(driver);
   	 actions.moveToElement(ele).perform();
    	  
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		wait.until(ExpectedConditions.elementToBeClickable(submit));
    		Actions mouse = new Actions(driver);
   		 mouse.doubleClick(submit).perform();
    	 // click(submit);
      }

}
