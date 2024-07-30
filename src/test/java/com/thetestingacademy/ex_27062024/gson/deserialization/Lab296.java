package com.thetestingacademy.ex_27062024.gson.deserialization;

import com.google.gson.Gson;
import com.thetestingacademy.ex_27062024.gson.serialization.Booking;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab296 {

    // Deserialization :-
    //      converting Json string to Java object

    @Test
    public void testDeserialization(){

        // suppose I have a Json string
        String jsonString = "{\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"firstname\" : \"Amit\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        Gson gson = new Gson();
        Booking booking = gson.fromJson(jsonString,Booking.class);
        System.out.println(booking.toString());
        System.out.println(booking.getFirstname());
        System.out.println(booking.getLastname());

        // Now we can do Assertions / Verification
        Assert.assertEquals(booking.getFirstname(),"Amit");
    }

    // the advantage of serialization and deserialization is if u use String payload
    // then to change the payload and response validation is very difficult
    // In String payload all the data has to be stored within the double quotes " ";
    // and ""; this will be present in the source code or Testcases which is not a good practice

    //  Even in the Hash Map and Linked HashMap we are keeping the payload in the Testcases
    // Ideally your payload should be separate from the testcase

    // For that purpose we can basically create class and object
    // But when we use class and object the testcase will call the Class or Object only when needed,
    // and both Classes and Objects are separate folder
    // I can write unlimited no. of testcases now by using the same class or object
    // I don't have to Hardcode the payload into the testcase now.

    // In the Automation Framework we can see this practically

    // why we are doing deserialization ?
    // we are doing deserialization so that we can verify the object easily

    // Now we can do Assertions / Verification

    // Similar serialization and deserialozation can be done by Jackson API
    // u need to add Jackson liabrary- use Jackson databind maven

    // You can use either gson or Jackson any one of them u cannot use both of them at once

}
