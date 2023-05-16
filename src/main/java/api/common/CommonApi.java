package api.common;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonApi {

    // GET Request
    public static Response get(RequestSpecification specification) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .spec(specification)
                .when().get()
                .then()
                .log().ifError()
                .extract().response();
    }

    // POST request
    public static Response post(RequestSpecification specification) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .spec(specification)
                .when().post()
                .then()
                .log().ifError()
                .extract().response();
    }

    // PUT Request
    public static Response put(RequestSpecification specification) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .spec(specification)
                .when().put()
                .then()
                .log().ifError()
                .extract().response();
    }

    // DELETE Request
    public static Response delete(RequestSpecification specification) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .spec(specification)
                .when().delete()
                .then()
                .log().ifError()
                .extract().response();
    }
}
