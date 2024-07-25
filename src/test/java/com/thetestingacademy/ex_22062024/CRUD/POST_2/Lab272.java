package com.thetestingacademy.ex_22062024.CRUD.POST_2;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab272 {

    //  Create a RequestSpecification object using RestAssured's given() method.
    RequestSpecification r = RestAssured.given();

    //  Send the POST request and log all request details. Capture the response.
    Response response;

    //  Create a ValidatableResponse object from the response and verify the status code is 200.
    ValidatableResponse validatableResponse;

    @Description("TC#1 Verify that create booking is working with valid payload")
    @Test
    public void testNon_BDD_stylePOST_Positive() {

        //  The @Test annotation from TestNG indicates that this method is a test case.
        //  so it can recognize and execute it as part of the test suite.
        // To make a Post request we need
        // 1. URL
        // 2. Body - PAYLOAD - JSON
        // 3. Header - Content Type

        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";
        String Payload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        r.baseUri(Base_URL);
        r.basePath(Base_Path);
        r.contentType(ContentType.JSON).log().all();
        r.body(Payload);

        response = r.when().log().all().post();// Sends the POST request to the specified endpoint, logging the request details for debugging.
        String responseString = response.asString();// Converts the response to a string for easier printing and inspection.
        System.out.println(responseString); // Prints the response to the console.
        // This is useful for manual inspection and debugging to ensure the response is as expected.

        validatableResponse = response.then();
        validatableResponse.statusCode(200);
        // r.then gives u validatable response that u can verify
        // instead of using r.then we can use response.then

        // we have divided the POST Request using 3 interfaces
        // 1. RequestSpecification --> given()
        // 2. Response--> when()
       //  3. ValidatableResponse --> then()

        // the reason for using response interface  instead of r.when and validatableResponse interface
        // is to reuse some part of the code when there are more than 1 test case

    }
    @Description("TC#2 Verify that create booking is not working with 500 error")
    @Test
    public void testNonBDDStylePOSTNegative() {

            String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";
        String payload = "{}"; // payload is empty here

        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);


        validatableResponse = response.then();
        validatableResponse.statusCode(500);

// In BDD style we cannot store the response here in Non BDD style we  can store response


    }
}