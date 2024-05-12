package com.springboot.automation.route;

public class CartControllerRoute {

    public static String CARTS_USER(String userId){
        return "/carts/user/" +userId;
    }
    public static final String CARTS_ADD = "/carts/add";
    public static String CARTS (String userId){
        return "/carts/" + userId;
    }
    public static String DELETE_CART(String userId){
        return "/carts/" + userId;
    }
}
