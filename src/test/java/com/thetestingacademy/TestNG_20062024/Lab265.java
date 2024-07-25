package com.thetestingacademy.TestNG_20062024;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Lab265 {



    @Description("TC#1")
    @Test
    public void testcase() {

        // Assertions means Verifying the Expected Result with the Actual Result
        // Expected Result =  Actual Result
        // ex: status code 200 == to 200 ( 200 must be equal to 200)
        // In TestNG there are 2 types of Assertions
        //  1. Soft Assertions

//        SoftAssert s = new SoftAssert();
//        s.assertEquals("Swathi","swathi","Not Equal") ;
//        System.out.println("End of the Program");
//        System.out.println("End of the Program 2");
//        s.assertAll(); //assertAll means until here all of the above code will run
//
//        here even though Expected Result is not equal to Actual Result sout is printed. so we can use Hard Assertions

         // 2. Hard Assertions
        Assert.assertEquals("Swathi","swathi","Not Equal");
        System.out.println("End of the Program");


        // Hard Assertion will stop the execution it will kill the main thread
        // if line no.30 fails next line will not be executed

        // Which type of Assertion we are using depends on the type of request we are using
        // ex: In PUT Request if Token is not generated in the 1st Request then we must use Hard Assertion
        // ex 2: I am making a Get Request I did not get the name as Swathi but all other things are valid
        // I want to verify all other things and complete my program here i must use soft assertion


        // Interview Question --> Soft Assertion vs Hard Assertion
    }






}
