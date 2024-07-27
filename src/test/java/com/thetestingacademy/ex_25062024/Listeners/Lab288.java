package com.thetestingacademy.ex_25062024.Listeners;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListener.class)
public class Lab288 {

    @Test(groups = "sanity")
    public void test1(){
        System.out.println("test1");
        Assert.assertTrue(false);
    }

    @Test(groups = "sanity")
    public void test2(){
        System.out.println("test2\n");
        Assert.assertTrue(true);
    }

    // when I am done with Testcase 1 and Testcase 2 I need to send email to QA Lead

    @AfterSuite
    public void emailToQALead(){
        // send the email
        System.out.println("After Suite Executing.....");
        System.out.println("Sending Email");
    }

    /*
         I have created a listener to track the execution and suite information
         and I want to give how much time it will take to execute the testcase 1 and 2
         and  I want to see the results of the Testcases


         I can write a Logic/ Java code to send an email also by adding a dependency  JavaMail API library
         but we are not using it
     */
}
