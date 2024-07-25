package com.thetestingacademy.ex_22062024.CRUD.POST_2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Lab271 {



    @Test
    public void testBDD_stylePOST_Positive(){
        // To make a Post request we need
        // 1. URL
        // 2. Body - PAYLOAD - JSON - u can copy-paste from postman
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

        // content type is header
        RestAssured.given().baseUri(Base_URL).basePath(Base_Path).contentType(ContentType.JSON).log().all().body(Payload)

                .when().log().all().post()

                .then().log().all().statusCode(200);


        // In BDD style we cannot store the response
    }
}
