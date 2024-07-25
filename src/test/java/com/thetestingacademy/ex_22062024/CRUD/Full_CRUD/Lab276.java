package com.thetestingacademy.ex_22062024.CRUD.Full_CRUD;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab276 {


    @BeforeTest
    public void getToken(){
        System.out.println("1");
    }

    @BeforeTest
    public void getBookingID(){
        System.out.println("2");
    }

    @Test
    public void t3(){
        // before running this test I want gettoken and bookingid to be executed and created so, I used before test
        System.out.println("3");
    }
}
