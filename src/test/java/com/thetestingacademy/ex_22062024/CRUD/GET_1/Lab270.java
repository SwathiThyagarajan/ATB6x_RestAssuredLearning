package com.thetestingacademy.ex_22062024.CRUD.GET_1;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab270 {

    // CRUD operation using Non BDD style
    // we can write positive and negative testcases

    @Test
    public void getRequestPositive(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/2002").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);

        // few things we have not verified ->  Header, Response Data/ Body
    }

    @Test
    public void getRequestNegative() {

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/-1").log().all(); // getting -1 as booking id is negative TC try in postman u must get error as not found 404
        r.when().get();
        r.then().log().all().statusCode(404);
    }


}
