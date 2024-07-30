package com.thetestingacademy.ex_27062024.jacksonAPI.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thetestingacademy.ex_27062024.gson.serialization.Booking;
import com.thetestingacademy.ex_27062024.gson.serialization.BookingDates;
import org.testng.annotations.Test;

public class Lab297 {

    @Test
    public void serializationJackson() throws JsonProcessingException {

//   creating a Booking object, Booking class already created in gson
        Booking booking = new Booking();
        booking.setFirstname("Donald");
        booking.setLastname("Trump");
        booking.setDepositpaid(true);
        booking.setTotalprice(8000);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-06-10");
        bookingDates.setCheckout("2024-06-20");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        // Now I need to convert this Object into Json String
        // do it using Object Mapper use databind one not Restassured

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        // writeValueAsString - this will give u an error add a throws condition
        System.out.println(jsonString);








    }
}
