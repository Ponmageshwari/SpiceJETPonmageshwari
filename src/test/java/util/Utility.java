package util;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	
	public static WebDriver driver;
	public String sheetname;
	
    public void browserLaunch(String url, String browser) throws Exception {
		
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);

		} else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		
		} 
	
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
    
   public void browserClose() {
		
		driver.close();
	}
	
   public void click(WebElement ele) {
		
		ele.click();
		
		}
	
	public void sendkeys(WebElement ele,String value) {
		
		ele.sendKeys(value);
	}
	
   public void waiting(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
   
   public void scriptexe(WebElement ele) {
	   
	   JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",ele);
   }
	
	public String screenShot(String name) throws IOException {
		
		String path = "C:\\Users\\Administrator\\eclipse-workspace\\SpiceJETProject\\snap\\"+name+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
		}
	
	 public static String[][] readExcel(String sheetname) throws Exception {
			
			XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\Administrator\\eclipse-workspace\\SpiceJETProject\\src\\test\\resources\\SpicejetDatasheet.xlsx");
			XSSFSheet sheet = book.getSheet(sheetname);
			int rowcount = sheet.getLastRowNum();
			short columncount = sheet.getRow(0).getLastCellNum();
			
			String[][] data = new String[rowcount][columncount];
			for(int i = 1 ; i <= rowcount; i++) {
				
				XSSFRow row = sheet.getRow(i);
				
				for(int j = 0; j < columncount; j++) {
					
					XSSFCell cell = row.getCell(j);
					data[i-1][j]=cell.getStringCellValue();
				}
			}
			
			book.close();
			return data;
	        }

}
