package com.qa.demoBlaze.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author nayana.raghu
 *
 */

public class BasePage {

	public static WebDriver driver;

	public static Properties prop;
	
	/**
	 * This method is used to Initialize the WebDriver on the basis of given browserName
	 * @param browserName
	 * @return this method returns driver
	 */

	public WebDriver init_driver(Properties prop) {
		
		String browserName=prop.getProperty("browser");

		System.out.println("Browser name is ==>" + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		}

		else if (browserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		}

		else {
			System.out.println("Please do enter the correct browser name===>" + browserName);
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;

	}

	/**
	 * This method is used to get the properties values from Congfiguration File.
	 * @return prop
	 */
	public Properties init_properties() {

		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream("./src/main/java/com/qa/demoBlaze/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;
	}

}
