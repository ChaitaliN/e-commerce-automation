package com.qa.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	 
	 @FindBy(xpath="(//a[@class='sf-with-ul' and @title='Dresses'])[2]")
	 WebElement dresses;
	 
	 @FindBy(xpath="(//a[@title='Casual Dresses'])[2]")
	 WebElement casualdress;
	 
	 @FindBy(xpath="//a[@class='product_img_link']//img[@class='replace-2x img-responsive']")
	 WebElement dress_info;
	 
	 @FindBy(xpath="//a[@title='Add to cart']")
	 WebElement add_to_cart;
	 
	 @FindBy(xpath="//span[contains(text(),'More')]")
	 WebElement more;
	 
	 @FindBy(xpath="//span[@class='available-now']")
	 WebElement inStock;
	 
	 
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

	public void moveto_casualDresses()
	{
		Actions act=new Actions(driver);
		act.moveToElement(dresses).build().perform();
		act.moveToElement(casualdress).click().build().perform();
		
	}
	 
	public String validate_title_MyStorePage() {
		
		return driver.getTitle();
	}
	
	public boolean[] dressInfo()
	{
		Actions act=new Actions(driver);
		act.moveToElement(dress_info).build().perform();
		act.moveToElement(add_to_cart).build().perform();
		boolean result[]=new boolean[3];
		result[0]=add_to_cart.isEnabled();
		result[1]= more.isEnabled();
		result[2]=inStock.isEnabled();
		return result;
	}
	
	public ProductInfo ProductInfo()
	{
		return new ProductInfo();
	}
}
