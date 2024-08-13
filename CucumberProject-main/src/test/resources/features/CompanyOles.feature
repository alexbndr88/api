Feature: Create Company

  Background:
    Given the user is located at "https://supplysync.us/login"
    And the user logs in with "admin@codewise.com" and "codewise123"

  @companynegative
  Scenario: User creates a new company

    Given user click on createcompany
    And user fills name "name"
    And user fills  email "Oles@gmail.com"
    And user fills address "address"
    And user fills  number "1231231312"
    And user clicks submit button
    Then user verifies that name wasnt creates