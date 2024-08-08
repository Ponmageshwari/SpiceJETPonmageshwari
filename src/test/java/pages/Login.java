package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class Login extends ProjectSpecificationMethods {
	
	@FindBy(xpath = "//div[text()='Login']")
	WebElement login;
	
	@FindBy(xpath = "(//input[contains(@class,'css-1cwyjr8')])[3]")
	WebElement  phone;
	
	@FindBy(xpath = "(//input[@dir='auto'])[4]")
	WebElement Pass;
	
	@FindBy(xpath = "//div[text()='LOGIN']")
	WebElement loginclick;
	
      public Login(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
      
      public void clicklogin() {
    	  
    	  click(login);
    	  
      }
      
      public void phonenum(String num) {
    	  
    	  sendkeys(phone, num);
      }
      
      public void pass(String password) {
    	  
    	  sendkeys(Pass, password);
      }
      
      public void submit() {
    	  
    	 // click(loginclick);
    	  Actions mouse = new Actions(driver);
 		 mouse.doubleClick(loginclick).perform();
      }
      

}
