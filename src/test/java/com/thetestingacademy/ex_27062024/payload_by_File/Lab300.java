package com.thetestingacademy.ex_27062024.payload_by_File;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

public class Lab300 {

    @Description("TC#1 Verify that create booking is working with valid payload")
    @Test
    public void testPostRequest(){
        // u can copy-paste the post request code

        RequestSpecification r = RestAssured.given();
        Response response;
        ValidatableResponse validatableResponse;


            String Base_URL = "https://restful-booker.herokuapp.com";
            String Base_Path = "/booking";

            // the Payload we need to get it from a file so create a new file in resources name it as postRequest.json
            File file = new File("src/test/resources/postRequest.json");

            r.baseUri(Base_URL);
            r.basePath(Base_Path);
            r.contentType(ContentType.JSON).log().all();
            r.body(file);

            response = r.when().log().all().post();// Sends the POST request to the specified endpoint, logging the request details for debugging.
            String responseString = response.asString();// Converts the response to a string for easier printing and inspection.
            System.out.println(responseString); // Prints the response to the console.
            // This is useful for manual inspection and debugging to ensure the response is as expected.

            validatableResponse = response.then();
            validatableResponse.statusCode(200);

            // Swagger is an API documentation tool just like imgur , postman documentation
        // we can create our own documentation also .
        // In postman u can publish ur own documentation also


        }
    }

