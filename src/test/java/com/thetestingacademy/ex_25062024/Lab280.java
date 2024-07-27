package com.thetestingacademy.ex_25062024;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab280 {
/*
      In realtime we rarely use TestNG Priority rather we use grouping of testcases

      Grouping of the Testcases:-
          If I have 100 Testcases I will group them
          20 Testcases will belong to P0
          30 Testcases will belong to P1
          50 Testcases will belong to P3
                   OR
          40 Testcases will belong to Smoke test
          60 Testcases will belong to Sanity test


          How to do Grouping ??
               Consider the ex: where I have 3 testcases Smoke, Sanity and regression testcase

               Grouping is added in TestNG xml file (testng_280_sanity.xml)
               Above classes add groups and include ->refer testng_280_sanity.xml
               <groups>
            <run>
                <include name="sanity"></include>
            </run>
        </groups>
        futher to run the test case add this in @Test(groups = {"sanity"})
        now run the file in xml

        I can create multiple unlimited TestNG xml files for each
        1. sanity
        2. Regression
        3. Production
        4. QA environment '
        5. All - here u can run all of them, do not add group in xml to run all

        unless u assign priority by default all of them will have 0 priority and will run in alphabetical order

we can add more details to our testcases we can add description, AllureId, SeverityLevel etc.....
u can add all the TestNG allure annotations ex: u can use an asnnotation to mention to which Jira it belongs also

Every test case will have a Mapping to which project it belongs to and
ex: in excel  Once u have created all your Testcases u mention Testcase ID against each testcase.
copy the Testcase ID and paste it here in @Issue

u can allure report also by typing the below in terminal
    allure serve allure-results/

*/

    @Issue("BUGZ Project- TC123")  // used for mapping Testcase
    @AllureId("TC#1")
    @Severity(SeverityLevel.NORMAL)
    @Description("sanity Testcase")
    @Test(groups = {"sanity"},priority = 1)
//    public void sanityRun(){  -> here Instead of sanityRun we can mention as create Booking Positive Testcase
        public void CreateBookingPositiveTestcase(){
        System.out.println("Sanity");
        System.out.println("QA");
    }


    @Test(groups = {"sanity"},priority = 2)
    public void RegressionRun(){
        System.out.println("Regression");
    }

    @Test(groups = {"smoke"},priority = 3)
    public void SmokeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

    // we can have multiple also. if I run QA in xml it will run only QA
    @Test(groups= {"QA", "Production environment"},priority = 3)
    public void QARun(){
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

    // if I run Production environment in xml it will run  QA and Production environment
    @Test(groups= {"Production environment"},priority = 3)
    public void ProductionRun(){
        System.out.println("smoke");
        Assert.assertTrue(false);
    }

// unless u assign priority by default all of them will have 0 priority and will run in alphabetical order


    // u can allure report also by typing the below in terminal
    // allure serve allure-results/

}
