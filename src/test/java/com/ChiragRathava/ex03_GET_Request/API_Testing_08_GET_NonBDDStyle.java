package com.ChiragRathava.ex03_GET_Request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class API_Testing_08_GET_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description("Verify the GET Req Positive")
    @Test
    public void test_NonBDD_GET(){
        String pincode = "382424";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);
    }

    @Description("Verify the GET Req Negative : -1 Input")
    @Test
    public void test_NoBDDStyleGET_negative(){

        String pin_code = "-1";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pin_code);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(404);
    }
}