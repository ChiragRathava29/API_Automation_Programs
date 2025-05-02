package com.ChiragRathava.ex07_DELETE_Request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class API_Testing_13_DELETE_NonBDDStyle {
    @Description("Verify the delete Req for the Restful Booker APIs")
    @Test
    public void test_delete_non_bdd(){

        String token = "5298e39145731dd";
        String bookingid = "2765";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingid);
        r.contentType(ContentType.JSON);

        r.cookie("token", token);
//        r.auth().basic("admin","password123");
        r.log().all();

        Response response = r.when().delete();

        ValidatableResponse vr = response.then().log().all();

        vr.statusCode(201);
    }
}
