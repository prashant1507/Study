package com.restapi;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Assert;

public class ValidatePostResponse {
    static ValidatePostResponse validatePostResponse = new ValidatePostResponse();

    public void getValidationPOST() {
        HashMap<String, Object> hashMap = new HashMap<String,Object>();
        hashMap.put("name", "modok");
        hashMap.put("job", "leader");

        ArrayList<String> skills = new ArrayList<String>();
        skills.add("Java");
        skills.add("C");

        hashMap.put("skills", skills);

        HashMap<String, Object> details = new HashMap<String,Object>();
        details.put("company", "xyz");
        details.put("email", "s@s.com");

        hashMap.put("details", details);

        System.out.println("In getValidationPOST.......");
        Response res = given()
        .auth().none()
        .header("Content-Type", "application/json")
        .contentType(ContentType.JSON)
        .when()
        .body(hashMap)
        .post("https://reqres.in/api/users");
        res.prettyPrint();
        
        String name = res.getBody().path("name");
        System.out.println("Name: "+name);
        Assert.assertEquals("modok", name);

        System.out.println("Job: "+res.getBody().path("job"));
        System.out.println("Skill 1: "+res.getBody().path("skills[0]"));

        System.out.println("Company: "+res.getBody().path("details.company"));
        // OR
        System.out.println("Company: "+res.jsonPath().get("details.company"));

    }
    public static void main(String[] args) {
        validatePostResponse.getValidationPOST();
    }
}
