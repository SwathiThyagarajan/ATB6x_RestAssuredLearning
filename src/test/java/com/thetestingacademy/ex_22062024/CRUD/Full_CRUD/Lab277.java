package com.thetestingacademy.ex_22062024.CRUD.Full_CRUD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;



public class Lab277 {


    // Variables
    String token;
    Integer bookingId;
    RequestSpecification requestSpecification = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;

    @BeforeTest
    public void getAToken(){

        // For creating a Token we need payload
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.when().post();

        validatableResponse = response.then();
        validatableResponse.statusCode(200);

        // Now I want to Extract the Token from using extact function and store the Token

        token = response.then().log().all().extract().path("token");
        Assert.assertNotNull(token); // token should not be null/empty

    }

    @BeforeTest
    public void getBookingID(){

        String payload = "{\n" +
                "    \"firstname\" : \"Rahul\",\n" +
                "    \"lastname\" : \"Dravid\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.when().post();

        validatableResponse = response.then();
        String resposeString = response.asString();
        System.out.println(resposeString);

        validatableResponse.statusCode(200);

        // Extract and store booking id

        bookingId = response.then().log().all().extract().path("bookingid");
        // In case if u want to extract firstname then use this
        String firstName = response.then().log().all().extract().path("booking.firstName");
        System.out.println(firstName);
        System.out.println(bookingId);
        Assert.assertNotNull(bookingId);

    }


    @Test
    public void testPutRequestPositive(){


        String payload = "{\n" +
                "    \"firstname\" : \"Amit\",\n" +
                "    \"lastname\" : \"Dravid\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/"+bookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
      //  requestSpecification.auth().oauth2("token");

        // Put request
        requestSpecification.body(payload).log().all();

        response = requestSpecification.when().put();

        validatableResponse = response.then();
        validatableResponse.statusCode(200);


       // printing the response
        String fulResponseJSONString = response.asString();
        System.out.println(fulResponseJSONString);

        // Verify all the key and value pairs in the response
        // I can verify firstname, lastname, deposit etc...

        //  In 3 Ways You can verify the response
        // 1. RA - Matchers
        //  2. TestNG Asserts
        // 3 TestNG Assertion with JSON Path Lib
        // 4. AssertJ Matching

        // 1. RA - Matchers
        validatableResponse.body("firstname", Matchers.equalTo("Amit"));
        validatableResponse.body("lastname", Matchers.equalTo("Dravid"));

        //  2. TestNG Asserts
        String firstNameResponse = response.then().log().all().extract().path("firstname");
        Assert.assertEquals(firstNameResponse, "Amit");

        // 3 TestNG Assertion with JSON Path Lib
        // Extraction
        JsonPath jsonPath = new JsonPath(fulResponseJSONString);
        String firstNameJSONPathExtracted = jsonPath.getString("firstname");
        String lastNameJSONPathExtracted = jsonPath.getString("lastname");
        Integer totalpriceJSONPathExtracted = jsonPath.getInt("totalprice");
        String checkinDate = jsonPath.getString("bookingdates.checkin");


        // Assertion
        Assert.assertEquals(firstNameResponse, "Amit");
        Assert.assertEquals(lastNameJSONPathExtracted, "Dravid");
        Assert.assertEquals(totalpriceJSONPathExtracted,111);
        Assert.assertEquals(checkinDate,"2018-01-01");
        Assert.assertNotNull(totalpriceJSONPathExtracted);


        // If JSON is an Array Response then use this
        //        String checkin = jsonPath.getString("[0][\"bookingdates\"][\"checkin\"]");
        //        System.out.println(checkin);



        // 4. AssertJ Matching
        // AssertJ is a fluent Assert liabrary u can add it by coping the Maven dependency from assetj github page
        // paste it in pom.xml

       assertThat(firstNameJSONPathExtracted)
               .isEqualTo("Amit")
               .isNotBlank()
               .isNotEmpty();

       assertThat(totalpriceJSONPathExtracted).isPositive().isNotZero().isNotNegative();


    }



}