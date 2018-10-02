package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.util.TestUtil;

public class TestBase extends TestUtil {
	public static Properties prop; // make it static to access in methods without
							// creating any object.
	public static WebDriver driver;

	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\RaviAutomtion\\Twitter\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initializeBrowser() {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
			driver=new ChromeDriver();
			
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("geckoDriverPath"));
			driver=new FirefoxDriver();
			
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", prop.getProperty("internetExplorerDriverPath"));
			driver=new InternetExplorerDriver();
			
		} else {
			System.out.println("Enter any Brwoser name");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));

	}
}
