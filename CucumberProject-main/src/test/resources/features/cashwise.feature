Feature:
  Background:
    Given someone is on "https://cashwise.us/main?showReg=false"

    @Cashwise
    Scenario: Sign up
      Then user clicks on sign up button
      Then user enters "someemail@gmail.com" on email field
      Then user enters "somepassword123" on password field
      Then user enters "somepassword123"  on confirm password field
      Then someone clicks on continue
      Then user enters "Abduvohid" on name field
      Then user enters "Abdujamolov" on surname field
      Then user enters "Samo Inc" on business field
      Then user selects realty
      Then user enters "123 Main st" on address field
      Then user selects currency
      Then user click on sign up

