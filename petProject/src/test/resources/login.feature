
Feature: login to saucedemo
  @login
  Scenario: Login to saucedemo and verify you logged in
    When user is on login page
    And user enters correct login
    And user enters correct password
    And user clicks login
    Then verify that user is logged in