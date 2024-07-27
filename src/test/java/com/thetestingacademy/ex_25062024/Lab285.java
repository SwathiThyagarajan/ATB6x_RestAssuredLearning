package com.thetestingacademy.ex_25062024;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab285 {

/*
    Data Driven Testing using TestNG - but not recommended, Instead what we do is
    we MIX the Data Driven with the Apache POI
    Data Driven Testing means running a single Testcase with multiple inputs.
    ex: I have Login Testcase -> I can run this Testcase with 100's of username and password
    you can go to postman and run a post request of auth token with body/ payload as -
          username : admin
          password : admin
     like this u can create multiple requests with different payload
     How to do it in IntelliJ
     1. 1. make sure the Testcase which u want to make it as generic it is parameterised in nature
     2. Add a Rest Assured Logic

     To Run this Testcase u can use dataProvider annotation, here getData function provides the data.
     dataProvider = "getData"
     so now create a getData function with object of 2-dimensional array which will give/return  us the data
     with 2 fields ex: {"admin","admin"}. In 2d array here we have 2 columns and 3 Rows
     getData will give u an object 2-dimensional array. In this array we can have the new objects
     In the new object we can have 1st Testcase, similarly create TC2 and TC3
     and to this function add a dataProvider annotation

     what exactly DataProvider does ????
     @Test(dataProvider = "getData") here dataProvider is asking from where u are getting the data -> username & password
     "getData" says u can get it from getData function -> public Object[][] getData(){
     getData() function says I will return the 2d array

     But in realtime this not how we use ...
     In realtime the data of  @DataProvider getData() function
    @DataProvider
    public Object[][] getData(){
     return new Object[][]{
                new Object[]{"admin","admin"},
                new Object[]{"admin","password"},
                new Object[]{"admin","password123"}

     will be replaced by Apache POI

      @DataProvider
      public Object[][] getData1(){
          //  ApachePOI code
          // ApachePOI-> Read an Excel file which contain the data and give it to the getData() function
        return null;

        For Random username and password we can use java Faker liabrary
        u can add a dependency in pom.xml file 

*/


    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                new Object[]{"admin","admin"}, // negative Testcase
                new Object[]{"admin","password"},// positive Testcase
                new Object[]{"admin","password123"}
        };
    }
//     above  getData() function code will be replaced by Apache POI

    @DataProvider
    public Object[][] getDataFromExcel() {
//        ApachePOI code
//        Read an Excel file which contain the data and give it to the getData() function
        return null;
    }

    @Test(dataProvider = "getData")
    public void testAuthToGetToken (String username, String password){ // 1. make sure it is parameterised in nature
        System.out.println(username);
        System.out.println(password);

        // Now Add a Rest Assured Logic

        // making a Given --> When --> then --> request and checking -> Response statuscode 200 OK

    }




}
