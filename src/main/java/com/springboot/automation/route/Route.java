package com.springboot.automation.route;

public class Route {

    public static final String AUTH_LOGIN = "/auth/login";
    public static final String AUTH_ME = "/auth/me";
    public static final String AUTH_REFRESH = "/auth/refresh";
    public static String CARTS_USER(String userId){
        return "/carts/user/" +userId;
    }
    public static final String CARTS_ADD = "/carts/add";
    public static String CARTS (String userId){
        return "carts/" + userId;
    }
    public static String DELETE_CART(String userId){
        return "carts/" + userId;
    }
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
