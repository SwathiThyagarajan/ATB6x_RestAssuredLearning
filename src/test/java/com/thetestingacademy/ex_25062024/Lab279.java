package com.thetestingacademy.ex_25062024;

import org.testng.annotations.Test;

public class Lab279 {

    // when I have 3 Testcases with same priority =1, then execution will be in alphabetical order

    @Test(priority = 1)
    public  void testMethodB(){
        System.out.println("Test Method B");
    }

    @Test(priority = 1)
    public  void testMethodA(){
        System.out.println("Test Method A");
    }

    @Test (priority =  1)
    public  void testMethodC(){
        System.out.println("Test Method C");
    }

/*     TestNG Priority in Java
1. Default priority = 0. If u don't mention the priority default priority will be applied 0
2. You can set the priority also. ex: 1,2,3,4
3. You can set up Negative priority also.ex : -1
4. You can set up same priority for all them as well. here execution will be in alphabetical order

*/

}
