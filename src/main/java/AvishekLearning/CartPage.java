package AvishekLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import AvishekLearning.ReusableThings.ReusableClass;

public class CartPage extends ReusableClass {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	WebElement productsAdded;

	@FindBy(css = ".totalRow:nth-child(3) button")
	WebElement checkOut;

	By productsList = By.cssSelector(".cart li"); 

	public OrderPage checkOut(String product) {
		waitUntilVisibility(productsList);
		boolean flag = productsAdded.getText().equalsIgnoreCase(product);
		Assert.assertTrue(flag);
		checkOut.click();
		OrderPage op = new OrderPage(driver);
		return op;
	}

}
