package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement MyAccount;
	
	@FindBy(linkText = "Login")
	WebElement Login;
	
	@FindBy(linkText = "Register")
	WebElement Register;
	
	@FindBy(name = "search")
	WebElement searchbar;
	
	@FindBy(css = "button[class*='btn-default']")
	WebElement searchButton;
	
	public LoginPage selectLogin() {
		Login.click();
		return new LoginPage(driver);
	}
	
	public void clickOnMyAccount() {
		MyAccount.click();
	}
	
	public RegisterPage selectRegister() {
		Register.click();
		return new RegisterPage(driver);
	}
	
	public void enterProductNameInSearchbar(String exisitingProductText) {
		searchbar.sendKeys(exisitingProductText);
	}
	
	public SearchResultsPage clickOnsearchButton() {
		searchButton.click();
		return new SearchResultsPage(driver);
	}
	
}
