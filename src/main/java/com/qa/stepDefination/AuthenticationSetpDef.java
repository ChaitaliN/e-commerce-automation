package com.qa.stepDefination;

import com.qa.base.TestBase;
import com.qa.webpages.AuthenticationPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AuthenticationSetpDef extends TestBase{
	
	AuthenticationPage ap;
	
	@Given("^User launch browser and enter URL$")
	public void user_launch_browser_and_enter_URL() throws Throwable {
		TestBase.initialization();
	    
	}

	@SuppressWarnings("deprecation")
	@When("^My Store title is displayed$")
	public void my_Store_title_is_displayed() throws Throwable {
		ap=new AuthenticationPage();
		String title=ap.validateTitle();
		Assert.assertEquals(title,"My Store");
	}  

	@Then("^user clicks on Sign -in button and enter username and password$")
	public void user_clicks_on_Sign_in_button_and_enter_username_and_password() throws Throwable {
		ap=new AuthenticationPage();
		ap.signin();
	}

	@SuppressWarnings("deprecation")
	@Then("^title should be displayed as My account - My Store$")
	public void title_should_be_displayed_as_My_account_My_Store() throws Throwable {
		//ap=new AuthenticationPage();
		String title=ap.validate_authentication_title();
		Assert.assertEquals(title, "My account - My Store");
	    
	}
	
	@Given("^User clicks on Dresses -> Casual Dresses$")
	public void user_clicks_on_Dresses_Casual_Dresses() throws Throwable {
		ap=new AuthenticationPage();
		ap.moveto_casualDresses();
	   
	}

	@SuppressWarnings("deprecation")
	@When("^Title should be displayed as Casual Dresses - My Store$")
	public void title_should_be_displayed_as_Casual_Dresses_My_Store() throws Throwable {
		
		String title=ap.validate_title_MyStorePage();
		Assert.assertEquals(title, "Casual Dresses - My Store");
	    
	}

	@Then("^dress image should be visible$")
	public void dress_image_should_be_visible() throws Throwable {
		ap=new AuthenticationPage();
		ap.dressInfo();
	    
	}

	@SuppressWarnings("unused")
	@Then("^validate Add to cart , More , In stock Items should be displayed$")
	public void validate_Add_to_cart_More_In_stock_Items_should_be_displayed() throws Throwable {
	    boolean flag[]=ap.dressInfo();
	    if (flag[0]==true)
	    {
	    	System.out.println("add to cart button is enabled");
	    }
	    if(flag[1]==true)
	    {
	    	System.out.println("More button is enabled");
	    }
	    if(flag[2]==true)
	    {
	    	System.out.println("In Stock button is enabled");
	    }
	    
	    ap.ProductInfo();

	}



}
