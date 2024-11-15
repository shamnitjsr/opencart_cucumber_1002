package hooks;

import java.io.IOException;
import java.util.Properties;

import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks{

	WebDriver driver;
	Properties p;

	@BeforeStep
	public void setup() throws IOException {
		driver = BaseClass.initilizeBrowser();

		p = BaseClass.getProperties();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}

	@After
	public void tearDown(Scenario scenario) {
		driver.quit();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {

		// this is for cucumber junit report
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "img/png", scenario.getName());
		}
	}

}
