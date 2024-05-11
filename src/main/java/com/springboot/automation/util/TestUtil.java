package com.springboot.automation.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;


public class TestUtil {


    public static Object responseBodyMapper(Response response, Class<?> responseClass){
        try {
            return new ObjectMapper().readValue(response.getBody().asString(), responseClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String randomMsisdn() {
        Random random = new Random();
        int num1, num2, num3, num4;
        num1 = 5;
        num2 = random.nextInt(21) + 70; // between 71 and 91
        num3 = random.nextInt(899) + 100; // between 101 and 899
        num4 = random.nextInt(8999) + 1000; // between 1001 and 8999
        return (num1 + "" + num2 + "" + num3 + "" + num4);
    }


    public static String generateTransactionId() {
        Random random = new Random();
        String transactionId;
        int trxValue = random.nextInt(999999) + 9000000;
        transactionId = "TestAutomation-" + trxValue;
        return transactionId;
    }

    public static String readTextFromFile(String filePath){
        Path path = Paths.get(filePath);
        try {
            BufferedReader reader = Files.newBufferedReader(path);
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
