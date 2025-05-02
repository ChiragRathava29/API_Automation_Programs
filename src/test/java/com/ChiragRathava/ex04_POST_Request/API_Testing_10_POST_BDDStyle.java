package com.ChiragRathava.ex04_POST_Request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class API_Testing_10_POST_BDDStyle {

    @Description("Verify the POST Req Positive")
    @Test
    public void test_POST_BDDStyle(){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .when().log().all().post()
                .then().log().all().statusCode(200);
    }
}
