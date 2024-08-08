package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import util.Utility;

public class ProjectSpecificationMethods extends Utility {

	@Parameters({"url","browser"})
  @BeforeMethod
    public void launchingBrowser(String url, String browser) throws Exception  {
		
		
		browserLaunch(url,browser);
	}
	
	@AfterMethod
	public void closingBrowser() {
		
		browserClose();
	}
	
	@DataProvider(name = "getData")
	public String[][] getData() throws Exception {
		
		String[][] data = readExcel(sheetname);
		return data;
	}

}
