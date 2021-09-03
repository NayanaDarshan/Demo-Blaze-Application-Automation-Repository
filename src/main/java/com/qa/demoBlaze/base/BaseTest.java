package com.qa.demoBlaze.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.demoBlaze.pages.FindFlightsPage;
import com.qa.demoBlaze.pages.PurchasePage;
import com.qa.demoBlaze.pages.WelcomePage;

/**
 * author nayana raghu
 */

public class BaseTest {

	public WebDriver driver;

	public BasePage basepage;

	public WelcomePage welcomepage;

	public Properties prop;

	public FindFlightsPage findflightspage;

	public PurchasePage purchasepage;

	/*
	 * 
	 * This method is used to initialized the driver 
	 */

	@BeforeTest
	public void setup() {
		basepage = new BasePage();
		prop = basepage.init_properties();
		driver = basepage.init_driver(prop);
		welcomepage = new WelcomePage(driver);	
		
	}
/*
 * 
 * This method is used to quit the browser
 */
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
