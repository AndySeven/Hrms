package com.hrms.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	/**
	 * Method set up the driver's properties for browser and run the corresponding
	 * browser
	 */
	public static WebDriver setUp() {
		ConfigsReader.readConfigs(Constants.PROPERTIES_FILE_PATH);
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		String headless = ConfigsReader.getValueOfProperty("headless");
		System.out.println(headless+" first check");
		
		
		switch (ConfigsReader.getValueOfProperty("browser").toLowerCase()) {
	
		case "chrome":
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions cOption = new ChromeOptions();
			if(headless.equalsIgnoreCase("true")) {
			// headless browser for jenkins
				cOption.setHeadless(true);
				System.out.println(headless+" second check check");
				driver = new ChromeDriver();
			}else {
				driver = new ChromeDriver();
			}
			
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("browser is not supported");
		}
		driver.manage().window().maximize();
		
		// driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME,TimeUnit.SECONDS);
		driver.get(ConfigsReader.getValueOfProperty("url"));
		PageInitializer.initialize();										 // initialize all page objects of setUpBrowser
		return driver;

	}

	/**
	 * Method close the browser session
	 */
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
