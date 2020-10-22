package com.restapi;

import static io.restassured.RestAssured.*;
import org.json.JSONArray;
import org.json.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ComplexJSONPostAPI {
    static ComplexJSONPostAPI complexJSONPostAPI = new ComplexJSONPostAPI();

    public void getResponseUsingComplexJSON() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "modok");
        jsonObj.put("job", "leader");

        JSONArray skills = new JSONArray();
        skills.put("Java");
        skills.put("C");

        jsonObj.put("skills", skills);

        JSONObject details = new JSONObject();
        details.put("company", "xyz");
        details.put("email", "s@s.com");

        jsonObj.put("details", details);

        System.out.println("In getResponseUsingComplexJSON.......");
        Response res = given()
        .auth().none()
        .header("Content-Type", "application/json")
        .contentType(ContentType.JSON)
        .when()
        .body(jsonObj.toString())
        .post("https://reqres.in/api/users");
        System.out.println("Response: "+res.asString());
    }

    public static void main(String[] args) {
        complexJSONPostAPI.getResponseUsingComplexJSON();
    }
}
