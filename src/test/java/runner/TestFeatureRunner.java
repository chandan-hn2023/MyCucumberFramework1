package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources1/features", 
		glue = {"stepdefinitions","hooks"},
		tags="@all",
		publish=true,
		plugin = { "pretty", "html:target/CucumberReports/CucumberReport.html",
		             "json:target/CucumberReports/CucumberReport.json",
		             "testng:target/CucumberReports/CucumberReport.xml"}
		)

//Inbuilt Cucumber cant scan TestNG code so we use "AbstractTestNGCucumberTests"
public class TestFeatureRunner extends AbstractTestNGCucumberTests {

}

