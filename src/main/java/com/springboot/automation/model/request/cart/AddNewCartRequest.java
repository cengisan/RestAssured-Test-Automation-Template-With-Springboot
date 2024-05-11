package com.springboot.automation.model.request.cart;

import lombok.Data;

import java.util.ArrayList;

@Data
public class AddNewCartRequest {

    private int userId;
    private ArrayList<Product> products;

    @Data
    public static class Product{
        private int id;
        private int quantity;
    }

}
