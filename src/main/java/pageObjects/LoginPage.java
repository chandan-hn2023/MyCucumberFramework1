package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="input-email")
	WebElement emailField;
	
	@FindBy(id ="input-password")
	WebElement passwordField;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;	
	
	@FindBy(css = "div[class*='alert-dismissible']")
	WebElement loginWarningMessage;
	
	public void enterEmailAddress(String emailtext) {
		emailField.sendKeys(emailtext);
	}

	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}
	
	public String ShowloginWarningMessage() {
		return loginWarningMessage.getText();
		
	}
}
