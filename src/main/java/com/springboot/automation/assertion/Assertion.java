package com.springboot.automation.assertion;

import org.testng.Assert;

public class Assertion {

    public static void ResponseAssertion(Object responseData, Object expectedData){
        Assert.assertEquals(responseData, expectedData);
    }

    public static void DatabaseAssertion(String databaseData, String expectedData){
        Assert.assertEquals(databaseData, expectedData);
    }

    public static void NotNullAssertion(Object responseData){
        Assert.assertNotNull(responseData);
    }
}
