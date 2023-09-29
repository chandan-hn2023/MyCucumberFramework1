package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	
	WebDriver driver;
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "HP LP3065")
	WebElement validHpProduct;
	
	@FindBy(xpath = "//p[text()='There is no product that matches the search criteria.']")
	WebElement productsDontMatchWarningMessage;
	
	public String showValidHpProduct() {
		return validHpProduct.getText();
	}
	
	public String showProductsDontMatchWarningMessage() {
		return productsDontMatchWarningMessage.getText();
	}
	

}
