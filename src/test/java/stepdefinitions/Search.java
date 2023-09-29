package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.SearchResultsPage;

public class Search {
	
	WebDriver driver;
	HomePage hp;
	SearchResultsPage srp;
	
	@Given("^User opens the application$")
	public void user_opens_the_application() {
		driver = DriverFactory.getDriver();
	}

	@When("User enter existing product {string} in Search field")
	public void user_enter_existing_product_in_search_field(String exisitingProductText) {
		HomePage hp = new HomePage(driver);
		hp.enterProductNameInSearchbar(exisitingProductText);
	}

	@And("^User click on Search button$")
	public void user_click_on_search_button() {
		HomePage hp = new HomePage(driver);
		srp = hp.clickOnsearchButton();
	}

	@Then("^Existing product should be displayed in search results$")
	public void existing_product_should_be_displayed_in_search_results() {
		String validHpProduct = srp.showValidHpProduct();
		Assert.assertEquals(validHpProduct, "HP LP3065");
	}

	@When("User enter non-existing product {string} in Search field")
	public void user_enter_non_existing_product_in_search_field(String nonExisitingProductText) {
		HomePage hp = new HomePage(driver);
		hp.enterProductNameInSearchbar(nonExisitingProductText);
	}

	@Then("^Products not matching error message should be displayed$")
	public void products_not_matching_error_message_should_be_displayed() {
		String productsDontMatchWarningMessage = srp.showProductsDontMatchWarningMessage();
		Assert.assertEquals(productsDontMatchWarningMessage, "There is no product that matches the search criteria.");
	}

	@When("^User dont enter any product in Search field$")
	public void user_dont_enter_any_product_in_search_field() {

	}

}
