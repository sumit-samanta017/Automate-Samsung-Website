package StepDefinitions;


import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.ComparePage;
import com.pages.HomePage;
import com.utilities.ConfigReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompareSteps {
	
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private ConfigReader configReader;
	private ComparePage comparePage;
	
	@Given("^user is already on Home page$")
	public void user_is_already_on_Home_page() {
		
		configReader = new ConfigReader();
		String url = configReader.initPropFile().getString("url");
		
		DriverFactory.getDriver().navigate().to(url);
		comparePage = homePage.onComparePage();
		
	}
	

	@When("^user selects particular mobiles from the available particular dropdowns$")
	public void user_selects_particular_mobiles_from_the_available_particular_dropdowns() throws InterruptedException {
	    
		
		comparePage.selectFromFirstDropDown();
		comparePage.selectFromSecondDropDown();
		comparePage.selectFromThirdDropDown();
		
	}

	@And("^user clicks on view more option$")
	public void user_clicks_on_view_more_option() {
		
		comparePage.selectViewMoreOption();
	    
	}

	@Then("^user should be able to see the whole comparision list$")
	public void user_should_be_able_to_see_the_whole_comparision_list() {
	    
		comparePage.viewSpecDifferences();
		
	}
	
	@And("^user clicks on buy now option$")
	public void user_clicks_on_buy_now_option() {
		
		comparePage.clickBuyNow();
		
	}
	
	@Then("^user is on add to cart page$")
	public void user_is_on_go_to_cart_page() {
		
		boolean checkGoToCartPage = DriverFactory.getDriver().getCurrentUrl().contains("buy");
		Assert.assertTrue(checkGoToCartPage);
		System.out.println("User is on go to cart page");
		
	}

}
