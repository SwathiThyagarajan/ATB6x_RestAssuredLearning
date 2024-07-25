package com.thetestingacademy.ex_22062024.CRUD.Full_CRUD;

public class ValidatingTheResponse {



/*

       JSON path Evaluator


 1.    when I make a Put request below is the response I am getting
     {
    "firstname": "Saurab",
    "lastname": "Ganguly",
    "totalprice": 11000,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}

 (*) using JSON path Evaluator if I want the firstname directly then

 (*) in JSONPath search box enter $.firstname u will get only the firstname Saurab

 (*) if I want to get checkin then I must use -> $.bookingdates.checkin



 2.when I make a Post request create booking  below is the response I am getting
{
    "bookingid": 255,
    "booking": {
        "firstname": "Rahul",
        "lastname": "Dravid",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
    }
}
(*) using JSON path Evaluator if I want the firstname directly then
(*) in JSONPath search box enter $.booking.firstname
(*) if I want to get checkin then I must use -> $.booking.bookingdates.checkin

Instead of . dot we can use this also --> $.["booking"]["bookingdates']["checkin']
- this may not work in JSON path Evaluator but in real time it works
- .dot does not work when there is space -> ["booking dates']


 3. When you have a data with An array containing objects, each representing a phone number with a type and number

 {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
    },
    "phoneNumbers": [
        {
            "type1": "iPhone",
            "number": "0123-4567-8888"
        },
        {
            "type2": "home",
            "number": "0123-4567-8910"
        }
    ]
}

(*) using JSON path Evaluator if I want to fetch any info
(*) In the payload the moment U see -->  {  I must use . dot
(*) To get age  I must type -> $.age
(*) To get city I must type $.address.city
(*) To get type1 I must enter $.phoneNumbers[:1].type1
      - here instead of using phoneNumbers.type1 I am using phoneNumbers[:1].type1
      - because [] Indicates arary used in the json response above and for getting array details u must use []



 4. When you have JSON Array data then instead of . use []

[
    {
        "firstname": "Saurab",
        "lastname": "Ganguly",
        "totalprice": 11000,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
    },
    {
        "firstname": "Rahul",
        "lastname": "Dravid",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
    }
]

(*) To get 1st item enter this -> $[0] -> u will get {
    "firstname": "Saurab",
    "lastname": "Ganguly",
    "totalprice": 11000,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    }

(*) In the 1st item if I want firstname then enter this -> $[0]["firstname"]
(*) if I want the checkin of Rahul Dravid then enter -> $[1][bookingdates][checkin]
         or $[1]["bookingdates"]["checkin"]


         we can check this in our Lab 277 code
*/
}
