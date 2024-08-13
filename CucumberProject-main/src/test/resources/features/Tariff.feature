Feature: Create Tariff


  Background:
    Given the user is located at "https://supplysync.us/login"
    And the user logs in with "admin@codewise.com" and "codewise123"

  @tariffpositive
  Scenario: User creates a new tariff
    Given the user is located at the Create Tariff page
   And user click create tariff
    And user selecting branch
    And user eneters tarifname "name"
    And user selects time "5"
    And user select type
    And user enter cost "420"
    And user select region
    And user select availability
    And user enters graphic coordinates "coordinates"
    And user enters add "information"
    Then user verifies that tariff was created

