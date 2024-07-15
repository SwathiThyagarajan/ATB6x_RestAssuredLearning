package com.thetestingacademy.ex_RA01;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab263 {

    // Creating a function
    @Description("TC#1 Verify 263 Get Request 1")
    @Test   // the moment u add @Test a run symbol is shown
    public void getRequest(){
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get()
                .then().statusCode(201);
    }
}
