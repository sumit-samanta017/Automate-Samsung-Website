package hooks;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class AppHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	private ResourceBundle bundle;
	
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		bundle = configReader.initPropFile();
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		String browserName = bundle.getString("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.initDriver(browserName);
	}
	
	@After(order = 0)
	public void closeBrowser() {
		driver.quit();
	}
}
