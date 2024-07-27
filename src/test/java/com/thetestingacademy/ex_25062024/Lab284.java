package com.thetestingacademy.ex_25062024;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lab284 {

    // we can use parameters also - it is rarely used

    // Good habit to follow always all ur test case should start with test
    // the testcase must always be public void

    // In this case Testcase is very generic and parameterised -
    // which means you can give the value and based on that this Testcase will execute the code
    // But How do we give the information ??
    // you can create a TestNG xml file with parameter
    // and also add a parameter TestNG annotation to the Testcase and mention the name

    // Therefore without changing the code
    // by only changing the TestNG xml we can run the same testcase in whichever browser we want



    @Parameters("browser")
    @Test(priority = 1)
    public void demo1(String value){
        System.out.println("Browser is " +value);
        // open the browser and based on the browser I will select wht I need to use
        // give me the browser based on the browser I will select and use this
        // I can use switch case for this

        // value of browser if it is firefox then I will run firefox code
        switch (value){
            case "firefox":
                // Firefox code
                System.out.println("Firefox starting and Running Testcase");
                break;
                // if browser is chrome then I will use chrome code
            case "chrome":
                System.out.println("Chrome starting and Running Testcase");
                break;
            default:
                System.out.println("No Idea What to Start");

        }
    }
}
