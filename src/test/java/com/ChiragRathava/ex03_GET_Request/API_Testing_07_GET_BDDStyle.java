package com.ChiragRathava.ex03_GET_Request;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class API_Testing_07_GET_BDDStyle {

    @Test
    public void test_GET_Req_POSITIVE(){
        String pincode = "382424";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }

    @Test
    public void test_GET_Req_NEGATIVE(){
        String pincode = "-1";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }
}
