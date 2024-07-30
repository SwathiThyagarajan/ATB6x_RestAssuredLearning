package com.thetestingacademy.ex_25062024;

import org.testng.annotations.Test;

public class Lab283_dependsOnGroups {

    // depends upon groups -> allure TestNG annotation

    // ex: I have a testcase getToken I have added a group in it and priority =1


    @Test(groups ={"init"},priority = 1)
    public void getToken(){
        System.out.println("server started Ok");
    }

    @Test(groups = {"init"},priority = 2)
    public void getBookingId (){
        System.out.println("init Environment");
    }

    // put will only run when all the testcases/ init groups are run
    @Test(dependsOnGroups = {"init.*"})
    public void testputRequest(){
        System.out.println("Now I will Run");
    }


}
