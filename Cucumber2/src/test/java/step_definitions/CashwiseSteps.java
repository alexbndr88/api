package step_definitions;

import io.cucumber.java.en.*;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.CashwisePages;
import utilities.Driver;

public class CashwiseSteps extends CashwisePages {
    WebDriver driver = Driver.getDriver();

    @Given("someone is on {string}")
    public void someone_is_on(String string) {
      driver.get(string);
    }
    @Then("user clicks on sign up button")
    public void user_clicks_on_sign_up_button() {
        signUpButton.click();
    }
    @Then("user enters {string} on email field")
    public void user_enters_on_email_field(String string) {
        emailField.sendKeys(string);
    }
    @Then("user enters {string} on password field")
    public void user_enters_on_password_field(String string) {
        passwordField.sendKeys(string);
    }
    @Then("user enters {string}  on confirm password field")
    public void user_enters_on_confirm_password_field(String string) {
        confirmPassword.sendKeys(string);
    }

    @Then("someone clicks on continue")
    public void someone_clicks_on_continue() {
        continueButton.click();
    }


    @Then("user enters {string} on name field")
    public void user_enters_on_name_field(String string) {
       nameField.sendKeys(string);
    }
    @Then("user enters {string} on surname field")
    public void user_enters_on_surname_field(String string) {
        lastNameField.sendKeys(string);
    }
    @Then("user enters {string} on business field")
    public void user_enters_on_business_field(String string) {
       businessField.sendKeys(string);
    }
    @Then("user selects realty")
    public void user_selects_realty() {
       areaBusiness.click();
       businessOption.click();

    }
    @Then("user enters {string} on address field")
    public void user_enters_on_address_field(String string) {
        addressField.sendKeys(string);
    }
    @Then("user selects currency")
    public void user_selects_currency() {
        currency.click();
        currencyOption.click();
    }
    @Then("user click on sign up")
    public void user_click_on_sign_up() {
        signUp.click();
    }



}
