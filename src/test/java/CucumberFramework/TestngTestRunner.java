package CucumberFramework;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\CucumberFramework\\EndToEnd.feature", glue = "AvishekLearning.CucumberStepDefinations", 
monochrome = true, tags = "@Regression", plugin = {"html:CucumberReport/Cucumber.html"} )
public class TestngTestRunner extends AbstractTestNGCucumberTests {

}
