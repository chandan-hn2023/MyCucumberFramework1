package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-firstname")
	WebElement firstNameField;
	
	@FindBy(id = "input-lastname")
	WebElement lastNameField;
	
	@FindBy(id = "input-email")
	WebElement emailField;
	
	@FindBy(id = "input-telephone")
	WebElement telephoneField;
	
	@FindBy(id = "input-password")
	WebElement passwordField;
	
	@FindBy(id = "input-confirm")
	WebElement confirmPasswordField;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value=1]")
	WebElement newsletterRadioButton;
	
	@FindBy(name = "agree")
	WebElement privacyPolicyCheckbox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueButton;
	
	@FindBy(css = "div[class*='alert-danger']")
	WebElement privacyPolicyCheckboxWarningMessage;
	
	@FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
	WebElement firstNameWarningMessage;
	
	@FindBy(xpath = "//div[text()='Last Name must be between 1 and 32 characters!']")
	WebElement lastNameWarningMessage;
	
	@FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
	WebElement emailWarningMessage;
	
	@FindBy(xpath = "//div[text()='Telephone must be between 3 and 32 characters!']")
	WebElement telephoneWarningMessage;
	
	@FindBy(xpath = "//div[text()='Password must be between 4 and 20 characters!']")
	WebElement passwordWarningMessage;
	
	@FindBy(css = "div[class*='alert alert-danger alert-dismissible']")
	WebElement accountAlreadyExistsWarningMessage;
	
	public void enterFirstname(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNametext) {
		lastNameField.sendKeys(lastNametext);
	}
	
	public void enterEmail(String emailtext) {
		emailField.sendKeys(emailtext);
	}
	
	public void enterTelephoneNumber(String telephoneNumberText) {
		telephoneField.sendKeys(telephoneNumberText);
	}
	
	public void enterpasswordField(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPasswordField.sendKeys(confirmPasswordText);
	}
	
	public void clickOnNewsletterRadioButton() {
		newsletterRadioButton.click();
	}
	
	public void clickOnPrivacyPolicyCheckbox() {
		privacyPolicyCheckbox.click();
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public String showPrivacyPolicyCheckboxWarningMessage() {
		return privacyPolicyCheckboxWarningMessage.getText();
	}
	
	public String showFirstNameWarningmessage() {
		return firstNameWarningMessage.getText();
	}
	
	public String showLastNameWarningmessage() {
		return lastNameWarningMessage.getText();
	}
	public String showEmailWarningmessage() {
		return emailWarningMessage.getText();
	}
	
	public String showTelephoneWarningMessage() {
		return telephoneWarningMessage.getText();
	}
	
	public String showPasswordWarningMessage() {
		return passwordWarningMessage.getText();
		
	}
	
	public String showAccountAlreadyExistsWarningMessage() {
		return accountAlreadyExistsWarningMessage.getText();
	}
	
	
}
