package com.ChiragRathava.ex10_PayloadMangement.jackson_api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class API_Testing_31_RestAssured_JackSON_API {

    RequestSpecification r;
    ValidatableResponse vr;

    @Test
    public void test_Creat_Booking_Positive() {

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

        com.ChiragRathava.ex10_PayloadMangement.jackson_api.Booking booking = new Booking();
        booking.setFirstname("Chirag");
        booking.setLastname("Rathava");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        com.ChiragRathava.ex10_PayloadMangement.jackson_api.Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        String jsonStringBooking;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
             jsonStringBooking = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(jsonStringBooking);

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

        // Case 2 - jsonPath.getString("") JSON Path Extraction
        JsonPath jsonPath = new JsonPath(response.asString());
        String bookingId = jsonPath.getString("bookingid");
        String firstname = jsonPath.getString("booking.firstname");
        String checkin = jsonPath.getString("booking.bookingdates.checkin");
        System.out.println(bookingId);
        System.out.println(firstname);
        System.out.println(checkin);

        //         BookingResponse bookingResponse = gson.fromJson(jsonResponseString1,BookingResponse.class);

        BookingResponse bookingResponse = null;
        try {
            bookingResponse = objectMapper.readValue(response.asString(),BookingResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());
        System.out.println(bookingResponse.getBooking().getBookingdates().getCheckin());

        assertThat(bookingResponse.getBookingid()).isNotZero().isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Chirag");

    }
}