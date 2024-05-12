package com.springboot.automation.route;

public class ProductControllerRoute {

    public static final String GET_PRODUCT (String productId){
        return "/products/" + productId;
    }
    public static final String PRODUCTS_ADD = "/products/add";
    public static String UPDATE_PRODUCT (String productId){
        return "/products/" + productId;
    }
    public static String DELETE_PRODUCT (String productId){
        return "/products/" + productId;
    }
}
