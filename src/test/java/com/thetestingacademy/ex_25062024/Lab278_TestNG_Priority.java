package com.thetestingacademy.ex_25062024;

import org.testng.annotations.Test;

public class Lab278_TestNG_Priority {

    // TestNG Priority in Java

    // we can set some priority in TestNG
    // suppose I have 3 testcase all of them are normal methods
    // only if u add TestNG annotations @test u can run the testcase

    @Test(priority = 1)
    public  void testMethodOne(){
        System.out.println("Test Method One");
    }

    @Test(priority = 2)
    public  void testMethodTwo(){
        System.out.println("Test Method Two");
    }

    @Test (priority =  0)
    public  void testMethodThree(){
        System.out.println("Test Method Three");
    }

//    here we have done preserve-order in xml file  so the output will be alphabetical in nature
//    Test Method One
//    Test Method Three
//    Test Method Two
    //  so, testcases will be executed in preserved-order
    // I can give some priority to the testcases which determines the order of execution

    // 0 Zero is the highest priority
    //

    @Test (priority = -1)
    public void testMethodNegativeOne(){
        System.out.println("Test Method Negative One");
    }
    // so, now  NegativeOne will be executed first
}
