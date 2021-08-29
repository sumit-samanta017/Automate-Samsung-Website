package com.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

	public static WebDriver driver;

	public WebDriver initDriver(String browser) {


		if(browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "E:\\Selenium Softwares\\Driver executables\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "E:\\Selenium Softwares\\Driver executables\\Edge\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();

		return driver;

	}

	public synchronized static WebDriver getDriver() {
		return driver;
	}

}
