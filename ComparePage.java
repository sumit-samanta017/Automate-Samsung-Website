package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.UtilClass;

public class ComparePage {

	private WebDriver driver;
	private UtilClass utilClass = new UtilClass();

	@FindBy(xpath = "//div[@class='pf-product-compare__table-head-inner']/div[2]/div/button")
	private WebElement firstDropDown;

	@FindBy(xpath = "//div[@class='pf-product-compare__table-head-inner']/div[2]//div[@class='scrollbar__wrap']//li[1]/button")
	private WebElement mobileFromFirstList;

	@FindBy(xpath = "//div[@class='pf-product-compare__table-head-inner']/div[3]/div/button")
	private WebElement secondDropDown;

	@FindBy(xpath = "//div[@class='pf-product-compare__table-head-inner']/div[3]//div[@class='scrollbar__wrap']//li[3]/button")
	private WebElement mobileFromSecondList;

	@FindBy(xpath = "//div[@class='pf-product-compare__table-head-inner']/div[4]/div/button")
	private WebElement thirdDropDown;

	@FindBy(xpath = "//div[@class='pf-product-compare__table-head-inner']/div[4]//div[@class='scrollbar__wrap']//li[4]/button")
	private WebElement mobileFromThirdList;

	@FindAll({@FindBy(xpath = "//div[@class='pf-product-compare__body-col-contents']/ul/li")})
	private List<WebElement> categorySpecsList;

	@FindBy(xpath = "//div[@class='pf-product-compare__body-col-cell col-option']/div[1]//a")
	private WebElement buyNow;


	public ComparePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectFromFirstDropDown() {
		
		utilClass.clickElementAfterVisibility(driver, 10, firstDropDown);
		
		utilClass.provideSleep();
		utilClass.provideJSExecutorClick(driver, mobileFromFirstList);;

	}

	public void selectFromSecondDropDown() {
		
		utilClass.clickElementAfterVisibility(driver, 10, secondDropDown);
		
		utilClass.provideSleep();
		utilClass.provideJSExecutorClick(driver, mobileFromSecondList);

	}

	public void selectFromThirdDropDown() {
		
		utilClass.clickElementAfterVisibility(driver, 10, thirdDropDown);
		
		utilClass.provideSleep();
		utilClass.provideJSExecutorClick(driver, mobileFromThirdList);

	}

	public void selectViewMoreOption() {

		String xpathVal = "//div[@class = 'pf-product-compare__cta-wrap compare-viewmore-cta']/a";

		utilClass.provideClickForDynamicElements(driver, xpathVal);
		utilClass.provideJSExecutorScroll(driver);

	}


	public void viewSpecDifferences() {

		utilClass.doSpecDifferences(categorySpecsList);

	}

	public void clickBuyNow() {
		utilClass.doBuyNowOperation(driver, buyNow);
	}

	public AddToCartPage onAddToCartPage() {

		selectFromFirstDropDown();
		selectFromSecondDropDown();
		selectFromThirdDropDown();
		
		selectViewMoreOption();
		viewSpecDifferences();
		clickBuyNow();

		return new AddToCartPage(driver);
	}


}
