package AvishekLearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AvishekLearning.ReusableThings.ReusableClass;

public class LandingPage extends ReusableClass {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}  

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")  
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement login;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;

	public ProductListing loggingIn(String userName, String pass) {
		
		userEmail.sendKeys(userName);
		userPassword.sendKeys(pass);
		login.click();
		ProductListing plp = new ProductListing(driver);
		return plp;
	}
	
	public void goTo(String URL) {
		driver.get(URL);
	}
	
	public String checkErrorMessage(){
		waitUntilVisibility(errorMessage);
		String message = errorMessage.getText();
		return message;
	}

}
