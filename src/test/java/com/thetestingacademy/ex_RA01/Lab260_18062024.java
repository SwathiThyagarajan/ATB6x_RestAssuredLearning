package com.thetestingacademy.ex_RA01;

import io.restassured.RestAssured;

public class Lab260_18062024 {
    public static void main(String[] args) {

        // Creating Rest Assured Hello World Program

        // Rest Assured is a java domain specific language
        // it will help u write the automated tests for Restful APIs
        // you can make any http request like post put get delete etc. and also validate the response

        // Rest Assured follows something known as given when then.
        // given when then is a style for representing test case

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get().then().statusCode(201);

        // here above is a simple testcase if it passes nothing will be shown in output
        // but if it fails error will be shown
    }
}
