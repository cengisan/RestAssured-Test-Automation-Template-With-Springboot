package com.springboot.automation.testclasses;

import com.springboot.automation.assertion.Assertion;
import com.springboot.automation.controller.AuthController;
import com.springboot.automation.controller.CartController;
import com.springboot.automation.model.request.auth.AuthRequest;
import com.springboot.automation.model.request.cart.AddNewCartRequest;
import com.springboot.automation.model.request.cart.UpdateCartRequest;
import com.springboot.automation.model.response.auth.AuthResponse;
import com.springboot.automation.model.response.cart.AddNewCartResponse;
import com.springboot.automation.model.response.cart.DeleteCartResponse;
import com.springboot.automation.model.response.cart.GetCartsOfUserResponse;
import com.springboot.automation.model.response.cart.UpdateCartResponse;
import com.springboot.automation.reporter.annotation.description.Description;
import com.springboot.automation.reporter.annotation.link.Link;
import com.springboot.automation.route.Route;
import com.springboot.automation.util.TestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

@SpringBootTest
public class CartControllerTestClass extends TestBase {

    @Autowired
    AuthController authController;
    @Autowired
    CartController cartController;
    int userId;

    @Test(priority = 1)
    @Link(url = "/carts/user/15") // After replacing the url in the LinkProcessor class with the jira baseurl, it is sufficient to add the jira task number here. For example JIRA-1234.
    @Description("Get carts of a user with userID")
    public void TestCase_GetCartsOfUser_Success(){

        AuthRequest authRequest = new AuthRequest();
        authRequest.setUsername("kminchelle");
        authRequest.setPassword("0lelplR");
        authRequest.setExpiresInMins(30);

        AuthResponse authenticateResponse = authController.AuthenticateWithUser(Route.AUTH_LOGIN, authRequest);
        userId = authenticateResponse.getId();

        GetCartsOfUserResponse getCartsOfUserResponse = cartController.getCartsOfUser(Route.CARTS_USER(String.valueOf(userId)));
        Assertion.NotNullAssertion(getCartsOfUserResponse.getCarts());
    }

    @Test(priority = 2)
    @Link(url = "/carts/add") // After replacing the url in the LinkProcessor class with the jira baseurl, it is sufficient to add the jira task number here. For example JIRA-1234.
    @Description("Add carts to a user with userID")
    public void TestCase_AddNewCartToUser_Success(){

        AddNewCartRequest.Product product = new AddNewCartRequest.Product();
        ArrayList<AddNewCartRequest.Product> products = new ArrayList<>();
        product.setId(1);
        product.setQuantity(1);
        products.add(product);

        AddNewCartRequest addNewCartRequest = new AddNewCartRequest();
        addNewCartRequest.setUserId(userId);
        addNewCartRequest.setProducts(products);

        AddNewCartResponse addNewCartResponse = cartController.addNewCartToUser(Route.CARTS_ADD, addNewCartRequest);
        Assertion.NotNullAssertion(addNewCartResponse.getProducts());
    }

    @Test(priority = 3)
    @Link(url = "/carts") // After replacing the url in the LinkProcessor class with the jira baseurl, it is sufficient to add the jira task number here. For example JIRA-1234.
    @Description("Update a user's cart with userID")
    public void TestCase_UpdateCart_Success(){

        UpdateCartRequest.Product product = new UpdateCartRequest.Product();
        ArrayList<UpdateCartRequest.Product> products = new ArrayList<>();
        product.setId(1);
        product.setQuantity(1);
        products.add(product);

        UpdateCartRequest updateCartRequest = new UpdateCartRequest();
        updateCartRequest.setMerge(true);
        updateCartRequest.setProducts(products);

        UpdateCartResponse updateCartResponse = cartController.updateCart(Route.CARTS(String.valueOf(userId)), updateCartRequest);
        Assertion.NotNullAssertion(updateCartResponse.getProducts());
    }

    @Test(priority = 4)
    @Link(url = "/carts/add") // After replacing the url in the LinkProcessor class with the jira baseurl, it is sufficient to add the jira task number here. For example JIRA-1234.
    @Description("Delete a user's cart with userID")
    public void TestCase_DeleteCart_Success(){

        DeleteCartResponse deleteCartResponse = cartController.deleteCart(Route.DELETE_CART(String.valueOf(userId)));
        Assertion.NotNullAssertion(deleteCartResponse.getProducts());

    }
}
