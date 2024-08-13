package step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CompaniesPage;
import pages.LoginPage;
import utilities.Driver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CompaniesSteps {
    private static final Logger logger = LogManager.getLogger(SearchBarSteps.class);
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    CompaniesPage companiesPage = new CompaniesPage();
    Faker faker = new Faker();
    String companyName;
    String address;
    String phoneNumber;
    String email;

    @Given("the user is on the SupplySync login page")
    public void the_user_is_on_the_SupplySync_login_page() {
        driver.get("https://supplysync.us/login");
    }

    @When("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() {
        loginPage.login("admin@codewise.com", "codewise123");
    }

    @When("the user navigates to the Companies page")
    public void the_user_navigates_to_the_Companies_page() {
        
    }

    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String buttonName) {
        if ("Create company".equals(buttonName)) {
            companiesPage.addCompanyButton.click();
        } else if ("Save".equals(buttonName)) {
            companiesPage.justCreate.click();
        }
    }

    @When("the user enters a new company name in the company name field")
    public void the_user_enters_a_new_company_name_in_the_company_name_field() {
        companyName = faker.company().name(); 
        companiesPage.companyNameField.sendKeys(companyName);
    }

    @When("the user enters a new address in the address field")
    public void the_user_enters_a_new_address_in_the_address_field() {
        address = faker.address().fullAddress(); 
        companiesPage.addressField.sendKeys(address);
    }

    @When("the user enters a new phone number in the phone field")
    public void the_user_enters_a_new_phone_number_in_the_phone_field() {
        phoneNumber = faker.phoneNumber().phoneNumber();
        companiesPage.phoneField.sendKeys(phoneNumber);
    }

    @When("the user enters a new email in the email field")
    public void the_user_enters_a_new_email_in_the_email_field() {
        email = faker.internet().emailAddress(); 
        companiesPage.emailField.sendKeys(email);
    }

    @Then("the company with the name entered should be listed on the Companies page")
    public void the_company_with_the_name_entered_should_be_listed() {
        assertTrue(companiesPage.isCompanyListed(companyName));
    }

    @Then("the company with the name entered should not be listed on the Companies page")
    public void the_company_with_the_name_entered_should_not_be_listed() {
        assertFalse(companiesPage.isCompanyListed(companyName));
    }

    @Then("an error message for missing company name should be displayed")
    public void an_error_message_for_missing_company_name_should_be_displayed() {
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(),'Company Name is required')]"));
        assertTrue("Error message for missing company name is not displayed.", errorMessage.isDisplayed());
    }
}



