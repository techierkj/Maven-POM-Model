package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initializeBrowser();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login on Twitter");
	}

	@Test(enabled=false)
	public void LanguagePresenseTest() throws InterruptedException {
		Boolean flag = loginPage.validateLanguagePresense();
		Assert.assertTrue(flag);
	}

	@Test(enabled=false)
	public void LanguageChangeTest() {
		Boolean flag = loginPage.validateLanguageChange();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		// Here assigning value to HomePage class reference homePage
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
