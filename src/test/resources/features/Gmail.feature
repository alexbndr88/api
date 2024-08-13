Feature:

  Background:
      Given user is on "https://accounts.google.com/"


    Scenario: Positive test case
      When User enters email address "user@gmail.com"
      And user click on next button
      And user enters "password"
      And clicks on next button
      Then user logs into his account

      Scenario: User forgot email
        Then user clicks on forgot email button
        Then user enters email address "user@gmail.com"
        Then user enters "First name"
        Then user enters "Last name"
        And clicks on next button
        Then user logs into his account

        Scenario: User enters invalid email address
          When user enter email address containing only numbers "12425125"
          Then user should see "Enter a valid email or phone number"
          And clicks on next button
          Then user logs into his account





