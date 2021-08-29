package StepDefinitions;

import com.factory.DriverFactory;
import com.pages.AddToCartPage;
import com.pages.ComparePage;
import com.pages.HomePage;
import com.utilities.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddToCartSteps {
	
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private ConfigReader configReader;
	private ComparePage comparePage;
	private AddToCartPage addToCartPage;
	
	@Given("^user is already on compare page$")
	public void user_is_already_on_compare_page() {
	    
		configReader = new ConfigReader();
		String url = configReader.initPropFile().getString("url");
		
		DriverFactory.getDriver().navigate().to(url);
		comparePage = homePage.onComparePage();
		addToCartPage = comparePage.onAddToCartPage();
		
	}

	@Given("^user clicks on continue button on the top right$")
	public void user_clicks_on_continue_button_on_the_top_right() {
	    
		addToCartPage.clickOnFirstContinueButton();
		
	}

	@Given("^user again clicks on another continue button on top right$")
	public void user_again_clicks_on_another_continue() {
	    
		addToCartPage.clickOnSecondContinueButton();
		
	}

	@Then("^user is on cart page$")
	public void user_should_is_on_cart_page() {
		
	    addToCartPage.getCalculation();
	    
	}

}
