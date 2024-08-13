Feature: Sauce Demo practice
  Background:
    Given user is on "https://www.saucedemo.com/"



    @Abduvohid
    Scenario: Positive checkout
      Then user enters username "standard_user"
      Then user enters password "secret_sauce"
      Then user clicks on log in button
      Then user adds all items into cart
      Then user goes to cart
      Then user validates that there 6 items
      Then user click on checkout
      Then user enters all inputs
      Then user clicks on continue
      Then user clicks finish
      Then user sees "Thank you for your order!"


      @AbduvohidNegative
      Scenario: Negative test case
        Then user enters username "standard_user"
        Then user enters password locked_out_user
        Then user clicks on log in button
        Then user see "Epic sadface: Username and password do not match any user in this service"