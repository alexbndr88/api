package step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.SauceDemoPages;
import utilities.Driver;

public class SauceDemoSteps extends SauceDemoPages {
    WebDriver driver = Driver.getDriver();

    @Given("user is on {string}")
    public void user_is_on(String string) {
       driver.get(string);
    }
    @Then("user enters username {string}")
    public void user_enters_username(String string) {
        username.sendKeys(string);
    }
    @Then("user enters password {string}")
    public void user_enters_password(String string) {
        password.sendKeys(string);
    }
    @Then("user clicks on log in button")
    public void user_clicks_on_log_in_button() {
        loginButton.click();
    }
    @Then("user adds all items into cart")
    public void user_adds_all_items_into_cart() {
        addAll();
    }
    @Then("user goes to cart")
    public void user_goes_to_cart() {
        goToCart.click();
    }

    @Then("user validates that there {int} items")
    public void user_validates_that_there_items(Integer int1) {
        Integer num = itemsInCart.size();

        Assert.assertTrue(int1 == num);
    }
    @Then("user click on checkout")
    public void user_click_on_checkout() {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 200);
       checkout.click();
    }
    @Then("user enters all inputs")
    public void user_enters_all_inputs() {
        fill();
    }
    @Then("user clicks on continue")
    public void user_clicks_on_continue() {
        continueButton.click();
    }
    @Then("user clicks finish")
    public void user_clicks_finish() {
        finish.click();
    }

    @Then("user sees {string}")
    public void user_sees(String string) {
        Assert.assertEquals(string, lastMessage.getText());
    }

    @Then("user enters password locked_out_user")
    public void user_enters_password_locked_out_user() throws InterruptedException {
        String word = wrongPassword.getText().substring(wrongPassword.getText().indexOf("\n"), wrongPassword.getText().indexOf("problem"));
        String word2= word.substring(word.indexOf("locked"), word.length());

       password.sendKeys(word2);

    }

    @Then("user see {string}")
    public void user_see(String string) {
        String color = errorMessage.getCssValue("background-color");
        System.out.println(color);
        String expectedColor = "rgba(226, 35, 26, 1)";
        Assert.assertEquals(color, expectedColor);
        Assert.assertEquals(string, errorMessage.getText());
    }

    @Then("user enters {string}")
    public void user_enters(String string) {
        username.sendKeys(string);
    }



}
