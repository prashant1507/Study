package com.resassured.framework;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsingGet {
    CommonMethods commonMethods = new CommonMethods();

    @Test
    public void validateStatusCode() {
        Response response = commonMethods.getResponse(Constants.url.concat("/api/users"));
        Assert.assertEquals(response.getStatusCode(), 200, "Status Code");
    }

    @Test
    public void validateDataFromResponseUsingBody() {
        Response response = commonMethods.getResponse(Constants.url.concat("/api/users"));
        Assert.assertEquals(response.getBody().path("page"), 1, "Page");
        Assert.assertEquals(response.getBody().path("per_page"), 6, "Per Page");
        Assert.assertEquals(response.getBody().path("total"), 12, "Total");
        Assert.assertEquals(response.getBody().path("total_pages"), 2, "Total Pages");
    }

    @Test
    public void validateDataFromResponseUsingJSON() {  
        Response response = commonMethods.getResponse(Constants.url.concat("/api/users"));
        JSONObject jsonObject = new JSONObject(response.asPrettyString());  

        Assert.assertEquals(jsonObject.get("page"), 1, "Page");
        Assert.assertEquals(jsonObject.get("per_page"), 6, "Per Page");
        Assert.assertEquals(jsonObject.get("total"), 12, "Total");
        Assert.assertEquals(jsonObject.get("total_pages"), 2, "Total Pages");
    }

    @Test
    /* Get user with id=2 and validate last_name */
    public void validateSingleUser() {
        Response response = commonMethods.getResponse(Constants.url.concat("/api/users/2"));
        JSONObject jsonObject = new JSONObject(response.asPrettyString());
        Assert.assertEquals(jsonObject.getJSONObject("data").get("last_name"), "Weaver");
    }

    @Test
    public void validateNonExistenceUser() {
        Response response = commonMethods.getResponse(Constants.url.concat("/api/users/456"));
        Assert.assertEquals(response.getStatusCode(), 404, "User not found");
    }
}
