package stepdefinitions;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.CommonUtils;

public class Login {

	WebDriver driver;
	LoginPage lp;
	AccountPage ap;

	@Given("^User has navigated to Login page$")
	public void User_has_navigated_to_Login_page() {
		driver = DriverFactory.getDriver();
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccount();
		lp = hp.selectLogin();
	}

	// VALID CREDENTIALS

	@When("^User enters valid email address (.+)$")
	public void user_enters_valid_email_address(String emailtext) {
		lp.enterEmailAddress(emailtext);
	}

	@When("^Enters valid password (.+)$")
	public void enters_valid_password_password(String passwordText) {
		lp.enterPassword(passwordText);
	}

	@When("^Clicks on Login Button$")
	public void clicks_on_login_button() {
		ap = lp.clickOnLoginButton();
	}

	@Then("^User should be able to successfully login$")
	public void user_should_be_able_to_successfully_login() {
		Assert.assertTrue(ap.ShowLoginConfirmationMessage());
	}

	// INVALID CREDENTIALS

	@When("^User enters invalid email address$")
	public void user_enters_invalid_email_address() {
		lp.enterEmailAddress(CommonUtils.getEmailWithTimeStamp());
	}

	@When("^Enters invalid password \"(.+)\"$")
	public void enters_invalid_password(String invalidPasswordText) {
		lp.enterPassword(invalidPasswordText);
	}

	@Then("^An error message should be displayed$")
	public void an_error_message_should_be_displayed() {
		String warningMessage = lp.ShowloginWarningMessage();
		Assert.assertEquals(warningMessage, "Warning: No match for E-Mail Address and/or Password.");
	}

	@When("^User dont enter any credentials$")
	public void User_dont_enter_any_credentials() {
		lp.clickOnLoginButton();
	}
	


}
