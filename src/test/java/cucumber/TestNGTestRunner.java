package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//cucumber provides everything but for running it depends on testng or junit
@CucumberOptions(features = "src/test/java/cucumber", glue = "rahulshettyacademy.stepDefinitions", monochrome = true, tags = "@Regression", plugin = {
		"html:taget/cucumber.html" })
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
