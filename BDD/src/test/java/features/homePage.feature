Feature: Home Page

  # Without examples
  Scenario: Get username and password
    Given User navigates to the URL
    When User enters valid email id
    And User clicks on submit button
    Then Username is displayed
    And Password is displayed

   #With examples
  Scenario Outline: Error message validation for invalid email id
    Given User navigates to the URL
    When User enters <type> email id
    And User clicks on submit button
    Then Error message '<errorMessage>' is displayed
    Examples:
    	|type   |errorMessage              |
    	|blank  |Email ID must not be blank|
    	|invalid|Email ID is not valid     |
    	
   #With Data Table
  Scenario: Error message validation for invalid email id
    Given User navigates to the URL
    When User enters invalid email address
    |invalid|
    And User clicks on submit button
    Then Error message for invalid email is displayed
    |Email ID is not valid|
