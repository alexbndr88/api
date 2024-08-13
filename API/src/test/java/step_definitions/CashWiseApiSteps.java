package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Config;

import java.sql.Driver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashWiseApiSteps {


    Response response;
    @Given("the user hits the API with endpoint {string}")
    public void the_user_hits_the_api_with_endpoint(String endpoint) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("size", 20);
        params.put("page", 1);
        response = RestAssured.
                given().
                auth().
                oauth2(Config.getProperty("cashwiseToken")).
                params(params).
                get((Config.getProperty("baseCashwiseUrl") + endpoint));
    }
    @Then("the user validates that status code is {int}")
    public void the_user_validates_that_status_code_is(Integer statusCode) {

        Assert.assertTrue(response.getStatusCode() == statusCode);
    }
    @Then("the user verifies if all client ids are not empty")
    public void the_user_verifies_if_all_client_ids_are_not_empty() {
        // Assuming the response is a JSON array of client objects
        List<String> clientIds = response.jsonPath().getList("clients.id");

        // Verifying all client IDs are not empty
        for (String id : clientIds) {
            Assert.assertNotNull("Client ID should not be null", id);
            Assert.assertFalse("Client ID should not be empty", id.trim().isEmpty());
        }
    }
}












