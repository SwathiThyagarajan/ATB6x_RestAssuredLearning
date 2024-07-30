package com.thetestingacademy.ex_27062024.jsonSchemaValidation;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

public class Lab299 {

/*
                Json Schema Validation


      example this is the response that we want to validate
{
  "userId": 1,
  "id": 2,
  "title": "qui est esse",
  "body": "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"
}

when u want to validate the response we generally create a Json and Schema for this.
      we should go to a website jsonschema.net -> log in with email
      paste the response and click on submit this will give u a schema u can copy the schema
      create a java file and store it as schema.json


      you need to add json schema validator maven dependency




*/

    @Test
    public void testJsonSchemaValidation() {
        RestAssured.given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when().get("/posts/1")  // Adjusted to get a specific post with a valid endpoint
                .then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schema.json")));


        // ideally u should keep the schema.json into a Resource folder it is a good practice
        // so move the schema.json to resource folder


/*       Schema Validation
    1. create a RestAssured function
    2. enter the base uri ( from chapGPT)
    3. use get() function u will get a response
    4. then use assertThat function for validation
    5. validate/assert the body inside this use the RestAssured function ->JsonSchemaValidator
    6. using .matchesJsonSchema verify the body with schema
    7. mention the path where schema is present copy the path -> from content root and paste
       (new File("src/test/java/com/thetestingacademy/ex_27062024/jsonSchemaValidation/schema.json")))

 */
    }
}
