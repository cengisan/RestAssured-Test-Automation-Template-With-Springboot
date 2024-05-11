package com.springboot.automation.model.response.cart;

import lombok.Data;

import java.util.ArrayList;

@Data
public class UpdateCartResponse {

    private int id;
    private ArrayList<Product> products;
    private int total;
    private int discountedTotal;
    private int userId;
    private int totalProducts;
    private int totalQuantity;

    @Data
    public static class Product{
        private int id;
        private String title;
        private int price;
        private int quantity;
        private int total;
        private double discountPercentage;
        private int discountedPrice;
        private String thumbnail;
    }
}
