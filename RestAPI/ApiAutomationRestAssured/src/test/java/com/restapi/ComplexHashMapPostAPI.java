package com.restapi;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.HashMap;

public class ComplexHashMapPostAPI {
    static ComplexHashMapPostAPI complexJSONPostAPI = new ComplexHashMapPostAPI();

    public void getResponseUsingComplexHashMap() {
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

        System.out.println("In getResponseUsingComplexHashMap.......");
        Response res = given()
        .auth().none()
        .header("Content-Type", "application/json")
        .contentType(ContentType.JSON)
        .when()
        .body(hashMap)
        .post("https://reqres.in/api/users");
        System.out.println("Response: "+res.asString());
    }
    
    public static void main(String[] args) {
        complexJSONPostAPI.getResponseUsingComplexHashMap();
    }
}
