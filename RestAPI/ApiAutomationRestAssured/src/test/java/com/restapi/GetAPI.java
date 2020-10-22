package com.restapi;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAPI {
    static GetAPI getAPI = new GetAPI();

    public void doValidationFromResposeUsingGET() {
        System.out.println("In doValidationFromResposeUsingGET.......");
         given()
        .param("page", "2")
        .auth().none()
        .header("Content-Type", "application/json")
        .contentType(ContentType.JSON)
        .when()
        .get("https://reqres.in/api/users")
        .then()
        .statusCode(200)
        .body("page", equalTo(2),
            "total", equalTo(12));
    }

    public void getResponseUsingGET() {
        System.out.println("In getResponseUsingGET.......");
        Response res = given()
        .param("page", "2")
        .auth().none()
        .header("Content-Type", "application/json")
        .contentType(ContentType.JSON)
        .when()
        .get("https://reqres.in/api/users");
        //res.prettyPrint();
        System.out.println("Response: "+res.asString());
        System.out.println("Status Code: "+res.getStatusCode());
        System.out.println("Response Time: "+res.getTime());
    }

    public static void main(String[] args) {
        getAPI.doValidationFromResposeUsingGET();
        getAPI.getResponseUsingGET();

    }
}
