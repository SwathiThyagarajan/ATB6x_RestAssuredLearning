package com.thetestingacademy.ex_27062024.gson.serialization;

public class BookingResponse {

    // 3 classes can map everything in the restful booker project
    // 1. Booking
    // 2. BookingDates
    // 3. BookingResponse

    // Private fields for encapsulation
     private Integer bookingid;
     private Booking booking;

    // Getter and Setter for bookingid and booking


    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    /*
       All these till now in serialization
        we saw the hard way of creating the classes and objects for the payload

        Now let's see an east way no need to create from scratch.
        we need to understand how many classes we need to create overall from all the request
        each request and response has a different class and  payload. few may be common
        Just by creating 3 classes. we can use them for all other crud request also
        we can create 100's of testcases

        You do not have to create the classes u can use json2pojo liabrary

        Goto json2pojo website -> copy the payload and paste in the website
        give the class name -> booking
         and package name -> com.thetestingacademy.ex_27062024.serialization;
        select the source type -> json
        how u want it -> gson
        click on preview u can copy it create a new package

     */
}
