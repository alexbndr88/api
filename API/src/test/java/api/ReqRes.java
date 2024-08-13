package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class ReqRes {
    public static void main(String[] args) {
        String url = "https://reqres.in/api/users/7";
        Response response= RestAssured.get(url);
        System.out.println(response.prettyPrint());
        System.out.println(response.statusCode());
        String email=response.jsonPath().get("data.email").toString();
        System.out.println(email);
        String firstname=response.jsonPath().get("data.first_name").toString();
        System.out.println(firstname);
        String lastname=response.jsonPath().get("data.last_name").toString();
        System.out.println(lastname);
        String text=response.jsonPath().get("support.text").toString();
        System.out.println(text);
        Assert.assertNotNull(text, "Text should not be null");
        Assert.assertNotNull(email, "Text should not be null");
        Assert.assertNotNull(firstname, "Text should not be null");
        Assert.assertNotNull(lastname, "Text should not be null");

    }
}
