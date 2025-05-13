package com.ChiragRathava.ex10_PayloadMangement.gson;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class API_Testing_30_RestAssured_GSON {
    // GSON - is Google Lib - which will convert your class to JSON
    // JSON to class
    // JSON - is a plain text in key and value pair to transfer from client to server.

    RequestSpecification r;
    ValidatableResponse vr;
    @Test
    public void test_Creat_Booking_Positive(){

        // Step-1 -> POST
        // URL -> Base URI + base Path
        // HEADER
        // BODY
        // Auth -> NO

        // Step-2
        // prepare the payload (Object -> JSON String)
        // send the request

        // Step-3
        // Validate Response ( JSON String -> Object )
        // Firstname
        // Status Code
        // Time Response

        Booking booking = new Booking();
        booking.setFirstname("Chirag");
        booking.setLastname("Rathava");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        // Java Object -> JSON
        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);

        // {"firstname":"Chirag","lastname":"Rathava","totalprice":112,"depositpaid":true,"bookingdates":{"checkin":"2024--02-01","checkout":"2024--02-01"},"additionalneeds":"Breakfast"}

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("booking");
        r.contentType(ContentType.JSON);
        r.body(jsonStringBooking).log().all();

        Response response = r.when().post();
        String jsonResponseString = response.asString();

        vr = response.then().log().all();
        vr.statusCode(200);

        // Case1 - extract() - Direct Extraction
        String firstname1 = response.then().extract().path("booking.firstname");
        System.out.println(firstname1);

        Assert.assertEquals(firstname1,"Chirag");

        assertThat(firstname1).isNotNull().isNotEmpty().isNotBlank().isEqualTo("Chirag");

        // Case 2 - jsonPath.getString("")
        JsonPath jsonPath = new JsonPath(response.asString());
        String bookingId = jsonPath.getString("bookingid");
        String firstname = jsonPath.getString("booking.firstname");
        String checkin = jsonPath.getString("booking.bookingdates.checkin");
        System.out.println(bookingId);
        System.out.println(firstname);
        System.out.println(checkin);

        String checkout = jsonPath.getString("booking.bookingdates.checkout");
        System.out.println(checkout);

        String jsonResponseString1 = response.asString();

        // Server - JSONString > Java Object(BookingResponse) - getter to verify.

        // Case 3 - DeSer - Extraction
        // Response - De Ser another Response Class
        BookingResponse bookingResponse = gson.fromJson(jsonResponseString1,BookingResponse.class);

        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());
        System.out.println(bookingResponse.getBooking().getBookingdates().getCheckin());


    }

}
