package com.resassured.framework;

import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Operations {
    
    @Test
    public void createUser() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "testUser1");
        jsonObj.put("job", "engineer");
        jsonObj.put("first_name", "Test");

        Response response = given()
        .auth().none()
        .header("Content-Type", "application/json")
        .when()
        .body(jsonObj.toString())
        .post(Constants.url.concat("/api/users"));

        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test
    public void deleteUser() {
        
        Response response = given()
        .auth().none()
        .header("Content-Type", "application/json")
        .when()
        .delete(Constants.url.concat("/api/users/2"));
        Assert.assertEquals(response.getStatusCode(), 204);
    }

    @Test
    public void registerUser() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("email", "eve.holt@reqres.in");
        jsonObj.put("password", "pistol");

        Response response = given()
        .auth().none()
        .header("Content-Type", "application/json")
        .when()
        .body(jsonObj.toString())
        .post(Constants.url.concat("/api/register"));

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void failUserRegistration() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("email", "eve.holt@reqres.in");

        Response response = given()
        .auth().none()
        .header("Content-Type", "application/json")
        .when()
        .body(jsonObj.toString())
        .post(Constants.url.concat("/api/register"));

        Assert.assertEquals(response.getStatusCode(), 400);
    }

    @Test
    public void loginSuccessfull() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("email", "eve.holt@reqres.in");
        jsonObj.put("password", "cityslicka");

        Response response = given()
        .auth().none()
        .header("Content-Type", "application/json")
        .when()
        .body(jsonObj.toString())
        .post(Constants.url.concat("/api/login"));

        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void loginUnsuccessfull() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("email", "eve.holt@reqres.in");

        Response response = given()
        .auth().none()
        .header("Content-Type", "application/json")
        .when()
        .body(jsonObj.toString())
        .post(Constants.url.concat("/api/login"));

        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 400);
    }

    @Test
    public void authorization() {
        Response response = given()
        .header("Content-Type", "application/json")
        .header("Authorization", "Basic cG9zdG1hbjpwYXNzd29yZA==")
        .when()
        .get("https://postman-echo.com/basic-auth");

        System.out.println(response.asPrettyString());
    }
}
