package AvishekLearning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AvishekLearning.ReusableThings.ReusableClass;

public class ProductListing extends ReusableClass {
	WebDriver driver;

	public ProductListing(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class*='mb-3']")
	List<WebElement> displayedProducts;

	@FindBy(css = "#toast-container")
	WebElement toast;

	@FindBy(css = "[routerlink='/dashboard/cart']")
	WebElement cart;

	@FindBy(css = "ngx-spinner[class = 'ng-tns-c31-47 ng-star-inserted']")
	WebElement spinner1;

	By productsDisplayed = By.cssSelector("div[class*='mb-3']");
	By desiredProductText = By.cssSelector("div[class = 'card-body'] h5");
	By desiredAddButton = By.cssSelector(".card-body button:last-child");
	By spinner = By.cssSelector("ngx-spinner[class = 'ng-tns-c31-47 ng-star-inserted']");
	By toast1 = By.cssSelector("#toast-container");

	private List<WebElement> getProductList() {
		waitUntilVisibility(productsDisplayed);
		return displayedProducts;
	}

	private WebElement getProductName(String product) {
		WebElement desiredProduct = getProductList().stream()
				.filter(a -> a.findElement(desiredProductText).getText().equals(product)).findFirst().orElse(null);
		return desiredProduct;
	}

	public void addToCart(String product) {
		getProductName(product).findElement(desiredAddButton).click();
	}

	public CartPage goToCart() throws InterruptedException {
		Thread.sleep(2000);
//		waitUntilVisibility(toast1);    Making us wait 4sec even after the spinner is invisible as there is one more hidden spinner. So used thread method.
//		waitUntilInvisibilty(spinner1);
		cart.click();
		CartPage cart = new CartPage(driver);
		return cart;
	}
}
