package com.thetestingacademy.TestNG_20062024;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab261 {

/*       TESTING FRAMEWORK:-
   Testing framework is required when u have 1000's or 10000 test cases and u want to group them.
   we want to group the test cases based on sanity & smoke.
   we want some functionality where we can do something before and after running the test cases

   TestNG was introduced for this purpose. it is an open source liabrary.
How to Write Test in TestNG?
1. Create a Method and add your logic in that Method
2. Mark that Method as @Test
3. Add required Annotations like
a. description,
b. group,
c. priority,
d. enabled,            */

    // Creating a function
    @Description("TC#1 Verify 261 Get Request 1")
    @Test   // the moment u add @Test a run symbol is shown
    public void getRequest(){
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get()
                .then().statusCode(201);
    }
    @Description("TC#1 Verify 261 Get Request 2")
    @Test
    public void getRequest2() {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get()
                .then().statusCode(201);
    }

//        here there is no main function/method  but still the test will run
//        because whenever TestNG sees @test in ur repository
//        it creates a big java class where there is a main function created
//        so whenever @test is created it will just copy the function to java class
//        Internally it has a main function which is hidden from u
//        At the Runtime when u click on run button a temporary Dynamic TestNG xml file will be created
//        with java main function and the method u created will be copied here, and it will be executed

//   How TestNG knows where is my file present for this purpose TestNG creates a  TestNG xml
//   To see  TestNG xml download TestNG xml plugins
}
