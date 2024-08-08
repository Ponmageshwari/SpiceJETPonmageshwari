package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtenetReportSpicejet {
	
public static ExtentReports getReport() {
		
		String path="C:\\Users\\Administrator\\eclipse-workspace\\SpiceJETProject\\Report\\SpicejetReport.html";
		// To create report in the given location
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("spicejet Reporter");
		
		// To capture test data
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		return extent;
	}


}
