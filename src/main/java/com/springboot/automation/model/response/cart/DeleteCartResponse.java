package com.springboot.automation.model.response.cart;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class DeleteCartResponse {
    private int id;
    private ArrayList<Product> products;
    private int total;
    private int discountedTotal;
    private int userId;
    private int totalProducts;
    private int totalQuantity;
    private boolean isDeleted;
    private String deletedOn;

    @Data
    public static class Product {
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
