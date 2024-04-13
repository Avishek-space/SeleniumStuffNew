package AvishekLearning;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AvishekLearning.ReusableThings.ReusableClass;

public class MyOrdersPage extends ReusableClass {


	public MyOrdersPage(WebDriver driver2) { 
		super(driver2);
		PageFactory.initElements(driver2, this);
	}


	@FindBy(xpath = "//tbody/tr/td[2]")
	List<WebElement> orderList;
	
	@FindBy(css = ".table-responsive")
	WebElement listTable;
	
	
//	public boolean validateOrder(String order) {
//		waitUntilVisibility(listTable);
//		boolean flag = orderList.stream().anyMatch(a -> a.getText().equalsIgnoreCase(order));
//		return flag;
//	}


	public boolean validateOrder(String desiredProduct) {
		waitUntilVisibility(listTable);
		boolean flag = orderList.stream().anyMatch(a -> a.getText().equalsIgnoreCase(desiredProduct));
		return flag;
		
	}
	
}
