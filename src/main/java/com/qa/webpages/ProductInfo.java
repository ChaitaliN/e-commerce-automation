package com.qa.webpages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ProductInfo extends TestBase {
	
	public ProductInfo()
	{
		PageFactory.initElements(driver, this);
	}

	By image=By.xpath("//img[@id='bigpic']");
	
	By dressTitle=By.xpath("//h1[contains(text(),'Printed Dress')]");
	
	By dressModel= By.xpath("//span[contains(text(),'demo_3')]");
	
	By dressInfo=By.xpath("(//p[contains(text(),'100% cotton')])[1]");
	
	By tweetButton=By.xpath("//button[@class='btn btn-default btn-twitter']");
	
	
	public void click_on_moreButton()
	{
		AuthenticationPage ap=new AuthenticationPage();
		ap.more.click();
	}
	
	public String validate_Printed_Dress_My_Store_title()
	{
		return driver.getTitle();
	}
	
	public void verify_image()
	{
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image);
		if(!ImagePresent)
		{
			System.out.println("Image is not displayed");
		}
		else
			System.out.println("Image is displayed");
	}
	
	public boolean[] dressInfo()
	{
		boolean[] display=new boolean[3];
		display[0]=driver.findElement(dressTitle).isDisplayed();
		display[1]=driver.findElement(dressModel).isDisplayed();
		display[2]=driver.findElement(dressInfo).isDisplayed();
		
		return display;
	}
	
	public String validate_Tweet_button()
	{
		driver.findElement(tweetButton).click();
			
		Set <String>windows=driver.getWindowHandles();
			
		Iterator<String> it=windows.iterator();
			
		System.out.println(windows.size());	
				String parentWindow=it.next();
				String tweetWindow=it.next();
				
				driver.switchTo().window(tweetWindow);
				String title=driver.getTitle();
				driver.close();
				driver.switchTo().window(parentWindow);
				return title;
		 
					
	   }
	}

