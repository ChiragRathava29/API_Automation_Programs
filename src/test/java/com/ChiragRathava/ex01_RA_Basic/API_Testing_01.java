package com.ChiragRathava.ex01_RA_Basic;

import io.restassured.RestAssured;

public class API_Testing_01 {
    public static void main(String[] args) {
        // Gherkins Syntax
// Given() -> Pre Req. - URL, Headers, Auth, Body....
// When() -> HTTP method? - GET/POST/PUT/PATCH, DELETE...
// Then() -> Validation -> 200 oK, firstname == PRAMOD

      /*
      * FULL URI : https://api.zippopotam.us/IN/390009
      * Base URI : https://api.zippopotam.us
      * base path: /IN/390009
      * */
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/390009")
                .when()
                    .get()
                .then()
                    .log().all().statusCode(200);

    }
}
