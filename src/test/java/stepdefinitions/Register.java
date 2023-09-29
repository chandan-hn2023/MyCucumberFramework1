package stepdefinitions;

import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountSuccessPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import utils.CommonUtils;

public class Register {
	
	WebDriver driver;
	HomePage hp;
	RegisterPage rp;
	AccountSuccessPage asp;
	@Given("^User navigates to Register Account page$")
	public void User_navigates_to_Register_Account_page() {
		driver = DriverFactory.getDriver();
		hp = new HomePage(driver);
		hp.clickOnMyAccount();
		rp = hp.selectRegister();	
	}

	@When("User enter following inputs")
	public void User_enter_following_inputs(DataTable dataTable) {
		Map<String,String> datamap = dataTable.asMap(String.class,String.class);	
		rp.enterFirstname(datamap.get("firstname"));
		rp.enterLastName(datamap.get("lastname"));
		rp.enterEmail(CommonUtils.getEmailWithTimeStamp()); //Should always be a new email so TimeStamp concept
		rp.enterTelephoneNumber(datamap.get("telephone"));
		rp.enterpasswordField(datamap.get("password"));
		rp.enterConfirmPassword(datamap.get("confirmpassword"));	
	} 
	
	@When("User enter following inputs along with a duplicate email")
	public void user_enter_following_inputs_along_with_a_duplicate_email(DataTable dataTable) {
		Map<String,String> datamap = dataTable.asMap(String.class,String.class);
		rp.enterFirstname(datamap.get("firstname"));
		rp.enterLastName(datamap.get("lastname"));
		rp.enterEmail(datamap.get("email")); //Should always be an Existing Email
		rp.enterTelephoneNumber(datamap.get("telephone"));
		rp.enterpasswordField(datamap.get("password"));
		rp.enterConfirmPassword(datamap.get("confirmpassword"));		
	}
	
	@And("Select Yes for News Letter RadioButton")
	public void Select_Yes_for_News_Letter_RadioButton() {
		rp.clickOnNewsletterRadioButton();
	}
	
	@And("Selects Privacy Policy field")
	public void Selects_Privacy_Policy_field() {
		rp.clickOnPrivacyPolicyCheckbox();	
	}
	
	@And("Clicks on Continue button")
	public void Clicks_on_Continue_button() {
		asp = rp.clickOnContinueButton();
	}
	
	@Then("Account should get successfully created")
	public void Then_Account_should_get_successfully_created() {
		String registeredSuccessfullyMessage = asp.showAccountRegisteredSuccessfullyMessage();
		Assert.assertEquals(registeredSuccessfullyMessage, "Your Account Has Been Created!");
	}
	
	@When("User dont enter any fields")
	public void When_User_dont_enter_any_fields() {
		rp.clickOnContinueButton();
	}
	
	@Then("Warning messages should be displayed for the mandatory fields")
	public void Then_Warning_messages_should_be_displayed_for_the_mandatory_fields() {
		String privacyPolicyCheckboxWarningMessage = rp.showPrivacyPolicyCheckboxWarningMessage();
		Assert.assertEquals(privacyPolicyCheckboxWarningMessage, "Warning: You must agree to the Privacy Policy!");
		
		String firstNameWarningmessage = rp.showFirstNameWarningmessage();
		Assert.assertEquals(firstNameWarningmessage, "First Name must be between 1 and 32 characters!");
		
		String lastNameWarningmessage = rp.showLastNameWarningmessage();
		Assert.assertEquals(lastNameWarningmessage, "Last Name must be between 1 and 32 characters!");
		
		String emailWarningmessage = rp.showEmailWarningmessage();
		Assert.assertEquals(emailWarningmessage, "E-Mail Address does not appear to be valid!");
		
		String telephoneWarningMessage = rp.showTelephoneWarningMessage();
		Assert.assertEquals(telephoneWarningMessage, "Telephone must be between 3 and 32 characters!");
		
		String passwordWarningMessage = rp.showPasswordWarningMessage();
		Assert.assertEquals(passwordWarningMessage, "Password must be between 4 and 20 characters!");
		
	}
	
	@Then("Account already exist warning message should be displayed")
	public void Then_Account_already_exist_warning_message_should_be_displayed() {
		String accountAlreadyExistsWarningMessage = rp.showAccountAlreadyExistsWarningMessage();
		Assert.assertEquals(accountAlreadyExistsWarningMessage, "Warning: E-Mail Address is already registered!");
		
	}
	
}
