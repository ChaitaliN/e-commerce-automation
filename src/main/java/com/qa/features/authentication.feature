Feature: Authentication feature

Scenario: E-Commerce website authentication

	Given User launch browser and enter URL
	When My Store title is displayed
	Then user clicks on Sign -in button and enter username and password
	Then title should be displayed as My account - My Store
	
