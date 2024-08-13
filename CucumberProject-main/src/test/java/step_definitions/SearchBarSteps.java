package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.SearchBarPage;
import utilities.Driver;

public class SearchBarSteps extends SearchBarPage {
    private static final Logger logger = LogManager.getLogger(SearchBarSteps.class);

WebDriver driver = Driver.getDriver();
    @Given("the user is on {string}")
    public void the_user_is_on(String url) {
        SearchBarPage searchBarPage = new SearchBarPage();
        logger.info("User is going to " + url);
        driver.get(url);
        logger.info("User successfully landed on page " + driver.getTitle());

    }
    @When("user enters {string} in the search bar")
    public void user_enters_in_the_search_bar(String input) {
        searchBar.sendKeys(input + Keys.ENTER);
        logger.info("User entered " + input + " in input field");

    }
    @And("user clicks on search button")
    public void user_clicks_on_search_button() {
        searchBar.click();
    }


    @Then("user should see {string} in result page")
    public void user_should_see_in_result_page(String input) {

        Assert.assertEquals(result.getText(), input);
    }

    @When("user enter {string} in the search bar")
    public void user_enter_in_the_search_bar(String string) {
        searchBar.sendKeys(string + Keys.ENTER);
    }
    @Then("user should see {string}")
    public void user_should_see(String string) {
        Assert.assertTrue(resultMessage.getText().contains(string));
    }






}
