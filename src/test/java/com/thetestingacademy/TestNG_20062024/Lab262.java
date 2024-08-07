package com.thetestingacademy.TestNG_20062024;

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
    @Test(enabled = false) // if u mention enabled = false the test case will not run
    public void getRequest2(){
        System.out.println("TC2");
    }

    @Description("TC#1 Verify Get Request 3")
    @Test
    public void getRequest3(){
        System.out.println("TC3");
    }

}
