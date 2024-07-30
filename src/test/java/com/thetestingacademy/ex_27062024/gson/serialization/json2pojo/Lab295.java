package com.thetestingacademy.ex_27062024.gson.serialization.json2pojo;


import com.google.gson.Gson;
import com.thetestingacademy.ex_27062024.gson.serialization.Booking;
import com.thetestingacademy.ex_27062024.gson.serialization.BookingDates;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab295 {


    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;

    @Description("TC#1 Verify that create booking is working with valid payload")
    @Test
    public void testNon_BDD_stylePOST_Positive() {

        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";

        // create a booking object.
        com.thetestingacademy.ex_27062024.gson.serialization.Booking booking = new Booking();
        booking.setFirstname("James");
        booking.setLastname("Brown");
        booking.setTotalprice(1500);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-06-01");
        bookingDates.setCheckout("2024-06-05");
        booking.setBookingdates(bookingDates); // Note the method name

        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);
        // what is booking here ? booking is an object reference of a class
        // Serialization
        // I can convert the booking into a json string by using gson

        Gson gson = new Gson();
        String jsonStringPayload = gson.toJson(booking);
        System.out.println(jsonStringPayload);// now our booking/payload is converted to json
        // now we have successfully converted our java object our pojo class into json string

//
//        r.baseUri(Base_URL);
//        r.basePath(Base_Path);
//        r.contentType(ContentType.JSON).log().all();
//        r.body(booking);
//
//        response = r.when().log().all().post();
//        String responseString = response.asString();
//        System.out.println(responseString);
//
//        validatableResponse = response.then();
//        validatableResponse.statusCode(200);
    }
}
