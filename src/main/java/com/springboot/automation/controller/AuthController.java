package com.springboot.automation.controller;

import com.springboot.automation.model.request.auth.AuthRequest;
import com.springboot.automation.model.response.auth.GetCurrentAuthUserResponse;
import com.springboot.automation.model.response.auth.RefreshAuthSessionResponse;
import com.springboot.automation.specification.Specifications;
import com.springboot.automation.model.response.auth.AuthResponse;
import com.springboot.automation.reporter.ExtentReporterListener;
import com.springboot.automation.util.TestBase;
import com.springboot.automation.util.TestUtil;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.springframework.stereotype.Controller;

@Controller
public class AuthController extends TestBase {

    RequestSpecification requestSpecification = new Specifications().apiRequestSpec();
    ResponseSpecification responseSpecification = new Specifications().apiResponseSpec();
    ExtentReporterListener listener = new ExtentReporterListener();

    public AuthResponse AuthenticateWithUser(String path, AuthRequest requestBody) {
        Response response = RestAssured.given(requestSpecification).
                filter(new RequestLoggingFilter(captor)).
                header("X-Transaction-Id", TestUtil.generateTransactionId()).
                when().
                body(requestBody).
                post(path).
                then().spec(responseSpecification).
                extract().
                response();
        AuthResponse authResponse = (AuthResponse) TestUtil.responseBodyMapper(response, AuthResponse.class);
        listener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return authResponse;
    }

    public RefreshAuthSessionResponse RefreshAuthSession(String path, String token) {
        Response response = RestAssured.given(requestSpecification).
                filter(new RequestLoggingFilter(captor)).
                header("X-Transaction-Id", TestUtil.generateTransactionId()).
                header("Authorization", "Bearer " + token).
                when().
                post(path).
                then().spec(responseSpecification).
                extract().
                response();
        RefreshAuthSessionResponse refreshAuthSessionResponse = (RefreshAuthSessionResponse) TestUtil.responseBodyMapper(response, RefreshAuthSessionResponse.class);
        listener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return refreshAuthSessionResponse;
    }

    public GetCurrentAuthUserResponse GetCurrentAuthUser(String path, String token) {
        Response response = RestAssured.given(requestSpecification).
                filter(new RequestLoggingFilter(captor)).
                header("X-Transaction-Id", TestUtil.generateTransactionId()).
                header("Authorization","Bearer " + token).
                when().
                get(path).
                then().spec(responseSpecification).
                extract().
                response();
        GetCurrentAuthUserResponse getCurrentAuthUserResponse = (GetCurrentAuthUserResponse) TestUtil.responseBodyMapper(response, GetCurrentAuthUserResponse.class);
        listener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return getCurrentAuthUserResponse;
    }
}
