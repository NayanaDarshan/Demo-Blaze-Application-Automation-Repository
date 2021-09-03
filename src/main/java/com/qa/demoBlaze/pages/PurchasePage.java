package com.qa.demoBlaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.demoBlaze.utilis.ElementUtil;
/***
 * 
 * @author nayana.raghu
 *
 */
public class PurchasePage {
	
	private WebDriver driver;
	ElementUtil elementutil;
	
	/*
	 * By Locators- OR
	 */
	
	private By name = By.xpath("//input[@id='inputName']");
	private By address= By.xpath("//input[@id='address']");
	private By city =By.xpath("//input[@id='city']");
	private By state=By.xpath("//input[@id='state']");
	private By zipcode=By.xpath("//input[@id='zipCode']");
	private By creditCardNumber= By.xpath("//input[@id='creditCardNumber']");
	private By NameOnCard=By.xpath("//input[@id='creditCardNumber']");
	private By purchaseFlightBtn=By.xpath("//input[@value='Purchase Flight']");
	private By confirmationID= By.xpath("(//tr//td)[2]");
	
	
	/*
	 * Constructor of Purchase page class
	 */
	public PurchasePage(WebDriver driver) {
		
		elementutil= new ElementUtil(driver);
		this.driver=driver;
	}
	
/*
 * This is a method to get the title of purchase page
 * 
 * return String
 */
	public String getPurchasePageTitle() {
		
		return elementutil.getTitleName();
		
	}
	
	/*
	 * This method is used to fill the user details in Purchase Form
	 * 
	 */
	
	public void doFillPurchaseForm(String name, String address, String city,String state, String zipcode, 
			String creditCardNumber, String NameOnCard) {
		
		
		elementutil.doSendKeys(this.name, name);
		elementutil.doSendKeys(this.address, address);
		elementutil.doSendKeys(this.city, city);
		elementutil.doSendKeys(this.state, state) ;
		elementutil.doSendKeys(this.zipcode, zipcode);
		elementutil.doSendKeys(this.creditCardNumber, creditCardNumber);
		elementutil.doSendKeys(this.NameOnCard, NameOnCard);
        elementutil.waitForElementPresent(purchaseFlightBtn, 2000);
		
	}
	/*
	 * This method returns the confirmation Page object
	 * 
	 */
	
	public void doClickPurchaseBtn() {
		elementutil.doClick(purchaseFlightBtn);		
	
	}
	
	public String getConfirmationID() {
		return elementutil.doGetText(confirmationID);
		
	}
	
	
}
