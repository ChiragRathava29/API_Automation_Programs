package com.ChiragRathava.ex01_RA_Basic;

import io.restassured.RestAssured;

import java.util.Scanner;

public class API_Testing_01_User_Input {
    public static void main(String[] args) {
        // Gherkins Syntax
// Given() -> Pre Req. - URL, Headers, Auth, Body....
// When() -> HTTP method? - GET/POST/PUT/PATCH, DELETE...
// Then() -> Validation -> 200 oK, firstname == PRAMOD

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the pincode: ");
        String pincode = scanner.nextLine();
        scanner.close();

      /*
      * FULL URI : https://api.zippopotam.us/IN/390009
      * Base URI : https://api.zippopotam.us
      * base path: /IN/390009
      * */
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" + pincode)
                .when()
                    .get()
                .then()
                    .log().all().statusCode(200);
    }
}
