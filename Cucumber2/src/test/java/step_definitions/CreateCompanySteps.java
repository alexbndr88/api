package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import pages.CreateCompany;
import utilities.Driver;

import java.time.Duration;
import java.util.logging.Logger;

public class CreateCompanySteps {

    WebDriver driver;
    CreateCompany createCompanyPage;
    WebDriverWait wait;

    @FindBy(name = "email")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    public CreateCompanySteps() {
        this.driver = Driver.getDriver();
        this.createCompanyPage = PageFactory.initElements(driver, CreateCompany.class);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @Given("the user is located at {string}")
    public void the_user_is_located_at(String url) {
        driver.get(url);
    }

    @Given("the user logs in with {string} and {string}")
    public void the_user_logs_in_with(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }


    //    @Given("the user is located at first page")
//    public void the_user_is_located_at_first_page() {
//        driver.get("https://supplysync.us/main-page");
//    }
    @Given("user click on createcompany")
    public void user_click_on_createcompany() {
        driver.findElement(By.xpath("//button[contains(text(),'Create company')]")).click();

    }


//    @Given("user fills company name")
//    public void user_fills_company_name(String string) {
//        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(string);
//    }

    @Given("user fills name {string}")
    public void user_fills_name(String string) {
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(string);
    }

    @Given("user fills  email {string}")
    public void user_fills_email(String email) {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
    }

    @Given("user fills address {string}")
    public void user_fills_address(String address) {
        driver.findElement(By.xpath("//input[@name='address']")).sendKeys(address);
    }

    @Given("user fills  number {string}")
    public void user_fills_number(String number) {
        driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(number);
    }


    @Given("user clicks submit button")
    public void user_clicks_submit_button() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("user verifies that name wasnt creates")
    public void user_verifies_that_name_wasnt_creates() {
        String error = driver.findElement(By.xpath("//p[@class='sc-kmQMED junKfP']")).getText();
        Assert.assertTrue(error.equals("Phone number is required"));
    }


}