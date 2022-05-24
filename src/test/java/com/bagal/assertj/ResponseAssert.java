package com.bagal.assertj;

import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import java.util.concurrent.TimeUnit;

public class ResponseAssert extends AbstractAssert<ResponseAssert, Response> {
    private ResponseAssert(Response response, Class<?> selfType) {
        super(response, selfType);
    }
    public static ResponseAssert verifyThat(Response response){
        return new ResponseAssert(response,ResponseAssert.class);
    }

    public ResponseAssert isSuccessfulPostResponse(){
        Assertions
                .assertThat(actual.getStatusCode())
                .withFailMessage(()->"status is not 201")
                .isEqualTo(201);
        return this;
    }

    public ResponseAssert hasHeaderApplicationJson(){
        Assertions
                .assertThat(actual.getContentType())
                .withFailMessage(()->"content type is not application json")
                .contains("application/json");
        return this;
    }

    public ResponseAssert hasResponseTimeLessThan(long seconds){
        Assertions
                .assertThat(actual.getTimeIn(TimeUnit.SECONDS))
                .withFailMessage(()->"time is not matching")
                .isLessThan(seconds);
        return this;
    }
}
