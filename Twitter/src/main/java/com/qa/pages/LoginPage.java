package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	Select select;

	// Page Factory- Object Repository
	@FindBy(xpath = "//*[@class='js-username-field']")
	WebElement usernameTxt;

	@FindBy(xpath = "//*[@class='js-password-field']")
	WebElement passwordTxt;

	@FindBy(xpath = "//*[@class='submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//*[@id='menu-0']")
	WebElement languageSelect;

	@FindBy(xpath = "//*[@id='supported_languages']/li/a[contains[text(),'Español']]")
	WebElement languageSelectDropdown;

	@FindBy(xpath = "//*[contains[text(),'Español']]")
	WebElement languageVisibility;
	

	// Initializing the Page Objects
	public void loginPage() {
		// PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, this); // this here reference to
												// current class object
	}

	// Actions of Page:-
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLanguagePresense() throws InterruptedException {
		Thread.sleep(3000);
		return languageSelect.isDisplayed();
	}

	public  boolean validateLanguageChange() {
		select = new Select(languageSelect);
		select.selectByVisibleText(languageSelectDropdown.getText());
		return languageVisibility.isDisplayed();
	}

	public HomePage login(String uname, String pwd) {
		usernameTxt.sendKeys(uname);
		usernameTxt.sendKeys(pwd);
		submitBtn.click();
		return new HomePage();
	}

}
