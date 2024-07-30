package com.thetestingacademy.ex_27062024.gson.serialization;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab293_gson_NegativeTC {



        RequestSpecification r = RestAssured.given();
        Response response;
        ValidatableResponse validatableResponse;

        @Description("TC#1 Verify that create booking is working with valid payload")
        @Test
        public void testNon_BDD_stylePOST_Positive() {

            String Base_URL = "https://restful-booker.herokuapp.com";
            String Base_Path = "/booking";




// This Lab293 is similar to 292
// but only by changing the setter names I can easily get a new negative testcase

            // create a booking object.
            Booking booking = new Booking();
            booking.setFirstname("James");
            booking.setLastname("Brown");
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


