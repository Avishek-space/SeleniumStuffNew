package AvishekLearning.ReusableThings;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import AvishekLearning.MyOrdersPage;
import AvishekLearning.ProductListing;

public class ReusableClass {
	WebDriver driver;
	

	
	
	public ReusableClass(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerLink*='myorders']")
	WebElement myOrder;
	

	public void waitUntilInvisibilty(By Bylocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Bylocator));
	}
	
	public void waitUntilVisibility(By bylocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(bylocator));
	}
	
	public void waitUntilVisibility(WebElement toast) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(toast));
	}
	
	public void waitUntilInvisibilty(WebElement spinner) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(spinner));
	}
	
	public MyOrdersPage myOrders() {
		myOrder.click();
		MyOrdersPage mop = new MyOrdersPage(driver);
		return mop;
	}
	
	
	
}
