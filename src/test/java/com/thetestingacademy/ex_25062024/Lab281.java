package com.thetestingacademy.ex_25062024;

import org.testng.annotations.Test;

public class Lab281 {

/*
      ex: I have a function-ServerStartedOK and a  method -method2 I cannot Run method2 unless ServerStartedOK is Run
For this purpose u can use @Test(dependsOnMethods = "ServerStartedOK" ) in method2

In our API Testing to make a put request it depends on get token and get booking id
so in put request we can add depends upon




*/

    @Test
    public void ServerStartedOK(){
        System.out.println("I will Run First");

    }

    // if u run this 1st ServerStartedOK will run then method will be executed
    @Test(dependsOnMethods = "ServerStartedOK" )
    public void method2 (){
        System.out.println("method2");
    }
}
