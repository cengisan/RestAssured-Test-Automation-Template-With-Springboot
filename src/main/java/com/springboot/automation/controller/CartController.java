package com.springboot.automation.controller;

import com.springboot.automation.model.request.cart.AddNewCartRequest;
import com.springboot.automation.model.request.cart.UpdateCartRequest;
import com.springboot.automation.model.response.cart.AddNewCartResponse;
import com.springboot.automation.model.response.cart.DeleteCartResponse;
import com.springboot.automation.model.response.cart.GetCartsOfUserResponse;
import com.springboot.automation.model.response.cart.UpdateCartResponse;
import com.springboot.automation.reporter.ExtentReporterListener;
import com.springboot.automation.specification.Specifications;
import com.springboot.automation.util.TestBase;
import com.springboot.automation.util.TestUtil;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.springframework.stereotype.Controller;


@Controller
public class CartController extends TestBase {

    RequestSpecification requestSpecification = new Specifications().apiRequestSpec();
    ResponseSpecification responseSpecification = new Specifications().apiResponseSpec();
    ExtentReporterListener listener = new ExtentReporterListener();

    public GetCartsOfUserResponse getCartsOfUser(String path) {
        Response response = RestAssured.given(requestSpecification).
                filter(new RequestLoggingFilter(captor)).
                header("X-Transaction-Id", TestUtil.generateTransactionId()).
                when().
                get(path).
                then().spec(responseSpecification).
                extract().
                response();
        GetCartsOfUserResponse getCartsOfUserResponse = (GetCartsOfUserResponse) TestUtil.responseBodyMapper(response, GetCartsOfUserResponse.class);
        listener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return getCartsOfUserResponse;
    }

    public AddNewCartResponse addNewCartToUser(String path, AddNewCartRequest requestBody) {
        Response response = RestAssured.given(requestSpecification).
                filter(new RequestLoggingFilter(captor)).
                header("X-Transaction-Id", TestUtil.generateTransactionId()).
                when().
                body(requestBody).
                post(path).
                then().spec(responseSpecification).
                extract().
                response();
        AddNewCartResponse addNewCartResponse = (AddNewCartResponse) TestUtil.responseBodyMapper(response, AddNewCartResponse.class);
        listener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return addNewCartResponse;
    }

    public UpdateCartResponse updateCart(String path, UpdateCartRequest requestBody) {
        Response response = RestAssured.given(requestSpecification).
                filter(new RequestLoggingFilter(captor)).
                header("X-Transaction-Id", TestUtil.generateTransactionId()).
                when().
                body(requestBody).
                put(path).
                then().spec(responseSpecification).
                extract().
                response();
        UpdateCartResponse updateCartResponse = (UpdateCartResponse) TestUtil.responseBodyMapper(response, UpdateCartResponse.class);
        listener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return updateCartResponse;
    }

    public DeleteCartResponse deleteCart(String path) {
        Response response = RestAssured.given(requestSpecification).
                filter(new RequestLoggingFilter(captor)).
                header("X-Transaction-Id", TestUtil.generateTransactionId()).
                when().
                delete(path).
                then().spec(responseSpecification).
                extract().
                response();
        DeleteCartResponse deleteCartResponse = (DeleteCartResponse) TestUtil.responseBodyMapper(response, DeleteCartResponse.class);
        listener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return deleteCartResponse;
    }

}
