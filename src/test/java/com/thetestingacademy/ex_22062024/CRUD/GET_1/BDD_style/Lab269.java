package com.thetestingacademy.ex_22062024.CRUD.GET_1.BDD_style;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab269 {
    // given -> when we have the below
    // URL = https://api.zippopotam.us/IN/560037
    // HEADER ?, Cookies
    // base url = https://api.zippopotam.us
    // basePath = /IN/560037
    // Auth - Basic, Digest, JWT, Bearer Token, OAuth 2.0 ? = No


    // When  -> I make a Request
    // PaYLOAD - ? NO/yES - JSON. XML  -> String, Hashmap, Object class
    // GET Method



    // Then()--> I will receive a response.
    // Response Validation
    //  Status Code
    //  Response Body
    //  Time, Headers ,Cookies

      @Test
        public void getRequestBDD_style(){
          RestAssured
                  .given()
                  .baseUri("https://api.zippopotam.us")
                  .basePath("/IN/560037")

                  .when().log().all().get()

                  .then()
                  .log().all()
                  .statusCode(200);
          //        .statusCode(201); we got status code as 200 & Testcase failed so change to 200

          // log.all will print the logs

          // BDD Style vs Non BDD Style
          // In BDD Style we cannot reuse some part of the code there is duplicacy
          // look at it by creating a 2nd testcase
      }

    @Test
    public void getRequestBDD_style2() {
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/560037")

                .when().log().all().get()

                .then()
                .log().all()
                .statusCode(200);
    }
















}
