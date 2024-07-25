package com.thetestingacademy.TestNG_20062024;


import org.testng.annotations.*;

public class Lab264 {

    @BeforeSuite
     void demo1(){
         System.out.println("1 Before Suite");
        System.out.println("Open Database");
        System.out.println("Read CSV / Excel");
        System.out.println("Read Text, Env or property");
     }

    @BeforeTest
    void demo2(){
        System.out.println("2 Before Test");
    }
    @BeforeClass
    void demo3(){
        System.out.println("3 Before class");
    }

    @BeforeMethod
    void demo4(){
        System.out.println("4 Before Method");
    }

    @Test
    void demo5(){
        System.out.println("5 Test");
    }

    @AfterMethod
    void demo6(){
        System.out.println("6 After class");
    }

    @AfterClass
    void demo7(){
        System.out.println("7 After Method");
    }

    @AfterTest
    void demo8(){
        System.out.println("8 After Test");
    }

    @AfterSuite
    void demo9(){
        System.out.println("9 After Suite");
        System.out.println("Close Database connection");
        System.out.println("Close opened files");
    }


}
