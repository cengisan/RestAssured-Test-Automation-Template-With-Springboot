package com.springboot.automation.reporter.annotation.description;

import org.testng.ITestResult;

import java.lang.reflect.Method;

public class DescriptionProcessor {
    public static String descriptionInfo(ITestResult result) {
        String descriptionInfo;
        try {
            Class<?> clazz = Class.forName(result.getInstanceName());
            Method method = clazz.getMethod(result.getMethod().getMethodName());
            Description methodLink = method.getAnnotation(Description.class);

            if (methodLink == null) {
                descriptionInfo = "<b>Test Case description was not added!</b>";
            } else {
                String value = methodLink.value();
                descriptionInfo = "<b>Test Case Description: </b>" + value;
            }
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return descriptionInfo;
    }
}
