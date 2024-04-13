package AvishekLearning.BaseTest;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import AvishekLearning.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GlobalConfiguration { 
	public WebDriver driver;
	public LandingPage land;

	private WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\avish\\eclipse-workspace\\SeleniumFramework\\src\\main\\java\\AvishekLearning\\Resources\\GlobalThings.properties");
		prop.load(file);
		
		String browserType = System.getProperty("Browser") != null ? System.getProperty("Browser"): prop.getProperty("Browser");
		 
		
		if(browserType.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserType.contains("headless")) {
			options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900)); 
		}
		else if(browserType.equalsIgnoreCase("edge")) { 
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
//		else System.out.println("No specific browser found");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException  {
		System.out.println("I started running");
		driver = initializeDriver();
		land = new LandingPage(driver);
		land.goTo("https://rahulshettyacademy.com/client/");
		return land;
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeApp() {
		driver.close();
	}
	
	public List<HashMap<String, String>> retreiveDataFromFile(String filePath) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+ filePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		return data;	
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "//NewReports//" + testCaseName + ".png");
		FileUtils.copyFile(source, destination); 
		return System.getProperty("user.dir") + "//NewReports//" + testCaseName + ".png";
		
	}
	 
}
