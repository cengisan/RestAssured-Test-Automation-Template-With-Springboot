package com.springboot.automation.model.request.cart;

import lombok.Data;

import java.util.ArrayList;

@Data
public class UpdateCartRequest {

    private boolean merge;
    private ArrayList<Product> products;

    @Data
    public static class Product{
        private int id;
        private int quantity;
    }
}
