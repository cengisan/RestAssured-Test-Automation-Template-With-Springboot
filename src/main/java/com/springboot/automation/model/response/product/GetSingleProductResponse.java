package com.springboot.automation.model.response.product;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class GetSingleProductResponse {
    private int id;
    private String title;
    private String description;
    private int price;
    private double discountPercentage;
    private double rating;
    private int stock;
    private String brand;
    private String category;
    private String thumbnail;
    private ArrayList<String> images;
    private ArrayList<String> tags;
    private String sku;
    private int weight;
    private Dimensions dimensions;
    private ArrayList<Review> reviews;
    private Meta meta;
    private String warrantyInformation;
    private String shippingInformation;
    private String availabilityStatus;
    private String returnPolicy;
    private int minimumOrderQuantity;


    @Data
    public static class Dimensions{
        private double width;
        private double height;
        private double depth;
    }

    @Data
    public static class Review{
        private int rating;
        private String comment;
        private Date date;
        private String reviewerName;
        private String reviewerEmail;
    }

    @Data
    public static class Meta{
        private Date createdAt;
        private Date updatedAt;
        private String barcode;
        private String qrCode;
    }
}
