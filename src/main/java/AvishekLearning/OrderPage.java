package AvishekLearning;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AvishekLearning.ReusableThings.ReusableClass;

public class OrderPage extends ReusableClass {
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

	@FindBy(css = "[placeholder='Select Country']")
	WebElement countrySelector;

	@FindBy(css = "a[class*='action__submit']")
	WebElement placeOrder;

	@FindBy(css = "span[class='ng-star-inserted']")
	List<WebElement> countryList;
	
	@FindBy(css = ".hero-primary")
	WebElement shownMessage;

	public String placeOrder() {
		countrySelector.sendKeys("Ind");
		WebElement country = countryList.stream().filter(a -> a.getText().equalsIgnoreCase("India")).findFirst()
				.orElse(null);
		country.click();
		placeOrder.click();
		String confirmationMessage = shownMessage.getText();
		return confirmationMessage;
	}

}
