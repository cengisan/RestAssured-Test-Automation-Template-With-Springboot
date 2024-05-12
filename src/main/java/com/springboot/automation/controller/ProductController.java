package com.springboot.automation.controller;

import com.springboot.automation.model.request.product.AddNewProductRequest;
import com.springboot.automation.model.request.product.UpdateProductRequest;
import com.springboot.automation.model.response.product.AddNewProductResponse;
import com.springboot.automation.model.response.product.DeleteProductResponse;
import com.springboot.automation.model.response.product.GetSingleProductResponse;
import com.springboot.automation.model.response.product.UpdateProductResponse;
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
public class ProductController extends TestBase {

    RequestSpecification requestSpecification = new Specifications().apiRequestSpec();
    ResponseSpecification responseSpecification = new Specifications().apiResponseSpec();
    ExtentReporterListener listener = new ExtentReporterListener();

    public GetSingleProductResponse getSingleProduct(String path) {
        Response response = RestAssured.given(requestSpecification).
                filter(new RequestLoggingFilter(captor)).
                header("X-Transaction-Id", TestUtil.generateTransactionId()).
                when().
                get(path).
                then().spec(responseSpecification).
                extract().
                response();
        GetSingleProductResponse getSingleProductResponse = (GetSingleProductResponse) TestUtil.responseBodyMapper(response, GetSingleProductResponse.class);
        listener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return getSingleProductResponse;
    }

    public AddNewProductResponse addNewProduct(String path, AddNewProductRequest requestBody) {
        Response response = RestAssured.given(requestSpecification).
                filter(new RequestLoggingFilter(captor)).
                header("X-Transaction-Id", TestUtil.generateTransactionId()).
                when().
                body(requestBody).
                post(path).
                then().spec(responseSpecification).
                extract().
                response();
        AddNewProductResponse addNewProductResponse = (AddNewProductResponse) TestUtil.responseBodyMapper(response, AddNewProductResponse.class);
        listener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return addNewProductResponse;
    }

    public UpdateProductResponse updateProduct(String path, UpdateProductRequest requestBody) {
        Response response = RestAssured.given(requestSpecification).
                filter(new RequestLoggingFilter(captor)).
                header("X-Transaction-Id", TestUtil.generateTransactionId()).
                when().
                body(requestBody).
                put(path).
                then().spec(responseSpecification).
                extract().
                response();
        UpdateProductResponse updateProductResponse = (UpdateProductResponse) TestUtil.responseBodyMapper(response, UpdateProductResponse.class);
        listener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return updateProductResponse;
    }

    public DeleteProductResponse deleteProduct(String path) {
        Response response = RestAssured.given(requestSpecification).
                filter(new RequestLoggingFilter(captor)).
                header("X-Transaction-Id", TestUtil.generateTransactionId()).
                when().
                delete(path).
                then().spec(responseSpecification).
                extract().
                response();
        DeleteProductResponse deleteProductResponse = (DeleteProductResponse) TestUtil.responseBodyMapper(response, DeleteProductResponse.class);
        listener.requestAndResponseReporter(writer.toString(), response.prettyPrint());
        return deleteProductResponse;
    }
}
