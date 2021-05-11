Feature: Insurance Project Page
Background: 
	Given User navigates to the URL
	And User is at Insurance Project page
	
	@First
  Scenario: New user registration for Insurance Project
    When User clicks on Register button
    And User fill ups the registration form
    And User clicks on Create button
    Then User navigates to login page for Insurance Project automatically
    
  Scenario: User login for Insurance Project
    When User clicks on Register button
    And User fill ups the registration form
    And User clicks on Create button
    And User navigates to login page for Insurance Project automatically
    And User enters email
    And User enters password
    And User clicks on Login button
    Then User page is displayed