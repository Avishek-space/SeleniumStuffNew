package AvishekLearning.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+ "//NewReports//aviindex.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Submit Order Report");
		reporter.config().setDocumentTitle("Test Execution Report");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "The Pradhan");
		return extent;
	}
}
