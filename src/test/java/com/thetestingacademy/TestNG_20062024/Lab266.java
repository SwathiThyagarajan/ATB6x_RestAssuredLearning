package com.thetestingacademy.TestNG_20062024;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab266 {

    // we can create testng xml files for Lab ex: ie; testcases also

    @Test
    public void testCase1(){
        Assert.assertEquals("true","true");
    }

    @Test
    public void testCase2(){
        Assert.assertEquals("false","true");
    }
    // create a testng.xml file for this
}
