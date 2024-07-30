package com.thetestingacademy.ex_25062024;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class Lab286_Faker {


/*    For Random username and password we can use java Faker liabrary
    u can add a dependency in pom.xml file
*/

    // Example 1 - I can generate random Fake details for testing purpose
//    I want to perform/ execute  a RestAssured call. I want to generate random usernames or passwords
//   I can generate them by using Faker.
//   There is a Faker class that is created  and this will give u the random username and password
//   The random data keeps changing each time when u run the testcase

    @Test
            public void testDemo1(){
        Faker faker = new Faker();

        String name = faker.name().fullName(); // Miss Samanta Schmidt
        System.out.println("Random fullName: " + name);

        String firstName = faker.name().firstName(); // Emory
        System.out.println("Random firstName: " + firstName);

        String lastName = faker.name().lastName(); // Barton
        System.out.println("Random lastName: " + lastName);

        String phoneNumber = faker.phoneNumber().phoneNumber();
        System.out.println("Random phoneNumber: " + phoneNumber);

        String streetAddress = faker.address().streetAddress();
        System.out.println("Random streetAddress: " + streetAddress);

        String username = faker.name().username();
        System.out.println("Random Username: " + username);

        String password = faker.internet().password();
        System.out.println("Random Password: " + password);
    }



}
