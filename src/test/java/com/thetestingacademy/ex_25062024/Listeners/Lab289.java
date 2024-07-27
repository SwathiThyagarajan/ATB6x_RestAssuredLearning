package com.thetestingacademy.ex_25062024.Listeners;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListener.class)
public class Lab289 {


    @Test(groups = "sanity")
    public void test1(){
        System.out.println("test1");
        Assert.assertTrue(true);
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

}
