package com.thetestingacademy.TestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab267 {

    // A very important Integration Testcase scenario
    // CRUD operation
    // Create Booking --> will give u Booking ID
    // Create Authentication --> will give u Token
    // PUT Request --> with id and Token
    // Delete --> using id
    // Get--> using id --> and verify it should not exist
    // These are the Testcases

    // writing some functions
    String Token;
    Integer BookingID;

    // get token function
    public String getToken(){
        Token = "123";
        return Token;
    }
    // Before running the I need getToken and BookingID
    @BeforeTest
    public void getTokenAndBookingID(){
        Token = getToken();
        BookingID = 123;// I will make a Post request and Post Code to get the BookingID
    }

    // Put Request here I will write the Put Code
    @Test
    public void testPutRequest(){
        System.out.println(Token);
        System.out.println(BookingID);
    }

    // Delete Request using BookingID and Token
    @Test
    public void testDeleteRequest(){
        System.out.println(Token);
        System.out.println(BookingID);
    }

    @Test
    public void testGetRequest(){
        System.out.println(BookingID);
    }
}
