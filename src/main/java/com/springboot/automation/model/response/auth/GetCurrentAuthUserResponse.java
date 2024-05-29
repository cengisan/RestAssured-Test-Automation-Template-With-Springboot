package com.springboot.automation.model.response.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties
public class GetCurrentAuthUserResponse {

    private int id;
    private String firstName;
    private String lastName;
    private String maidenName;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String birthDate;
    private String image;
    private String bloodGroup;
    private int height;
    private double weight;
    private String eyeColor;
    private Hair hair;
    private String domain;
    private String ip;
    private Address address;
    private String macAddress;
    private String university;
    private Bank bank;
    private Company company;
    private String ein;
    private String ssn;
    private String userAgent;
    private Crypto crypto;
    private String role;

    @Data
    public static class Address{
        private String address;
        private String city;
        private Coordinates coordinates;
        private String postalCode;
        private String stateCode;
        private String state;
        private String country;
    }

    @Data
    public static class Bank{
        private String cardExpire;
        private String cardNumber;
        private String cardType;
        private String currency;
        private String iban;
    }

    @Data
    public static class Company{
        private Address address;
        private String department;
        private String name;
        private String title;
    }

    @Data
    public static class Coordinates{
        private double lat;
        private double lng;
    }

    @Data
    public static class Crypto{
        private String coin;
        private String wallet;
        private String network;
    }

    @Data
    public static class Hair{
        private String color;
        private String type;
    }
}
