package AvishekLearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

//public class ExtentPractise {
	
//	ExtentReports extent;
//	
//	@BeforeTest
//	public void createReport() {
//		String path = System.getProperty("user.dir")+ "//myReports.index.html";
//		 ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//	        reporter.config().setReportName("YouTube SS");
//	        reporter.config().setDocumentTitle("Avishek Report");
//	        extent = new ExtentReports();
//	        extent.attachReporter(reporter);
//	        extent.setSystemInfo("Tester", "Avishek");
//	}
		
	
	
        
//	@Test	
//	public void openPage() {
//    ExtentTest testobject = extent.createTest("openpage");
//    WebDriverManager.chromedriver().setup();
//    WebDriver driver = new ChromeDriver();
//    driver.get("https://www.google.com/");
//    System.out.println(driver.getTitle());
//    testobject.fail("Intentionally failed");
//    System.out.println(testobject.getClass());
//    testobject.getClass();
//    driver.close();
//	extent.flush();
//	}
//	
//
//}
