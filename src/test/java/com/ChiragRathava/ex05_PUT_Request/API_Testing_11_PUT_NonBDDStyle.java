package com.ChiragRathava.ex05_PUT_Request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Description;
import org.testng.annotations.Test;

/*
* Requirement for PUT Req
* Token, booking id -A
*
* // public void get_token()
* // public void get_booking_id()
* */
public class API_Testing_11_PUT_NonBDDStyle {

    @Description("Verify the PUT Req for the Restful Booker APIs")
    @Test
    public void test_put_non_bdd(){

        String token = "5298e39145731dd";
        String bookingid = "2765";

        String payloadPUT = "{\n" +
                "    \"firstname\" : \"Chirag\",\n" +
                "    \"lastname\" : \"Rathava\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);

        r.cookie("token", token);
//        r.auth().basic("admin","password123");
        r.body(payloadPUT).log().all();

        Response response = r.when().put();

        ValidatableResponse vr = response.then().log().all();

        vr.statusCode(200);

    }
}
