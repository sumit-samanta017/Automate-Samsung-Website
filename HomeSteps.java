package StepDefinitions;



import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.HomePage;
import com.utilities.ConfigReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {
	
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private ConfigReader configReader;

	@Given("^when user is on home page$")
	public void when_user_is_on_home_page() {
		
		configReader = new ConfigReader();
		String url = configReader.initPropFile().getString("url");
		DriverFactory.getDriver().navigate().to(url);
		homePage.acceptAllCookies();
		
	}

	@When("^user moves to mobile option$")
	public void user_moves_to_mobile_option() {
		
		homePage.goToMobileOption();
		
	}

	@And("^user moves to smartphone option and click on compare$")
	public void user_moves_to_smartphone_option_and_click_on_compare() {
		
		homePage.goToSmartPhoneOption();
		homePage.clickOnCompare();
		
	}

	@Then("^user is on compare page$")
	public void user_should_be_navigated_to_compare_page() {
		
		boolean checkComparePage = DriverFactory.getDriver().getCurrentUrl().contains("compare");
		Assert.assertTrue(checkComparePage);
		System.out.println("User has landed in compare page");
		
	}

}
