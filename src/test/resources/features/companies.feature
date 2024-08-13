Feature: Add  Companies

  Background:
    Given the user is on the "https://supplysync.us/"
    When the user logs in with valid credentials
    And the user navigates to the Companies page

  Scenario: Add a new company successfully
    When the user clicks the "Create company" button
    And the user enters "<company_name>" in the company name field
    And the user enters "<address>" in the address field
    And the user enters "<phone_number>" in the phone field
    And the user enters "<email>" in the email field
    And the user clicks the "Save" button
    Then the company with name "<company_name>" should be listed on the Companies page

  Scenario: Attempt to add a company without a name
    When the user clicks the "Create company" button
    And the user enters "" in the company name field
    And the user enters "<address>" in the address field
    And the user enters "<phone_number>" in the phone field
    And the user enters "<email>" in the email field
    And the user clicks the "Save" button
    Then an error message for missing company name should be displayed