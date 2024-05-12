package com.springboot.automation.testclasses;

import com.springboot.automation.assertion.Assertion;
import com.springboot.automation.controller.ProductController;
import com.springboot.automation.model.request.product.AddNewProductRequest;
import com.springboot.automation.model.request.product.UpdateProductRequest;
import com.springboot.automation.model.response.product.AddNewProductResponse;
import com.springboot.automation.model.response.product.DeleteProductResponse;
import com.springboot.automation.model.response.product.GetSingleProductResponse;
import com.springboot.automation.model.response.product.UpdateProductResponse;
import com.springboot.automation.reporter.annotation.description.Description;
import com.springboot.automation.reporter.annotation.link.Link;
import com.springboot.automation.route.ProductControllerRoute;
import com.springboot.automation.util.TestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

@SpringBootTest
public class ProductControllerTestClass extends TestBase {

    @Autowired
    ProductController productController;

    @Test(priority = 1)
    @Link(url = "products/1") // After replacing the url in the LinkProcessor class with the jira baseurl, it is sufficient to add the jira task number here. For example JIRA-1234.
    @Description("Get product by id")
    public void TestCase_GetSingleProduct_Success(){

        AddNewProductRequest addNewProductRequest = new AddNewProductRequest();
        addNewProductRequest.setTitle("Pencil");

        GetSingleProductResponse getSingleProductResponse = productController.getSingleProduct(ProductControllerRoute.GET_PRODUCT("1"));
        Assertion.ResponseAssertion(getSingleProductResponse.getId(),1);
        Assertion.ResponseAssertion(getSingleProductResponse.getBrand(),"Apple");
    }

    @Test(priority = 2)
    @Link(url = "products/add") // After replacing the url in the LinkProcessor class with the jira baseurl, it is sufficient to add the jira task number here. For example JIRA-1234.
    @Description("Add new product")
    public void TestCase_AddNewProduct_Success(){

        AddNewProductRequest addNewProductRequest = new AddNewProductRequest();
        addNewProductRequest.setTitle("Pencil");

        AddNewProductResponse addNewProductResponse = productController.addNewProduct(ProductControllerRoute.PRODUCTS_ADD, addNewProductRequest);
        Assertion.ResponseAssertion(addNewProductResponse.getTitle(), addNewProductRequest.getTitle());
    }

    @Test(priority = 3)
    @Link(url = "products/1") // After replacing the url in the LinkProcessor class with the jira baseurl, it is sufficient to add the jira task number here. For example JIRA-1234.
    @Description("Update product")
    public void TestCase_UpdateProduct_Success(){

        UpdateProductRequest updateProductRequest = new UpdateProductRequest();
        updateProductRequest.setTitle("Book");

        UpdateProductResponse updateProductResponse = productController.updateProduct(ProductControllerRoute.UPDATE_PRODUCT("1"), updateProductRequest);
        Assertion.ResponseAssertion(updateProductResponse.getTitle(), updateProductRequest.getTitle());
    }

    @Test(priority = 4)
    @Link(url = "products/1") // After replacing the url in the LinkProcessor class with the jira baseurl, it is sufficient to add the jira task number here. For example JIRA-1234.
    @Description("Delete product")
    public void TestCase_DeleteProduct_Success(){

        DeleteProductResponse deleteProductResponse = productController.deleteProduct(ProductControllerRoute.DELETE_PRODUCT("1"));
        Assertion.ResponseAssertion(deleteProductResponse.getId(), 1);
        Assertion.ResponseAssertion(deleteProductResponse.getBrand(), "Apple");

    }
}
