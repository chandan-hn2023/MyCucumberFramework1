package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {
	
	WebDriver driver;
	
	@Before
	public void Startup() {
		Properties prop = ConfigReader.initializePropertiesFile();
		driver = DriverFactory.InitializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
	}
	
	@After
	public void teardown(Scenario scenario) {
		
		String scenarioName = scenario.getName().replace(" ", "_");
		
		if(scenario.isFailed()) {
			byte[] src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", scenarioName);
		}
		
		driver.quit();
	}

}
