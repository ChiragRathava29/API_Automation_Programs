/*

package com.ChiragRathava.ex09_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.assertj.core.api.Assertions.*;

public class API_Testing_27_RestAssured_TestNG_AssertJ_Assertions {

    RequestSpecification r;
    ValidatableResponse vr;
    Response response;
    String token;
    Integer bookingId;

    @Test
    public void test_POST(){
        String payload_POST = "{\n" +
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

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(payload_POST).log().all();

        Response response = r.then().when().post();

        // Get Validatable response to perform validation
        vr = response.then().log().all();

        // Rest Assured.
        vr.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers;
        // booking shouln't null

        vr.body("booking.firstname", Matchers.equalTo("Chirag"));
        vr.body("booking.lastname",Matchers.equalTo("Rathava"));
        vr.body("booking.depositpaid",Matchers.equalTo(true));
        vr.body("bookingid",Matchers.notNullValue());


        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        // TestNG Assertions
        // SoftAssert vs
        // HardAssert -
        // This means that if any assertion fails,
        // the remaining statement in that test method will not be executed.
        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname,"Chirag");
        Assert.assertEquals(lastname,"Rathava");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(firstname, "Jim");
        softAssert.assertAll();

        // AssertJ( 3rd- Lib to Assertions)
        assertThat(bookingId).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isEqualTo("Chirag").isNotEmpty().isNotBlank().isNotNull();
    }

    */