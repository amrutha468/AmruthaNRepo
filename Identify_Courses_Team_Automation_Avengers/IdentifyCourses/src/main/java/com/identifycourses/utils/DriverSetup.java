package com.identifycourses.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSetup {
	public static WebDriver driver;
	
	/***********************************----INTIALIZING WEB DRIVER----****************************************/
	public static WebDriver getDriver()
	{
		if(Read_Properties.obj.getProperty("Browser").equals("Chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+Read_Properties.obj.getProperty("chromeDriverPath"));
			driver = new ChromeDriver(options);
		}
		else if(Read_Properties.obj.getProperty("Browser").equals("Firefox"))
		{
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+Read_Properties.obj.getProperty("firefoxDriverPath"));
			driver = new FirefoxDriver(options);
		}
		driver.manage().window().maximize();
		driver.get(Read_Properties.obj.getProperty("url"));
		return driver;
	}
}
