Feature: Authentication feature

Scenario: E-Commerce website authentication

	Given User launch browser and enter URL
	When My Store title is displayed
	Then user clicks on Sign -in button and enter username and password
	Then title should be displayed as My account - My Store
	
Scenario: Validate user should be able to view casual dresses
	Given User clicks on Dresses -> Casual Dresses
	When Title should be displayed as Casual Dresses - My Store
	Then dress image should be visible
	Then validate Add to cart , More , In stock Items should be displayed