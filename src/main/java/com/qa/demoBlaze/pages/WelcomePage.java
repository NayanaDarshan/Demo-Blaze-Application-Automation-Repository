package com.qa.demoBlaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.demoBlaze.base.BasePage;
import com.qa.demoBlaze.utilis.ElementUtil;

/**
 * 
 * @author nayana.raghu
 *
 */

public class WelcomePage extends BasePage {
	
	private WebDriver driver;

	ElementUtil elementutil;

	/*
	 * By Locators or Object repository
	 */

	private By welcomePageHeader = By.xpath("//h1[text()='Welcome to the Simple Travel Agency!']");
	private By destinationWeekLink = By.xpath("//a[text()='destination of the week! The Beach!']");
	private By depatureCitydropdown = By.xpath("//select[@name='fromPort']");
	private By toCitydropdown = By.xpath("//select[@name='toPort']");
	private By findFlightsBtn = By.xpath("//input[@type='submit']");

	/*
	 * Constructors of Welcome Page:
	 */
	public WelcomePage(WebDriver driver) {
		elementutil = new ElementUtil(driver);
		this.driver=driver;

	}

	/*
	 * Page Actions
	 */

	/*
	 * This method to get WebElement
	 * 
	 * returns WebElement
	 */

	private WebElement getWebElement(By Locator) {
		return elementutil.getElement(Locator);
	}

	/*
	 * This method to get Welcome Page header
	 * 
	 * returns String
	 */
	public String getWelcomepageheader() {
		return getWebElement(welcomePageHeader).getText();
	}

	/*
	 * This method to get Welcome Page title
	 * 
	 * returns String
	 */

	public String getWelComePageTitle() {
		return elementutil.getTitleName();
	}

	/*
	 * This method to verify Find Flights Button is displayed
	 * 
	 * returns boolean
	 */
	public boolean isFindFlightsBtnExist() {
		return elementutil.getElement(findFlightsBtn).isDisplayed();
	}

	/*
	 * 
	 * This method is used to select departure city from
	 * " Choose your departure city: drop down"
	 */

	public void departureCityselect(String cityName) {

		elementutil.selectDropDownValueByValue(depatureCitydropdown, cityName);
		elementutil.waitForElementPresent(depatureCitydropdown, 2000);
	}

	/*
	 * This method is used to select destination city from
	 * " Choose your destination city: drop down"
	 * 
	 */

	public void destinationCitySelect(String cityName) {

		elementutil.selectDropDownValueByValue(toCitydropdown, cityName);
		elementutil.waitForElementPresent(toCitydropdown, 2000);
	}

	/*
	 * This method is used to click on Find Flights after departure city and
	 * destination city selection
	 * 
	 * returns FindFlightsPage Object
	 */

	public FindFlightsPage doClickFindFlightsBtn() {
		elementutil.doClick(findFlightsBtn);
		return new FindFlightsPage(driver);
	}
}
