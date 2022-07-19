package com.adriens.colisnc.api;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class ApplicationTests {

    @Test
    public void testMinimal() throws Exception {
        given()
                .when().get("/colis/CA107308006SI")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }
}
