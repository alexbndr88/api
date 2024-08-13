  Feature: Search Bar Functionality
  Background:
    Given the user is on "https://www.google.com"
    @positive
    Scenario: positive scenario where user searches for apple
      When user enters "apple" in the search bar
      And user clicks on search button
      Then user should see "Apple" in result page

    @negative
    Scenario: negative scenario where user searches for some random letters
        When user enter "someRandomLettersofwpqjfmqwofqwmfoqmwfqowmfqwpmfqowf" in the search bar
        Then user should see "did not match"


