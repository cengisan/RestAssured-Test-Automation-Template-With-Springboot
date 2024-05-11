package com.springboot.automation.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

    public RequestSpecification apiRequestSpec() {

        return new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                setBaseUri("https://dummyjson.com/").
                log(LogDetail.ALL).build().config((RestAssuredConfig.config().httpClient(HttpClientConfig.httpClientConfig().setParam("http.socket.timeout", 60000))));
    }

    public ResponseSpecification apiResponseSpec() {
        return new ResponseSpecBuilder().
                build();
    }

}
