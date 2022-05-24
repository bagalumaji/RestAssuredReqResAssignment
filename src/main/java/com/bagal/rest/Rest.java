package com.bagal.rest;

import io.restassured.response.Response;

import static com.bagal.config.ReqResConfigFactory.getConfig;
import static com.bagal.reports.ExtentLogger.info;
import static io.restassured.RestAssured.given;

public final class Rest {
    private Rest(){}

    public static Response POST(Object object){
        info("base uri : "+getConfig().baseURI());
        info("content type : "+getConfig().contentType());
        info("pay load : "+object);
        return given()
                .baseUri(getConfig().baseURI())
                .contentType(getConfig().contentType())
                .log()
                .all()
                .body(object)
                .post(getConfig().endPoint());
    }
}
