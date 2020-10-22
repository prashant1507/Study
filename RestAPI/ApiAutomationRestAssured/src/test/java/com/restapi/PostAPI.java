package com.restapi;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.io.File;
import java.util.HashMap;

public class PostAPI {
    static PostAPI postAPI = new PostAPI();

    public void doPOST() {
        String body = "{\"name\": \"modok\",\"job\": \"leader\"}";
        System.out.println("In doPOST.......");
        given()
        .auth().none()
        .header("Content-Type", "application/json")
        .contentType(ContentType.JSON)
        .when()
        .body(body)
        .post("https://reqres.in/api/users")
        .then()
        .statusCode(201)
        .body("name", equalTo("modok"),
            "job", equalTo("leader"));
    }

    public void getResponseUsingHashMapPOST() {
        HashMap<String, String> hashMap = new HashMap<String,String>();
        hashMap.put("name", "modok");
        hashMap.put("job", "leader");
        System.out.println("In getResponsePOST.......");
        Response res = given()
        .auth().none()
        .header("Content-Type", "application/json")
        .contentType(ContentType.JSON)
        .when()
        .body(hashMap).log().all()
        .post("https://reqres.in/api/users");
        System.out.println("Response: "+res.asString());
    }

    public void getResponseUsingJSONFilePOST() {
        System.out.println("In getResponsePOST.......");
        Response res = given()
        .auth().none()
        .header("Content-Type", "application/json")
        .contentType(ContentType.JSON)
        .when()
        .body(new File("ApiAutomationRestAssured/src/resources/Payload.json")).log().all()
        .post("https://reqres.in/api/users");
        System.out.println("Response: "+res.asString());
    }

    public static void main(String[] args) {
        postAPI.doPOST();
        postAPI.getResponseUsingHashMapPOST();
        postAPI.getResponseUsingJSONFilePOST();
    }
}
