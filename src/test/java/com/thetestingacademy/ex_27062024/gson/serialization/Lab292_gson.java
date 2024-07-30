package com.thetestingacademy.ex_27062024.gson.serialization;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab292_gson {

    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;

    @Description("TC#1 Verify that create booking is working with valid payload")
    @Test
    public void testNon_BDD_stylePOST_Positive() {

        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";
        // remove the payload
//        String Payload = "{\n" +
//                "    \"firstname\" : \"Jim\",\n" +
//                "    \"lastname\" : \"Brown\",\n" +
//                "    \"totalprice\" : 111,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2018-01-01\",\n" +
//                "        \"checkout\" : \"2019-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";
// In the above string payload we have 2 classes {}-> This indicates a class
// we are going to convert the string payload into classes.
// For that create 2  classes with name booking and booking dates
// why we have created a Booking class and BookingDates class ?????
        // we want to reuse the code. so we can now remove the above payload and use


        // create a booking object.  This is easy to understand
        Booking booking = new Booking();
        booking.setFirstname("Swathi");
        booking.setLastname("Thyagarajan");
        booking.setTotalprice(1500);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-06-01");
        bookingDates.setCheckout("2024-06-05");
        booking.setBookingdates(bookingDates); // Note the method name

        booking.setAdditionalneeds("Breakfast");

        r.baseUri(Base_URL);
        r.basePath(Base_Path);
        r.contentType(ContentType.JSON).log().all();
        r.body(booking);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse = response.then();
        validatableResponse.statusCode(200);
    }
}
