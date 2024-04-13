package AvishekLearning;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import AvishekLearning.BaseTest.GlobalConfiguration;

public class ErrorValidation extends GlobalConfiguration {
	
	@Test
	public void errorCheckUp() {
		String userName = "avi1234@gmail.com";
		String pass = "Avijanu1233445!";
//		String desiredProduct = "ADIDAS ORIGINAL";
		System.out.println("Now my turn"); 
		ProductListing plp = land.loggingIn(userName, pass);
		Assert.assertEquals(land.checkErrorMessage(), "Incorrect email or password.h");
				 
}
	
}
