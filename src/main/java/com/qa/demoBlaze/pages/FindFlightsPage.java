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
public class FindFlightsPage extends BasePage {
	
    private WebDriver driver;
	ElementUtil elementutil;

	/*
	 * By Locators Object Repositories
	 */

	private By findFlightsPageheader = By.xpath("//h3[text()='Flights from Boston to Rome: ']");

	private By chooseFlight = By.xpath("//td[text()='United Airlines']//ancestor::tr//td//input[@type='submit']");

	/*
	 * Constructor
	 */

	public FindFlightsPage(WebDriver driver) {
		elementutil= new ElementUtil(driver);
		this.driver=driver;
	}

	/*
	 * Page Actions
	 */

	/*
	 *This method is used to verify Find Flights Page header
	 *
	 * returns String
	 */
	public String verifyFindFlightsPageHeader() {

		return elementutil.doGetText(findFlightsPageheader);

	}
	/*
     * This method is used to click on Choose Flight button
     * 
	 * returns PurchasePage Object
	 */

	public PurchasePage doClickChooseFlight() {
        
		elementutil.doActionsClick(chooseFlight);
		
       return new PurchasePage(driver);		
	}

}
