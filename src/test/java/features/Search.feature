@smoke @bmw @search
Feature: Verify Search Functionality

	Background: Navigate to homepage and verify elements
		Given I navigate to "http://www.autotrader.com"
		When I verify the links "Browse By Make", "Browse by Style", "Advance Search"
		When I verify the buttons "Search"
		When I verify the dropdowns "Any Make", "Any Model"

	Scenario: Advance search and list the cars
		Then I click on "Advance Search"
		And I enter "30004" in the "Zipcode" text box
		And I select "Certified" check box under "Condition"
		And I select "Convertible" check box under "Style"
		And I update "From Year" drop down as "2017" and "To Year" drop down as "2020"
		And I select "Make" as "BMW" under Make, Model & Trim section
		And I click on "Search" button
		Then I see listings in the result page
		And verify I see only "BMW" cars and print number of cars listed