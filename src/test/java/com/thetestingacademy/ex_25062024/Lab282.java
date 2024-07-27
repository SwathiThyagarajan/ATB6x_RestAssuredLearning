package com.thetestingacademy.ex_25062024;

import org.testng.annotations.Test;

public class Lab282 {

    // depends upon methods -> allure TestNG annotation

    @Test
    public void getToken(){
        System.out.println("I will Run First");
    }

    @Test
    public void getBookingId(){
        System.out.println("I will Run First");
    }

    @Test(dependsOnMethods = {"getToken","getBookingId"},priority = 1)
    public void testputRequest(){
        System.out.println("put Request");
    }
    @Test(dependsOnMethods = {"getToken","getBookingId"},priority = 2)
    public void testDeleteRequest(){
        System.out.println("Delete Request");
    }




}
