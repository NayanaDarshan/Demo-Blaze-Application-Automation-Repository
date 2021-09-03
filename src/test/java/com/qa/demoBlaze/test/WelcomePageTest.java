package com.qa.demoBlaze.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.demoBlaze.base.BaseTest;
import com.qa.demoBlaze.constants.Constants;

public class WelcomePageTest extends BaseTest {

	@Test(priority = 1)
	public void verifyWelcomePageTitleTest() {
		String welcomePageTitleName = welcomepage.getWelComePageTitle();

		System.out.println("The welcome page title is:===>" + welcomePageTitleName);
		Assert.assertEquals(welcomePageTitleName, Constants.WELCOME_PAGE_TITLE);

	}

	@Test(priority = 2)
	public void verifyWelcomePageHeaderTest() {

		String welcomePageHeader = welcomepage.getWelcomepageheader();
		System.out.println("The welcome page header is===>" + welcomePageHeader);

		Assert.assertEquals(welcomePageHeader, Constants.WELCOME_PAGE_HEADER);
	}

	@Test(priority = 3)
	public void verifyDepartureCitySelectTest() {

		welcomepage.departureCityselect("Boston");

		Assert.assertTrue(true, "The depature city is selected from drop down");

	}

	@Test(priority = 4)
	public void verifyToCitySelectTest() {
		welcomepage.destinationCitySelect("Rome");

		Assert.assertTrue(true, "The destination city is selected from drop down");
	}

	@Test(priority = 5)
	public void verifyFindFlightsTest() {
		welcomepage.doClickFindFlightsBtn();
	}

}
