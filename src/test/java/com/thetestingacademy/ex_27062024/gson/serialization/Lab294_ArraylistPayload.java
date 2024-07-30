package com.thetestingacademy.ex_27062024.gson.serialization;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Lab294_ArraylistPayload {

    // suppose I have array payload like this
    //u can ignore this because error will be faced when u run the program

    //[
    //  {
    //    "firstname" : "Rahul",
    //    "lastname" : "Dravid",
    //    "totalprice" : 111,
    //    "depositpaid" : true,
    //    "bookingdates" : {
    //        "checkin" : "2018-01-01",
    //        "checkout" : "2019-01-01"
    //    },
    //    "additionalneeds" : "Breakfast"
    //},

    //{
    //    "firstname" : "Sachin",
    //    "lastname" : "Bose",
    //    "totalprice" : 111,
    //    "depositpaid" : true,
    //    "bookingdates" : {
    //        "checkin" : "2018-01-01",
    //        "checkout" : "2019-01-01"
    //    },
    //    "additionalneeds" : "Breakfast"
    //}
    //  ]


    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;

    @Description("TC#1 Verify that create booking is working with valid payload")
    @Test
    public void testNon_BDD_stylePOST_Positive() {

        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";

        // Create two booking objects
        Booking booking1 = new Booking();
        booking1.setFirstname("Rahul");
        booking1.setLastname("Dravid");
        booking1.setTotalprice(111);
        booking1.setDepositpaid(true);

        BookingDates bookingDates1 = new BookingDates();
        bookingDates1.setCheckin("2018-01-01");
        bookingDates1.setCheckout("2019-01-01");
        booking1.setBookingdates(bookingDates1);
        booking1.setAdditionalneeds("Breakfast");

        Booking booking2 = new Booking();
        booking2.setFirstname("Sachin");
        booking2.setLastname("Bose");
        booking2.setTotalprice(111);
        booking2.setDepositpaid(true);

        BookingDates bookingDates2 = new BookingDates();
        bookingDates2.setCheckin("2018-01-01");
        bookingDates2.setCheckout("2019-01-01");
        booking2.setBookingdates(bookingDates2);
        booking2.setAdditionalneeds("Breakfast");

        // Add bookings to the payload list
        List<Booking> payload = new ArrayList<>();
        payload.add(booking1);
        payload.add(booking2);

        // Print the payload for debugging
        System.out.println(payload);

        r.baseUri(Base_URL);
        r.basePath(Base_Path);
        r.contentType(ContentType.JSON).log().all();
        r.body(payload); // Send the payload as the body

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse = response.then();
        validatableResponse.statusCode(200);
    }
}
