package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.UtilClass;

public class HomePage {
	
	private WebDriver driver;
	private UtilClass utilClass = new UtilClass();
	
	
	@FindBy(css = "a[data-engname='mobile']")
	private WebElement allTypesOfMobiles;
	
	@FindBy(css = "a[data-engname='mobile:smartphones']")
	private WebElement smartPhones;
	
	@FindBy(css = "a[an-la='mobile:smartphones:compare']")
	private WebElement compare;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div[2]/div/div[2]/a")
	private WebElement acceptCookiesButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void acceptAllCookies() {
		
		utilClass.doClick(acceptCookiesButton);
		
	}
	
	public void goToMobileOption() {
		
		utilClass.provideActionHover(driver, allTypesOfMobiles);
		
	}
	
	public void goToSmartPhoneOption() {
		
		utilClass.provideActionHover(driver, smartPhones);
		
	}
	
	public void clickOnCompare() {
		
		utilClass.provideJSExecutorClick(driver, compare);
		
	}
	
	public ComparePage onComparePage() {
		
		acceptAllCookies();
		goToMobileOption();
		goToSmartPhoneOption();
		clickOnCompare();
		return new ComparePage(driver);
		
	}
	

}
