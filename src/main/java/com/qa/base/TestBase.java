package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  WebDriverWait wait;
	
	public TestBase()
	{
		
		try {
			 prop=new Properties();
			FileInputStream fis=new FileInputStream("/Users/chaitu/workspace/e-commerce-automation/src/main/java/com/qa/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
	public static void initialization()
	{
		System.setProperty("webdriver.chrome.driver","/Users/chaitu/workspace/Selenium_Automation/ChromeDriver.exe/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		System.out.println(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
	}
	
}
