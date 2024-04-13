package AvishekLearning;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AvishekLearning.BaseTest.GlobalConfiguration;


public class EndToEndTest extends GlobalConfiguration {
	String userName = "avi1234@gmail.com";
	String pass = "Avijanu12345!";
	String desiredProduct = "ADIDAS ORIGINAL";
	
	@Test(dataProvider = "getData", groups = "runThisOnly")
	public void shop(HashMap<String,String> input) throws InterruptedException, IOException  {
		ProductListing plp = land.loggingIn(input.get("userName"), input.get("pass"));
		plp.addToCart(input.get("desiredProduct"));
		CartPage cp = plp.goToCart();
		OrderPage op = cp.checkOut(input.get("desiredProduct"));
		String displayedMessage = op.placeOrder();
		String confirmationMessage = "THANKYOU FOR THE ORDER.";
		Assert.assertEquals(displayedMessage, confirmationMessage);
	}
	
	
//	@Test(dependsOnMethods = {"shop"})
//	public void validateOrderList() {
//		System.out.println("When did I run?");
//		ProductListing plp = land.loggingIn(userName, pass);
//		MyOrdersPage mop = land.myOrders();
//		boolean isPresent = mop.validateOrder("ZARA COAT 33");
//		AssertJUnit.assertTrue(isPresent);
//	}

	
	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("userName", "avi1234@gmail.com");
//		map.put("pass", "Avijanu12345!");
//		map.put("desiredProduct", "ADIDAS ORIGINAL");
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("userName", "janu1234@gmail.com");
//		map1.put("pass", "wrongpasstest");
//		map1.put("desiredProduct", "ADIDAS ORIGINAL");
		
		List<HashMap<String,String>> data = retreiveDataFromFile("\\src\\test\\java\\AvishekLearning\\Data\\LogingData.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}
	
}
