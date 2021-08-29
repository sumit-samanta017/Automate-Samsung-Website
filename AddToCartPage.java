package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.UtilClass;

public class AddToCartPage {
	
	WebDriver driver;
	UtilClass utilClass = new UtilClass();
	
	@FindBy(css = "div.hubble-price-bar__price-cta>a")
	private WebElement firstContinueButton;
	
	@FindBy(xpath = "//div[@class='hubble-addon-page__product']//a")
	private WebElement secondContinueButton;
	
	@FindBy(xpath = "//div[@id='desktopBannerWrapped']/div//div[3]//button[1]")
	private WebElement notification;
	
	@FindBy(xpath = "//div[@class='order-p6-summary-price-details row-full for-desktop']/div[1]/div[1]/p[2]")
	private WebElement totalToBePaid;
	
	@FindBy(xpath = "//div[@class='order-p6-summary-price-details row-full for-desktop']/div[2]/div[2]/p[2]")
	private WebElement discount;
	
	@FindBy(xpath = "//div[@class='order-p6-summary-price-details row-full for-desktop']/div[2]/div[4]/p[2]")
	private WebElement gst;
	
	@FindBy(xpath = "//div[@class='order-p6-summary-price-details row-full for-desktop']/div[1]/div[2]/p[2]")
	private WebElement actualPrice;
	
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnFirstContinueButton() {
		utilClass.clickElementAfterVisibility(driver, 10, firstContinueButton);
	}
	
	public void clickOnSecondContinueButton() {
		utilClass.provideJSExecutorClick(driver, secondContinueButton);
		utilClass.clickElementAfterVisibility(driver, 10, notification);
	}
	
	public void getCalculation() {
		utilClass.doCalculation(totalToBePaid, actualPrice, gst, discount);
	}

	
}
