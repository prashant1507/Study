package com.resassured.framework;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class CommonMethods 
{   
    public Response getResponse(String url) {
        Response response = given()
        .header("Content-Type", "application/json")
        .when().get(url);
        return response;  
    }

    
}
