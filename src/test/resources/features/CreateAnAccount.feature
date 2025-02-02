Feature: Creation of Acoounts 

  Scenario: Successful creation of account in chrome
    Given I am on the create account page
    When I enter valid data to create account
    Then Successfull accounts creation validation
      
