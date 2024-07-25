package com.thetestingacademy.ex_22062024.CRUD.GET_1.NonBDD_Style;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab270 {


    // To use Non BDD style u must remember,
    // client makes a Request, server gives a Response
    // to make a Request Rest Assured provides us with an interface  known as REQUEST SPECIFICATION
    // similarly for Response Rest Assured provides us with an interface  known as RESPONSE SPECIFICATION
    // REQUEST SPECIFICATION:-
    // it is an interface, it has some inbuilt functions
    // How to use it

    RequestSpecification rs = RestAssured.given(); // this is common for both the Testcase

    @Test
    public void getRequestNonBDD_style() {
        // .given() will create a test specification and get a Request specification
        // all the functions that we have seen will now directly be available here
        // given
        rs.baseUri("https://api.zippopotam.us"); // the difference is we are not using builder pattern
        rs.basePath("/IN/560037"); // by using ; we can finish all of them

        rs.when().log().all().get();

        rs.then().log().all().statusCode(200);
    }
    // BDD Style vs Non BDD Style
    // In Non BDD Style we can reuse some part of the code
    // example when I create another Test case I can keep some variables as constant for both test case ie; reuse
    // RequestSpecification rs = RestAssured.given(); // this is common for both the Testcase

    // so In API Testing we will use Non BDD Style / RequestSpecification

    @Test
            public void getRequestNonBDD_style2() {
        rs.baseUri("https://api.zippopotam.us");
        rs.basePath("/IN/560037");

        rs.when().log().all().get();

        rs.then().log().all().statusCode(200);

    }
}
