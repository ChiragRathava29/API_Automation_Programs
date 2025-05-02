package com.ChiragRathava.ex06_PATCH_Request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class API_Testing_12_PATCH_NonBDDStyle{
    @Description("Verify the Patch Req for the Restful Booker APIs")
    @Test
    public void test_patch_non_bdd() {
        String token = "5298e39145731dd";
        String bookingid = "2765";

        String payloadPatch = "{\n" +
                "   \"firstname\": \"Chirag\",\n" +
                "   \"lastname\": \"Rathva\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingid);
        r.contentType(ContentType.JSON);

        r.cookie("token", token);
//        r.auth().basic("admin","password123");
        r.body(payloadPatch).log().all();

        Response response = r.when().patch();

        ValidatableResponse vr = response.then().log().all();

        vr.statusCode(200);
    }
}
