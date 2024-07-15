package com.thetestingacademy.TestNG;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class Lab262 {

// All the TestNG methods do not return anything

    @Description("TC#1 Verify Get Request 1")
    @Test
    public void getRequest(){
        System.out.println("TC");
    }

    @Description("TC#1 Verify Get Request 2")
    @Test(enabled = false)
    public void getRequest2(){
        System.out.println("TC2");
    }

    @Description("TC#1 Verify Get Request 3")
    @Test
    public void getRequest3(){
        System.out.println("TC3");
    }

}
