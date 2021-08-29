package com.utilities;


import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UtilClass {

	private Wait<WebDriver> wait;
	private Actions actions;
	private JavascriptExecutor jsExecutor;


	public void provideActionHover(WebDriver driver, WebElement element) {

		actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}

	public void provideJSExecutorClick(WebDriver driver, WebElement element) {

		jsExecutor = (JavascriptExecutor)driver;

		try {

			jsExecutor.executeScript("arguments[0].click();", element);

		}catch(ElementClickInterceptedException e) {
			wait = new WebDriverWait(driver, 10);
			WebElement until = wait.until(ExpectedConditions.elementToBeClickable(element));
			jsExecutor.executeScript("arguments[0].click()", until);
		}

	}

	public void provideJSExecutorScroll(WebDriver driver) {

		jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("window.scroll(0,3000);");

	}

	public void doClick(WebElement element) {

		element.click();	
	}

	public void clickElementAfterVisibility(WebDriver driver, long time, WebElement element) {

		wait = new WebDriverWait(driver, time);

		try {
			wait.until(ExpectedConditions.visibilityOf(element)).click();
		}catch(StaleElementReferenceException | ElementClickInterceptedException e) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}


	}

	public void provideSleep() {
		try {
			Thread.sleep(1500);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void provideClickForDynamicElements(WebDriver driver, String xpathVal) {

		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(3000)).pollingEvery(Duration.ofMillis(500)).
				ignoring(StaleElementReferenceException.class);

		try {

			wait.until(new Function<WebDriver, WebElement>() {

				@Override
				public WebElement apply(WebDriver driver) {
					driver.findElement(By.xpath(xpathVal)).click();;
					return null;
				}

			});

		}catch(NoSuchElementException | TimeoutException e) {
			//			System.out.println("Exceptions caught");
		}

	}

	public void doSpecDifferences(List<WebElement> categorySpecsList) {

		Set<String> set = new LinkedHashSet<>();
		List<String> list = new ArrayList<>();
		int count = 0;
		String specs = "";

		for(int i=0; i<categorySpecsList.size(); i++) {

			specs = categorySpecsList.get(i).getText();
			set.add(specs);
			list.add(specs);
			count++;

			if(count >= 3) {
				
				if(set.size() <= 1) {
					set.clear();
					list.clear();
					count = 0;
				}
				else {
					System.out.println();
					for(int j=0; j<list.size(); j++) {
						System.out.print(list.get(j));
						if(j != 2) System.out.print(" || ");
					}
					set.clear();
					list.clear();
					count = 0;
				}
				
			}
		}

	}

	public void doBuyNowOperation(WebDriver driver, WebElement element) {

		jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("window.scroll(0,-250)");

		actions = new Actions(driver);
		actions.moveToElement(element).click().perform();

	}

	public void doCalculation(WebElement totalToBePaid, WebElement actual, WebElement gst, WebElement discount) {

		String totalPaymentString = totalToBePaid.getText();
		String actualPriceString = actual.getText();
		String gstPaymentString = gst.getText();
		String discountString = discount.getText();

		String totalPay = "";
		String actualPay = "";
		String gstPay = "";
		String discountPay = "";

		double totalPriceToPay = 0.0;
		double actualPrice = 0.0;
		double gstPrice = 0.0;
		double discountPrice = 0.0;

		for(int i=1; i<totalPaymentString.length(); i++)
			if(totalPaymentString.charAt(i) != ',')
				totalPay += totalPaymentString.charAt(i);

		for(int i=1; i<actualPriceString.length(); i++) {
			if(actualPriceString.charAt(i) != ',')
				actualPay += actualPriceString.charAt(i);
			if(actualPriceString.charAt(i+1) == 32) break;
		}

		for(int i=1; i<gstPaymentString.length(); i++)
			if(gstPaymentString.charAt(i) != ',')
				gstPay += gstPaymentString.charAt(i);
		
		for(int i=1; i<discountString.length(); i++)
			if(discountString.charAt(i) != ',')
				discountPay += discountString.charAt(i);

		try {
			totalPriceToPay = Double.parseDouble(totalPay);
			actualPrice = Double.parseDouble(actualPay);
			gstPrice = Double.parseDouble(gstPay);
			discountPrice = Double.parseDouble(discountPay);
		}catch(NumberFormatException e) {
			System.out.println("Not valid value to format");
		}
		
		double priceWithoutGST = actualPrice-gstPrice;
		
		double calculatedPrice = priceWithoutGST-discountPrice+gstPrice;
		
		if(calculatedPrice == totalPriceToPay) {
			System.out.println("---------------------------------------------------------");
			System.out.println("Both prices are same");
			System.out.println("--------------------");
			System.out.println("Total price to be paid :-> Rs."+totalPriceToPay);
			System.out.println("Calculated price :-> Rs."+calculatedPrice);
			System.out.println("---------------------------------------------------------");
		}


	}

	public void provideActionClick(WebDriver driver, WebElement element) {

		actions = new Actions(driver);
		actions.moveToElement(element).click().perform();

	}

	public void provideActionClickDropDown(WebDriver driver, WebElement selectDropDown, WebElement selectMobileFromList) {

		actions = new Actions(driver);
		actions.moveToElement(selectDropDown).click().perform();
		actions.moveToElement(selectMobileFromList).click(selectMobileFromList).click().perform();

	}
}

