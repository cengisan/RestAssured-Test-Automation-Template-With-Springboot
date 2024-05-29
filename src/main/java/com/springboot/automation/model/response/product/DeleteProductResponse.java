package com.springboot.automation.model.response.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;


@Data
public class DeleteProductResponse {
    private int id;
    private String title;
    private String description;
    private int price;
    private double discountPercentage;
    private double rating;
    private int stock;
    private ArrayList<String> tags;
    private String brand;
    private String sku;
    private int weight;
    private String category;
    private String thumbnail;
    private ArrayList<String> images;
    @JsonProperty("isDeleted")
    private boolean isDeleted;
    private Dimensions dimensions;
    private String warrantyInformation;
    private String shippingInformation;
    private String availabilityStatus;
    private ArrayList<Review> reviews;
    private String returnPolicy;
    private int minimumOrderQuantity;
    private Meta meta;
    private Date deletedOn;

    @Data
    public static class Dimensions{
        private double width;
        private double height;
        private double depth;
    }
    @Data
    public static class Meta{
        private Date createdAt;
        private Date updatedAt;
        private String barcode;
        private String qrCode;
    }
    @Data
    public static class Review{
        private int rating;
        private String comment;
        private Date date;
        private String reviewerName;
        private String reviewerEmail;
    }
}
