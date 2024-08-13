package step_definitions;

import api.ReqRes;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.PrettyPrint;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.util.JSONPObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static io.restassured.http.ContentType.JSON;

public class TagSteps {
    WebDriver driver;
    RequestSpecification request;
    Response response;
    JSONObject requestBody=new JSONObject();
    String retrievedId;


    @Given("base url {string}")
    public void base_url(String url) {
        request = RestAssured.given().baseUri(url).given().contentType(JSON).accept(JSON).baseUri(url);
    }

    @When("I provide valid token")
    public void i_provide_valid_token() {
        request = request.auth().oauth2("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MjU4Mzg2NzQsImlhdCI6MTcyMzI0NjY3NCwidXNlcm5hbWUiOiJvbGVzbWFrYXJlbmtvQGdtYWlsLmNvbSJ9.3aydxWAr6Pur_v0TBTV0ZNL6adqPSUwhQCSOLCMC8jDQyBxLP2LlllNC2nyc-h4KbYzgWH6NXYOecNc_AUf4ow");
    }

    @When("I provide {string} with {string}")
    public void i_provide_with(String key, String value) {
        requestBody.put(key,value);
        request=request.body(requestBody.toString());
    }

    @When("I hit POST endpoint {string}")
    public void i_hit_post_endpoint(String endpoint) {
        response = request.post(endpoint);

    }

    @Then("verify status code is {int}")
    public void verify_status_code_is(Integer statusCode) {
        System.out.println(response.prettyPrint());
        Assert.assertEquals((int)statusCode,response.getStatusCode());

    }

    @Then("verify response body contains {string} with {string}")
    public void verify_response_body_contains_with(String key, String value) {
        String expectedValue = response.jsonPath().get(key);
        Assert.assertEquals(expectedValue,value);
    }
    @Then("i retrieve id {string}")
    public void i_retrieve_id(String id) {
        retrievedId = response.jsonPath().getString(id);
        Assert.assertNotNull("ID should not be null", retrievedId);
    }

    @Then("i hit DELETE endpoint {string}")
    public void i_hit_delete_endpoint(String endpoint) {
        String deleteEndpoint = endpoint + "/" + retrievedId;
        response = request.delete(deleteEndpoint);
        System.out.println(response.prettyPrint());

    }
}



