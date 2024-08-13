
  Background:
    Given user is on "https://www.saucedemo.com/"

    @Login
    Scenario Outline: Login test
      Then user enters "<username>"
      Then user enters password "secret_sauce"
      Then user clicks on log in button

      Examples:
      | username                 |
      | standard_user            |
      | locked_out_user          |
      | problem_user             |
      | performance_glitch_user  |
      | error_user               |
      | visual_user              |