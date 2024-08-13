package steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import utilities.Config;
import utilities.Driver;

public class loginSteps {
    LoginPage loginPage=new LoginPage();
    String loogedOn="https://www.saucedemo.com/inventory.html";

    @When("user is on login page")
    public void user_is_on_login_page() {
        Driver.getDriver().get(Config.getProperty("sauceDemo"));
    }
    @When("user enters correct login")
    public void user_enters_correct_login() {
     loginPage.username.sendKeys(Config.getProperty("username"));
    }
    @When("user enters correct password")
    public void user_enters_correct_password() {
        loginPage.password.sendKeys(Config.getProperty("password"));
    }
    @When("user clicks login")
    public void user_clicks_login() {
       loginPage.loginButton.click();
    }
    @Then("verify that user is logged in")
    public void verify_that_user_is_logged_in() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(loogedOn));
    }
}
