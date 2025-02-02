Feature: Create a new user account with data from Excel

  Scenario: User creates a new account with valid data from Excel and validates the creation
    Given I have the data from Excel file
    When I enter data from Excel to create an account
    Then I validate the account creation and write result to Excel
  
