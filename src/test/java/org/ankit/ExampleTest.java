package org.ankit;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleTest {

    @Test
    public void test(){
        Response response =
                get("https://restcountries.com/v3.1/all");
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void test1(){
        baseURI = "https://restcountries.com/";
        given().
                get("v3.1/all").
                then().
                statusCode(200).
                log().
                all();
    }

    @Test
    public void test2(){
        System.out.println("Test 3");
    }
}
