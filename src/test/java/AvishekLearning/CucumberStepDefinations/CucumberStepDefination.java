package AvishekLearning.CucumberStepDefinations;

import java.io.IOException;

import org.testng.Assert;

import AvishekLearning.CartPage;
import AvishekLearning.LandingPage;
import AvishekLearning.OrderPage;
import AvishekLearning.ProductListing;
import AvishekLearning.BaseTest.GlobalConfiguration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberStepDefination extends GlobalConfiguration {

	public LandingPage land;
	public ProductListing plp;
	public CartPage cp;
	public String displayedMessage;
	
	@Given("I landed on the Ecommerce login page")  // This is just a static statement with no arguments/value.
	public void landTOsite() throws IOException {
		land = launchApplication();
	}
	
	
	@Given("^Logged in with username (.+) and password (.+)$")  //Starts with "^" and end with "$" to say it is a regular expression.
	public void loginWithCredentials(String userName, String password) {
		 plp = land.loggingIn(userName, password);
	}
	
	@When("^I added a product (.+) to the cart$")
	public void addingProductToCart(String productName) throws InterruptedException {
		plp.addToCart(productName);
		cp = plp.goToCart();
	}
	
	@And("^Go to checkout product (.+) and submit the order$")
	public void checkingOutProduct(String productName) {
		OrderPage op = cp.checkOut(productName);
		displayedMessage = op.placeOrder();
	}
	
	@Then("the confirmation message {string} is displayed")// Whatever is there in place of {string} in the cucumber featuire file will be derived here. Also, this is static expression with a dynamic value which is placed inside the statement itself.
	public void checkingTheConfirmationMessage(String string) {
		Assert.assertEquals(displayedMessage, string);
		driver.close();
	}
	
	
}
