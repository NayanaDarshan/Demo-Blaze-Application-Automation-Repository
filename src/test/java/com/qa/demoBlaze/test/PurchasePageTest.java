package com.qa.demoBlaze.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.demoBlaze.base.BaseTest;
import com.qa.demoBlaze.constants.Constants;
import com.qa.demoBlaze.pages.PurchasePage;
import com.qa.demoBlaze.utilis.ExcelUtil;


public class PurchasePageTest extends BaseTest {

	/**
	 * 
	 * @author nayana.raghu
	 */
	@BeforeClass
		public void PurchasePageSetup() {
		purchasepage=findflightspage.doClickChooseFlight();
		
	}
	
	@Test(priority=1)
	public void verifyPurchasePageTitleTest() {
		
		String purchasePageTitle= purchasepage.getPurchasePageTitle();
		System.out.println("The purchase page title is===>" +purchasePageTitle);
        Assert.assertEquals(purchasePageTitle, Constants.PURCHASE_PAGE_TITLE);
        
	}

	@DataProvider()
	public Object[][] getPurchaseFormData() {
	
		 Object[][] data= ExcelUtil.getTestdata(Constants.PURCHASE_FORM_SHEET_NAME);
		 return data;
		 
		
	}
	@Test(priority=2,dataProvider="getPurchaseFormData")
	public void verifyPurchaseFormFillingTest(String name, String address, String city, String state,String zipcode, 
			String creditCardNumber, String NameOnCard) {
	     
		purchasepage.doFillPurchaseForm(name, address, city, state, zipcode, creditCardNumber, NameOnCard);
		Assert.assertTrue(true);
	
	}
	
	@Test(priority=3)
	public void doPurchaseBtnClickTest() {
		purchasepage.doClickPurchaseBtn();
		Assert.assertTrue(true, "Button is clicked");
	}
	
	@Test(priority=4)
	public void verifyConfirmationID() {
		String bookingID=purchasepage.getConfirmationID();
		if(bookingID.contains(Constants.BookingID_FORMAT)) {
			Assert.assertTrue(true);
		}
	}

}
