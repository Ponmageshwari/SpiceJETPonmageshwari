package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class Roundtrip extends ProjectSpecificationMethods{
	
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-zso239'])[2]")
	WebElement radiobutton;
	
	@FindBy(xpath = "//input[@value='Select Destination']")
	WebElement dest;
	
	@FindBy(xpath = "//div[text()='Ahmedabad']")
	WebElement destcity;
	
	@FindBy(xpath = "(//div[text()='23'])[2]")
	WebElement depdate;
	
	@FindBy(xpath = "(//div[text()='29'])[2]")
	WebElement returndate;
	
	@FindBy(xpath = "//div[text()='Search Flight']")
	WebElement searchflight;
	
	@FindBy(xpath = "(//div[text()='Continue'])[1]")
	WebElement Continue;
	
	@FindBy(xpath = "(//input[@autocapitalize='sentences'])[1]")
	WebElement firstname;
	
	@FindBy(xpath = "(//input[@autocapitalize='sentences'])[2]")
	WebElement lastname;
	
	@FindBy(xpath = "(//input[@autocapitalize='sentences'])[3]")
	WebElement number;
	
	@FindBy(xpath = "(//input[@autocapitalize='sentences'])[4]")
	WebElement email;
	
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-zso239'])[6]")
	WebElement checkbox;
	
	
	@FindBy(xpath = "//div[text()='Continue']")
	WebElement continuebooking;

	@FindBy(xpath = "(//div[text()='First and Middle Name*'])[2]")
	WebElement scroll;

	@FindBy(xpath = "(//div[text()='Continue'])[3]")
	WebElement review;

	@FindBy(xpath = "//span[text()='Skip this to skip comfort.']")
	WebElement skip;

	@FindBy(xpath = "//input[@id='card_number']")
	WebElement cardno;
	
	@FindBy(xpath = "//input[@id='name_on_card']")
	WebElement cardname;
	
	@FindBy(xpath = "//input[@id='card_exp_month']")
	WebElement Expmonth;
	
	@FindBy(xpath = "//input[@id='card_exp_year']")
	WebElement Expyear;
	
	@FindBy(xpath = "//input[@id='security_code']")
	WebElement CVV;
	
	@FindBy(xpath = "//div[text()='Payable Amount']")
	WebElement Finalscroll;
	
	@FindBy(xpath = "//div[text()='Proceed to pay']")
	WebElement FinalPay;
	
	 public Roundtrip(WebDriver driver) {
			
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	 
	 public void round() {
		 
		 click(radiobutton);
		 click(dest);
		 click(destcity);
	 }
	 
	 public void depaturedate() {
    	 
	    	Actions mouse = new Actions(driver);
	 		mouse.click(depdate).perform(); 
	 		mouse.click(returndate).perform();
	 		mouse.doubleClick(searchflight).perform();
	     }
	 
     public void continuebooking() {
    	 
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  		wait.until(ExpectedConditions.elementToBeClickable(Continue));
  		Actions mouse = new Actions(driver);
 		 mouse.doubleClick(Continue).perform();
    	 
        }
     
 public void Bookingdetail(String name1,String name2,String name3,String name4) throws InterruptedException {
    	 
    	 sendkeys(firstname, name1);
    	 sendkeys(lastname, name2);
    	 sendkeys(number, name3);
    	 sendkeys(email, name4);
    	 click(checkbox);
    	
    	 WebElement element = driver.findElement(By.xpath("//div[text()='Continue']"));
    	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
    	 Actions actions = new Actions(driver);
    	 actions.moveToElement(scroll).perform();
    	 actions.doubleClick(continuebooking).perform();
    
    	 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
   		wait1.until(ExpectedConditions.elementToBeClickable(review));
   		JavascriptExecutor js = (JavascriptExecutor)driver;
   		js.executeScript("arguments[0].click();", review);
   		
   		click(skip);

     }
 
 public void payment(String value,String value1,String value2,String value3,String value4) throws IOException {
	 
	 WebElement frame = driver.findElement(By.xpath("//iframe[@class='card_number_iframe']"));
	 driver.switchTo().frame(frame);
	 sendkeys(cardno, value);
	 
	 driver.switchTo().parentFrame();
	 WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='name_on_card_iframe']"));
	 driver.switchTo().frame(frame1);
	 sendkeys(cardname, value1);
	 
	 driver.switchTo().parentFrame();
	 WebElement frame2 = driver.findElement(By.xpath("//iframe[@class='card_exp_month_iframe']"));
	 driver.switchTo().frame(frame2);
	 sendkeys(Expmonth, value2);
	 
	 driver.switchTo().parentFrame();
	 WebElement frame3 = driver.findElement(By.xpath("//iframe[@class='card_exp_year_iframe']"));
	 driver.switchTo().frame(frame3);
	 sendkeys(Expyear, value3);
	 
	 driver.switchTo().parentFrame();
	 WebElement frame4 = driver.findElement(By.xpath("//iframe[@class='security_code_iframe']"));
	 driver.switchTo().frame(frame4);
	 sendkeys(CVV, value4);
	 driver.switchTo().defaultContent();
	 
	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Finalscroll);
	 Actions actions = new Actions(driver);
	 actions.moveToElement(Finalscroll).perform();	 
	 actions.doubleClick(FinalPay).perform();
	 
	 screenShot("Spice");

}
}



