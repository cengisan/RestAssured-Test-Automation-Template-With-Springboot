package com.springboot.automation.model.response.product;

import lombok.Data;

import java.util.ArrayList;

@Data
public class UpdateProductResponse {

    private int id;
    private String title;
    private int price;
    private double discountPercentage;
    private int stock;
    private double rating;
    private ArrayList<String> images;
    private String thumbnail;
    private String description;
    private String brand;
    private String category;
}
