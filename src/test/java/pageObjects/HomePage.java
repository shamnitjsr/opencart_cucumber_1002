package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement lnkMyaccount;

	@FindBy(linkText = "Register")
	WebElement lnkRegister;

	@FindBy(linkText = "Login")
	WebElement lnkLogin;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement txtSearchbox;

	@FindBy(xpath = "//div[@id='search']//button[@type='button']")
	WebElement btnSearch;

	public void clickMyAccount() {
		lnkMyaccount.click();
	}

	public void clickRegister() {
		lnkRegister.click();
	}

	public void clickLogin() {
		lnkLogin.click();
	}

	public void enterProductName(String pName) {
		txtSearchbox.sendKeys(pName);
	}

	public void clickSearch() {
		btnSearch.click();
	}

}
