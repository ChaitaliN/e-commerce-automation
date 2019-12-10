package com.qa.stepDefination;

import com.qa.webpages.ProductInfo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class ProductInfoStepDef {
	//ProductInfo pinfo;
	@Given("^user clicks on More button$")
	public void user_clicks_on_More_button() throws Throwable {
		ProductInfo pinfo=new ProductInfo();
		pinfo.click_on_moreButton();
	   
	}

	@SuppressWarnings("deprecation")
	@When("^title is displayed as \"([^\"]*)\"$")
	public void title_is_displayed_as(String arg1) throws Throwable {
		ProductInfo pinfo=new ProductInfo();
	    String title=pinfo.validate_Printed_Dress_My_Store_title();
	    		Assert.assertEquals(title, "Printed Dress - My Store");
	}

	@Then("^validate dress image is displayed$")
	public void validate_dress_image_is_displayed() throws Throwable {
		ProductInfo pinfo=new ProductInfo();
		pinfo.verify_image();
		
	}

	@Then("^validate dress info is displayed$")
	public void validate_dress_info_is_displayed() throws Throwable {
		ProductInfo pinfo=new ProductInfo();
		boolean[] flag=pinfo.dressInfo();
		for(int i=0;i<flag.length;i++)
		{
			if(!flag[i])
			{
				System.out.println("Dress information is not displayed");
			}
		}
	    

	}

	@SuppressWarnings("deprecation")
	@Then("^validate Tweet button is displayed$")
	public void validate_Tweet_button_is_displayed() throws Throwable {
		ProductInfo pinfo=new ProductInfo();
		String title=pinfo.validate_Tweet_button();
		Assert.assertEquals(title, "Post a Tweet on Twitter");
	}


}
