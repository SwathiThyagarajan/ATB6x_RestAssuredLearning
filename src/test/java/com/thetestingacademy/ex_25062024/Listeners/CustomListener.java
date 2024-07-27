package com.thetestingacademy.ex_25062024.Listeners;

import org.testng.IExecutionListener;
import org.testng.ISuiteListener;
import org.testng.annotations.Listeners;

public class CustomListener implements IExecutionListener, ISuiteListener {

/*
     IExecutionListener will track
     1. when - execution starts
     2. when - execution Finish

     ISuiteListener will track
     1. when - Suite starts
     2. when - Suite Finish

     The moment u implement IExecutionListener, ISuiteListener
     you can use Generate the overridden methods

     Listeners can be reused

*/


    //  Creating Listeners
    @Override
    public void onExecutionStart() {
        System.out.println("onExecutionStart");
        // I can add some code as well
        long startTime = System.currentTimeMillis();
        System.out.println("**** *** Started Execution at -  " + startTime);

    }

    @Override
    public void onExecutionFinish() {
        long endTime = System.currentTimeMillis();
        System.out.println("**** *** Finished Execution at -  " + endTime);
        System.out.println("onExecutionFinish");
    }
    // Now I need to attach the created Listeners  to Lab 288 above public class add Listeners annotation
  //  @Listeners(CustomListener.class)
    // u can create a TestNG file also u need to add listener in this file also above test verbose
}
