package com.thetestingacademy.ex_22062024.CRUD.PUT_3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Lab273 {

//    Declaring and initializing  instance variables for request specification, response, validatable response,
//    token, booking ID, base URL, and base path.

    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String token = "13f2b8de2317002";
    String bookingID = "1543";

    String BASE_URL = "https://restful-booker.herokuapp.com";
    String BASE_PATH = "/booking";

    @Test
    public void  testPutREQUESTNonBDD(){


//        Constructs the full path for the PUT request by appending the booking ID(API endpoint) to the base path.
        String BASE_PATH_UPDATED = BASE_PATH+"/"+bookingID;
        System.out.println(BASE_PATH_UPDATED);

        String payload = "{\n" +
                "    \"firstname\" : \"Saurab \",\n" +
                "    \"lastname\" : \"Ganguly\",\n" +
                "    \"totalprice\" : 11000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH_UPDATED);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(payload).log().all();

        response = r.when().log().all().put();

        vr = response.then().log().all();
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("Saurab"));
        vr.body("lastname", Matchers.equalTo("Ganguly"));

        // Matchers is a class which gives an equalTo function to verify expected with actual result







    }
}
