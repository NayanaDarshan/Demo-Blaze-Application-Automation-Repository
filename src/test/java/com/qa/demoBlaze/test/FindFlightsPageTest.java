package com.qa.demoBlaze.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.demoBlaze.base.BaseTest;

public class FindFlightsPageTest extends BaseTest{
	

	@BeforeClass
	public void FindFlightsPageSetup() {
		findflightspage=welcomepage.doClickFindFlightsBtn();
	}
	
	@Test(priority=1)
	public void verifyChooseFlightTest() {
		findflightspage.doClickChooseFlight();
		Assert.assertTrue(true);
	}
}
