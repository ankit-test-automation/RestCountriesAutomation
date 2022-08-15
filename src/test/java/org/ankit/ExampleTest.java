package org.ankit;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;

public class ExampleTest {

    @Test
    public void test() {
        Response response =
                get("https://restcountries.com/v3.1/all");
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void test1() {
        baseURI = "https://restcountries.com/";
        given().
                get("v3.1/all").
                then().
                statusCode(200).
                log().
                all();
    }

    @Test
    public void test2() {

        baseURI = "https://restcountries.com/";
        given().
                get("v2/alpha/col").
                then().
                assertThat().
                body(JsonSchemaValidator.
                        matchesJsonSchema(
                                new File("resources/jsonschema.json")));
    }
}
