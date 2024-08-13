package api;

import io.cucumber.java.it.Ma;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IntroToAPI {
    public static void main(String[] args) {
        String baseUri="https://backend.cashwise.us";
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MjUyNDI4NjAsImlhdCI6MTcyMjY1MDg2MCwidXNlcm5hbWUiOiJvbGVzbWFrYXJlbmtvQGdtYWlsLmNvbSJ9.UEUyOFPHupbTVd_M7TcGRvkgayQKFlYdgmz0dlIjIUH4QpOuR1tjGKerTsgWmDutfJYA7O4iu4vddWJmW2tk7Q";
        RestAssured.given().auth().oauth2(token).baseUri(baseUri).when()
                .get("/api/myaccount/sellers/all").then().statusCode(200);

//        RestAssured.given()
//                .auth()
//                .oauth2(token)
//                .baseUri(baseUri)
//                .and()
//                .queryParam("isArchived",false)
//                .queryParam("page",1)
//                .queryParam("size",1)
//                .when()
//                .get("/api/myaccount/sellers").then().statusCode(200);

        Map<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("page", 1);
        params.put("size", 2);
        Response response=RestAssured.given().auth().oauth2(token).params(params).get(baseUri+"/api/myaccount/sellers");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
        String id=response.jsonPath().get("responses.seller_id[0]").toString();
        System.out.println(id);

        Response response1=RestAssured.given().auth().oauth2(token).get(baseUri+"/api/myaccount/sellers/"+id);
        System.out.println(response1.prettyPrint());
        String id2=response1.jsonPath().get("seller_id").toString();
        System.out.println(id2);
        Assert.assertTrue(id.equals(id2));

    }
}
