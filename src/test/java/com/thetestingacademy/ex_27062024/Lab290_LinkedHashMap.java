package com.thetestingacademy.ex_27062024;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Lab290_LinkedHashMap {

/*
          Topics:-
      1. Payload using Map
      2. Data Driven Testing via Excel
      3. GSON and Jackson API
      4. JSON Schema Validation
*/

    // 1. Payload using Map
    //   Previously we created a Post request and we used String payload
    // Instead of String payload we can use Map (HashMap) also.

    /*    This is the payload that we want to send/use in post request
          "{\n" +
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
 */
    // we can use Map. Map is key value pair
    // we want to keep the order of all the fields in the payload
    // if u use HashMap order will be random
    // In Tree Map order will be sorted ie; alphabetical or numerical
    // so, we can use Linked Hash Map - order will be as it is as we enter

    // most of the API supports random order also, ideally we should not use random order
    // But it is a good advice to use Linked HashMap so our order is preserved


    @Test
    public void testPostRequest (){
        // Create a LinkedHashMap to maintain the order of keys
        Map<String,Object> jsonBodyUsingMap = new LinkedHashMap<>();

        // Generate random first and last names
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        // Add key-value pairs to the main JSON map
        jsonBodyUsingMap.put("firstName", firstName);
        jsonBodyUsingMap.put("lastName", lastName);
        //    jsonBodyUsingMap.put("totalprice", faker.random().nextInt(1000));
        //  jsonBodyUsingMap.put("totalprice", faker.number().numberBetween(100, 1000));
        //  faker.number().numberBetween(100, 1000) instead of faker.random().nextInt(1000)
        //  to ensure a positive range for totalprice.
        jsonBodyUsingMap.put("depositpaid", faker.random().nextBoolean());

        // In string payload Booking dates is HashMap within HashMap
        // the moment u see {  } these brackers indicates a Map will be created
        // so, booking dates is a smaller Map within Bigger Map -> String payload
        // so create a new HashMap
        // Booking Dates Map: A nested map for booking dates is created and added to the main JSON body.

        // Create a nested map for booking dates
        Map<String,Object> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", "2018-01-01");
        bookingDatesMap.put("checkout", "2019-01-01");

        // Add the booking dates map to the main JSON map
        jsonBodyUsingMap.put("bookingDates", bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds","Breakfast");

        // Print the JSON body
        System.out.println(jsonBodyUsingMap);

        // Now I can make the Post request, Instead of payload I can use jsonBodyUsingMap

        //  Create a RequestSpecification object using RestAssured's given() method.
        RequestSpecification r = RestAssured.given();

        //  Send the POST request and log all request details. Capture the response.
        Response response;

        //  Create a ValidatableResponse object from the response and verify the status code is 200.
        ValidatableResponse validatableResponse;


        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";

        r.baseUri(Base_URL);
        r.basePath(Base_Path);
        r.contentType(ContentType.JSON).log().all();
        r.body(jsonBodyUsingMap);

        response = r.when().log().all().post();// Sends the POST request to the specified endpoint, logging the request details for debugging.
        String responseString = response.asString();// Converts the response to a string for easier printing and inspection.
        System.out.println(responseString); // Prints the response to the console.
        // This is useful for manual inspection and debugging to ensure the response is as expected.

        validatableResponse = response.then();
        validatableResponse.statusCode(200);
    }

// In real time people use Gson
// create a new package to understand better

}
