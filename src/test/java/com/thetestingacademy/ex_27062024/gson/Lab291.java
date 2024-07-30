package com.thetestingacademy.ex_27062024.gson;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab291 {

/*
    Until now, we use payload in the form of -> String, Map (Linked Hash Map).
    String, Map are rarely used.
    80 - 90%  Classes and Objects (Serialization and Deserialisation) are used.

    Serialization vs Deserialisation

we have a client and server when ever we send a request using java programming language
java has everything object format. java sends the data in classes and object. java wants everything in class and object
even the payload should be in class and object.
when you want to transfer the payload to the server in object format server cannot understand it
Therefore u need to convert it into byte stream

Generally we convert our java object class into a Json string(byte stream data).
So, client converts the object class payload into Json string(byte stream data).

    similarly Reverse is done at the server level.
     server converts back the Json string(byte stream data) into object class

       Serialization is the process of converting a Java object into a byte stream.
     This byte stream can be saved to a file, sent over a network, or stored in a database.
     The main purpose is to persist the state of an object so that it can be recreated later.

How it works:
The object must implement the Serializable interface.
The ObjectOutputStream class is used to write the object to an output stream.

            Deserialization
Deserialization is the reverse process where the byte stream is converted back
into a copy of the original object. It reconstructs the object from the stored state.

How it works:
The object class must implement the Serializable interface.
The ObjectInputStream class is used to read the object from an input stream.

Use Cases
Serialization:
Saving the state of an object to a file for later use.
Sending objects over a network between JVMs.
Storing objects in a database in a serialized form.

Deserialization:
Loading the state of an object from a file.
Receiving objects sent over a network.
Retrieving objects from a database.


*/
    // In RestAssured-> the Payload that u need to send is in-> Class or Objects it has to be converted into-> JSONString
    // ( Who will Help in conversion?? ->Library(Gson)) - Serialization
    // Response will be in-> jsonString it has to be converted into-> Class or OBject ( Deserialization)

/*    This is the payload that we want to send/use in post request
          "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
 */
// How to add Gson Liabrary into our project-> add the dependency in pom.xml

// Now how to use the payload see Lab292

    //  Create a RequestSpecification object using RestAssured's given() method.
    RequestSpecification requestSpecification = RestAssured.given();

    //  Send the POST request and log all request details. Capture the response.
    Response response;

    //  Create a ValidatableResponse object from the response and verify the status code is 200.
    ValidatableResponse validatableResponse;

    @Description("TC#1 Verify that create booking is working with valid payload")
    @Test
    public void testNon_BDD_stylePOST_Positive() {

        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";
        String Payload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        // Disadvantage of having payload in string format is
        // generally we create 100's of testcases with same payload with same key but different value.
        // ex: if u change the key from firstname to firstName then u need to change it in all 100 testcases which is a huge task
// so, we can take out this payload and create a normal class and object

        requestSpecification.baseUri(Base_URL);
        requestSpecification.basePath(Base_Path);
        requestSpecification.contentType(ContentType.JSON).log().all();
        requestSpecification.body(Payload);

        response = requestSpecification.when().log().all().post();// Sends the POST request to the specified endpoint, logging the request details for debugging.
        String responseString = response.asString();// Converts the response to a string for easier printing and inspection.
        System.out.println(responseString); // Prints the response to the console.
        // This is useful for manual inspection and debugging to ensure the response is as expected.

        validatableResponse = response.then();
        validatableResponse.statusCode(200);

    }

}