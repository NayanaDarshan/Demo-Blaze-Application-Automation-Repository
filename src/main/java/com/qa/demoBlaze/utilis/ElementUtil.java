package com.qa.demoBlaze.utilis;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * 
 * @author nayana.raghu
 *
 */

public class ElementUtil {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * this is used to create the webelement on the basis of given By locator
	 * 
	 * @param locator
	 * @return webelement
	 */
	public WebElement getElement(By locator) {
		return driver.findElement(locator);

	}

	/*
	 * This method used to enter the text in textfield
	 */
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	/*
	 * This method is used to click on the buttons
	 */
	public void doClick(By locator) {
		getElement(locator).click();
	}

	/*
	 * This method used to enter the text in textfield using Actions class
	 */
	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}

	/*
	 * This method is used to perform the Click operation using Actions class
	 * 
	 */
	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}

	/*
	 * The method is used to get text of weblement using Locators
	 */
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	/*
	 * This method returns boolean and to verify the WebElement is displayed in webpage
	 */
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	/*
	 * 
	 * This method us used to click on specific Link from the list of links
	 */
	public void doLinkClick(List<WebElement> linksList, String value) {
		System.out.println(linksList.size());
		for (WebElement ele : linksList) {
			String text = ele.getText();
			System.out.println(text);

			if (text.equals(value)) {
				ele.click();
				break;
			}
		}
	}
	/*
	 * 
	 * This method is used to get the available Links count in webpage
	 */

	public int getLinkListSize(By Locator) {

		List<WebElement> linknames = driver.findElements(Locator);
		int size = linknames.size();
		return size;
	}

	/*
	 * This method is used to get all the WebElements in webpage using Locator
	 */
	public List<WebElement> getElements(By Locator) {
		WebElement ele = getElement(Locator);

		List<WebElement> ele1 = driver.findElements(Locator);
		return ele1;
	}

	/*
	 * This method is used to enter the text in textfield using Keyboard actions
	 */
	public void doEnterKey(By Locator) {
		WebElement ele = getElement(Locator);
		Actions act = new Actions(driver);
		act.sendKeys(ele, Keys.ENTER).build().perform();
	}

	// ****************************drop down utility using Select class********************************
	public void selectDropDownValueByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}

	public void selectDropDownValueByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void selectDropDownValueByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		return optionsList.size();
	}

	public List<String> getDropDownOptionsValues(By locator) {
		List<String> textList = new ArrayList<String>();
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();

		for (WebElement ele : optionsList) {
			String text = ele.getText();
			textList.add(text);
		}

		return textList;
	}

	public void selectValueFromDropDownWithOutSelect(By locator, String value) {
		List<WebElement> countryList = driver.findElements(locator);

		for (WebElement ele : countryList) {
			String text = ele.getText();
			System.out.println(text);
			if (text.equals(value)) {
				ele.click();
				break;
			}
		}
	}

	// *****************************wait utils
	// ************************************

	public List<WebElement> visibilityofAllElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void getPageLinksText(By locator, int timeOut) {
		visibilityofAllElements(locator, timeOut).stream().forEach(ele -> System.out.println(ele.getText()));
	}

	public WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public String waitForTitlePresent(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(titleValue));
		return driver.getTitle();
	}

	public WebElement waitForElementToBeVisible(By locator, int timeOut) {
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(element));

	}

	public boolean waitForUrl(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlContains(url));
	}

	public Alert waitForAlertToBePresent(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public WebElement waitForElementToBeClickable(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void clickWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	public WebElement waitForElementWithFluentWait(By locator, int timeOut, int interval) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(interval)).ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public String getTitleName() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

}
