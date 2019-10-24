package com.qa.webpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class AuthenticationPage extends TestBase{
	
	
	public AuthenticationPage()
	{
		PageFactory.initElements(driver, this);
	}

	//Define page factory
	 @FindBy(xpath= "//a[@class='login']")
	 WebElement sign_in;
	 
	 @FindBy(xpath="//input[@id='email']")
	 WebElement email;
	 
	 @FindBy(xpath="//input[@id='passwd']")
	 WebElement pwd;
	 
	 @FindBy(xpath="//button[@id='SubmitLogin' ]")
	 WebElement signinButton;
	 
	 
	 public String validateTitle()
	 {
		 return driver.getTitle();
	 }
	 
	 @SuppressWarnings("deprecation")
	public void signin() throws InterruptedException
	 {
		 
		 sign_in.click();
		 wait=new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.visibilityOf(email));
		 email.sendKeys(prop.getProperty("email"));
		 pwd.sendKeys(prop.getProperty("pwd"));
		 signinButton.click();
		 
	 }
	 

	public String validate_authentication_title() {
		
		 return driver.getTitle();
	}

	
	 
}
